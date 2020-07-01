package by.epam.appetizer.controller.command.impl.user;

import by.epam.appetizer.controller.command.Command;
import static by.epam.appetizer.controller.command.configuration.ParameterName.LOCALE;
import static by.epam.appetizer.controller.command.configuration.ParameterName.REFERER;
import by.epam.appetizer.controller.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeLocaleCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws CommandException {

        HttpSession session = request.getSession(true);
        session.setAttribute(LOCALE, request.getParameter(LOCALE));
        return request.getHeader(REFERER);
    }
}
