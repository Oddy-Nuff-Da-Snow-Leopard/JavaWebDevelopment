package by.epam.appetizer.controller.command.impl.user;

import by.epam.appetizer.controller.command.Command;
import by.epam.appetizer.controller.command.exception.CommandException;

import by.epam.appetizer.service.ServiceFactory;
import by.epam.appetizer.service.UserService;
import by.epam.appetizer.service.UserCartService;
import by.epam.appetizer.service.exception.ServiceException;
import by.epam.appetizer.service.exception.EmailIsAlreadyUsedException;
import by.epam.appetizer.service.validation.exception.EmptyInputDataException;
import by.epam.appetizer.service.validation.exception.InvalidDataFormatException;
import by.epam.appetizer.service.validation.exception.PasswordsConsistencyException;

import by.epam.appetizer.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.appetizer.controller.command.configuration.ParameterName.*;
import static by.epam.appetizer.controller.command.configuration.Message.*;
import static by.epam.appetizer.controller.command.configuration.PathToJSP.HOME_PAGE_PATH;
import static by.epam.appetizer.controller.command.configuration.PathToJSP.SIGN_UP_PAGE_PATH;
import by.epam.appetizer.service.TokenService;

public class SignUpCommand implements Command {

    private final UserService userService = ServiceFactory.getInstance().getUserService();
    private final TokenService tokenService = ServiceFactory.getInstance().getTokenService();
    private final UserCartService userCartService = ServiceFactory.getInstance().getUserCartService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws CommandException {

        String pagePath = SIGN_UP_PAGE_PATH;
        String firstName = request.getParameter(FIRST_NAME);
        String lastName = request.getParameter(LAST_NAME);
        String gender = request.getParameter(GENDER);
        String username = request.getParameter(USERNAME);
        String phoneNumber = request.getParameter(PHONE_NUMBER);
        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);
        String confirmedPassword = request.getParameter(CONFIRMED_PASSWORD);

        HttpSession session = request.getSession(true);
        try {
            User user = userService.signUp(firstName, lastName, gender,
                    username, phoneNumber, email, password, confirmedPassword);
//           tokenService.addToken(user);
            int userCartId = userCartService.addUserCart(user.getId());
            session.setAttribute(USER, user);
            session.setAttribute(USER_CART_ID, userCartId);
            session.setAttribute(MAIN_PAGE_MESSAGE, SUCCESSFUL_SIGN_UP);
            pagePath = HOME_PAGE_PATH;
        } catch (EmptyInputDataException e) {
            session.setAttribute(SIGN_UP_PAGE_MESSAGE, EMPTY_INPUT_DATA);
        } catch (InvalidDataFormatException e) {
            session.setAttribute(SIGN_UP_PAGE_MESSAGE, INVALID_DATA_FORMAT);
        } catch (PasswordsConsistencyException e) {
            session.setAttribute(SIGN_UP_PAGE_MESSAGE, PASSWORDS_DO_NOT_MATCH);
        } catch (EmailIsAlreadyUsedException e) {
            session.setAttribute(SIGN_UP_PAGE_MESSAGE, EMAIL_IS_ALREADY_USED);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return pagePath;
    }
}
