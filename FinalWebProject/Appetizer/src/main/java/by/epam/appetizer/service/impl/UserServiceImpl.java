package by.epam.appetizer.service.impl;

import by.epam.appetizer.dao.DAOFactory;
import by.epam.appetizer.dao.UserDAO;
import by.epam.appetizer.dao.exception.DAOException;

import by.epam.appetizer.service.UserService;
import by.epam.appetizer.service.exception.ServiceException;
import by.epam.appetizer.service.exception.EmailIsAlreadyUsedException;
import by.epam.appetizer.service.encryption.PasswordEncryptor;
import by.epam.appetizer.service.encryption.exception.EncryptionException;
import by.epam.appetizer.service.validation.InputDataValidator;
import by.epam.appetizer.service.validation.UserDataValidator;
import by.epam.appetizer.service.validation.exception.EmptyInputDataException;
import by.epam.appetizer.service.validation.exception.InvalidDataFormatException;
import by.epam.appetizer.service.validation.exception.PasswordsConsistencyException;

import by.epam.appetizer.entity.User;

import by.epam.appetizer.service.exception.IncorrectEmailException;
import by.epam.appetizer.service.exception.IncorrectPasswordException;

public class UserServiceImpl implements UserService {

    private final UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
    private final InputDataValidator inputDataValidator = InputDataValidator.getInstance();
    private final UserDataValidator userDataValidator = UserDataValidator.getInstance();
    private final PasswordEncryptor passwordEncryptor = PasswordEncryptor.getInstance();

    @Override
    public User signUp(String firstName, String lastName, String gender,
            String username, String phoneNumber, String email, String password,
            String confirmedPassword) throws ServiceException {

        if (inputDataValidator.isEmpty(firstName)
                || inputDataValidator.isEmpty(lastName)
                || inputDataValidator.isEmpty(gender)
                || inputDataValidator.isEmpty(username)
                || inputDataValidator.isEmpty(phoneNumber)
                || inputDataValidator.isEmpty(email)
                || inputDataValidator.isEmpty(password)
                || inputDataValidator.isEmpty(confirmedPassword)) {
            throw new EmptyInputDataException("Some input data is empty");
        }

        if (!userDataValidator.validate(firstName, lastName, username, email, password)) {
            throw new InvalidDataFormatException("Some sign up data has invalid format");
        }

        if (!userDataValidator.validatePasswordsConsistency(password, confirmedPassword)) {
            throw new PasswordsConsistencyException("Passwords don't match");
        }

        try {
            if (userDAO.checkIfEmailIsAlreadyUsed(email)) {
                throw new EmailIsAlreadyUsedException("Specified email is already used");
            }
        } catch (DAOException e) {
            throw new ServiceException("DAOException in UserServiceImpl, email checking failed " + e);
        }

        try {
            String encryptedPassword = passwordEncryptor.generateHash(email, password);
            int userId = userDAO.signUp(firstName, lastName, gender, username,
                    phoneNumber, email, encryptedPassword);
            return userDAO.getUserById(userId);
        } catch (EncryptionException e) {
            throw new ServiceException("EncryptionException in UserServiceImpl, encryption failed " + e);
        } catch (DAOException e) {
            throw new ServiceException("DAOException in UserServiceImpl, sign up failed " + e);
        }
    }

    @Override
    public User signIn(String email, String password) throws ServiceException {

        User user;
        if (inputDataValidator.isEmpty(email)
                || inputDataValidator.isEmpty(password)) {
            throw new EmptyInputDataException("Some input data is empty");
        }

        if (!userDataValidator.validate(email, password)) {
            throw new InvalidDataFormatException("Some sign in data has invalid format");
        }

        try {
            if (!userDAO.checkIfEmailIsAlreadyUsed(email)) {
                throw new IncorrectEmailException("Incorrect email");
            }
        } catch (DAOException e) {
            throw new ServiceException("DAOException in UserServiceImpl, email checking failed " + e);
        }

        try {
            user = userDAO.getUserByEmail(email);
            String encryptedPassword = user.getPassword();
            if (!encryptedPassword.equals(passwordEncryptor.generateHash(email, password))) {
                throw new IncorrectPasswordException("Incorrect password");
            }
        } catch (EncryptionException e) {
            throw new ServiceException("EncryptionException in UserServiceImpl, encryption failed " + e);
        } catch (DAOException e) {
            throw new ServiceException("DAOException in UserServiceImpl, sign in failed " + e);
        }
        return user;
    }
}
