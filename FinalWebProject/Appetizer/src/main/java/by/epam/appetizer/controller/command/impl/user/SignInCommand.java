package by.epam.appetizer.controller.command.impl.user;

import by.epam.appetizer.controller.command.Command;
import by.epam.appetizer.controller.command.exception.CommandException;

import by.epam.appetizer.service.ServiceFactory;
import by.epam.appetizer.service.UserService;
import by.epam.appetizer.service.UserCartService;
import by.epam.appetizer.service.exception.ServiceException;
import by.epam.appetizer.service.exception.IncorrectEmailException;
import by.epam.appetizer.service.exception.IncorrectPasswordException;
import by.epam.appetizer.service.validation.exception.EmptyInputDataException;
import by.epam.appetizer.service.validation.exception.InvalidDataFormatException;

import by.epam.appetizer.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.epam.appetizer.controller.command.configuration.ParameterName.*;
import static by.epam.appetizer.controller.command.configuration.Message.*;
import static by.epam.appetizer.controller.command.configuration.PathToJSP.HOME_PAGE_PATH;
import static by.epam.appetizer.controller.command.configuration.PathToJSP.SIGN_IN_PAGE_PATH;

public class SignInCommand implements Command {

    private final UserService userService = ServiceFactory.getInstance().getUserService();
    private final UserCartService userCartService = ServiceFactory.getInstance().getUserCartService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws CommandException {

        String pagePath = SIGN_IN_PAGE_PATH;
        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);

        HttpSession session = request.getSession(true);

        try {
            User user = userService.signIn(email, password);
            int userCartId = userCartService.addUserCart(user.getId());
            session.setAttribute(USER, user);
            session.setAttribute(USER_CART_ID, userCartId);
//             session.setAttribute(MAIN_PAGE_MESSAGE, SUCCESSFUL_SIGN_IN);
            pagePath = HOME_PAGE_PATH;

        } catch (EmptyInputDataException e) {
            session.setAttribute(SIGN_IN_PAGE_MESSAGE, EMPTY_INPUT_DATA);
        } catch (InvalidDataFormatException e) {
            session.setAttribute(SIGN_IN_PAGE_MESSAGE, INVALID_DATA_FORMAT);
        } catch (IncorrectEmailException e) {
            session.setAttribute(SIGN_IN_PAGE_MESSAGE, INCORRECT_EMAIL);
        } catch (IncorrectPasswordException e) {
            session.setAttribute(SIGN_IN_PAGE_MESSAGE, INCORRECT_PASSWORD);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return pagePath;
    }
}
