package by.epam.appetizer.service.validation;

public class UserDataValidator {

    private static final String FIRST_NAME_REGEX_PATTERN = "^[A-Z]{1}[a-z]{1,20}|[А-Я]{1}[а-я]{1,20}$";
    private static final String LAST_NAME_REGEX_PATTERN = "^[A-Z]{1}[a-z]{1,25}|[А-Я]{1}[а-я]{1,25}$";
    private static final String USERNAME_REGEX_PATTERN = "^[a-zA-ZА-Яа-я][a-zA-ZА-Яа-я0-9-_/.]{3,20}$";
    private static final String EMAIL_REGEX_PATTERN = "^(.+)@(.+)$";
    private static final String PASSWORD_REGEX_PATTERN = "^[a-zA-ZА-Яа-я0-9_/.]{4,30}$";

    private static final UserDataValidator INSTANCE = new UserDataValidator();

    private UserDataValidator() {
    }

    public static UserDataValidator getInstance() {
        return INSTANCE;
    }

    public boolean validate(String firstName, String lastName, String username,
            String email, String password) {
        return validateFirstName(firstName) && validateLastName(lastName)
                && validateUsername(username) && validate(email, password);
    }

    public boolean validate(String email, String password) {
        return validateEmail(email) && validatePassword(password);
    }

    public boolean validateFirstName(String firstName) {
        return firstName.matches(FIRST_NAME_REGEX_PATTERN);
    }

    public boolean validateLastName(String lastName) {
        return lastName.matches(LAST_NAME_REGEX_PATTERN);
    }

    public boolean validateUsername(String username) {
        return username.matches(USERNAME_REGEX_PATTERN);
    }

    public boolean validateEmail(String email) {
        return email.matches(EMAIL_REGEX_PATTERN);
    }

    public boolean validatePassword(String password) {
        return password.matches(PASSWORD_REGEX_PATTERN);
    }

    public boolean validatePasswordsConsistency(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
}
