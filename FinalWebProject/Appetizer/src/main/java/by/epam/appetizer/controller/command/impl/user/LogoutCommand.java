package by.epam.appetizer.controller.command.impl.user;

import by.epam.appetizer.controller.command.Command;
import by.epam.appetizer.controller.command.exception.CommandException;

import static by.epam.appetizer.controller.command.configuration.ParameterName.*;
import static by.epam.appetizer.controller.command.configuration.PathToJSP.HOME_PAGE_PATH;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws CommandException {
        
        HttpSession session = request.getSession(true);
        session.removeAttribute(USER);
        session.removeAttribute(USER_CART_ID);
        return HOME_PAGE_PATH;
    }

}
