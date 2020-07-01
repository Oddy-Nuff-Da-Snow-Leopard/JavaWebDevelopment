package by.epam.appetizer.service.impl;

import by.epam.appetizer.dao.DAOFactory;
import by.epam.appetizer.dao.TokenDAO;
import by.epam.appetizer.dao.exception.DAOException;
import by.epam.appetizer.entity.User;
import by.epam.appetizer.service.TokenService;
import by.epam.appetizer.service.exception.ServiceException;
import by.epam.appetizer.service.mailing.EmailSender;
import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;

public class TokenServiceImpl implements TokenService {

    private final TokenDAO tokenDAO = DAOFactory.getInstance().getTokenDAO();

    @Override
    public void addToken(User user) throws ServiceException {
        try {
            String hash = DigestUtils.md5Hex(user.toString());
            tokenDAO.addToken(hash, new Date(), user.getId());
            EmailSender emailSender = new EmailSender();
            emailSender.send(user.getEmail(), "Registration", "http://localhost:8080/controller?command=confirm_email?confirmationCode=" + hash);
        } catch (DAOException e) {
            throw new ServiceException("DAOException in TokenServiceImpl,"
                    + " failed to add token " + e);
        }
    }

    @Override
    public void getTokenByHash(String hash) throws ServiceException {
        try {
            tokenDAO.getTokenByHash(hash);
        } catch (DAOException e) {
            throw new ServiceException("DAOException in TokenServiceImpl,"
                    + " failed to get token by hash " + e);
        }
    }
}
