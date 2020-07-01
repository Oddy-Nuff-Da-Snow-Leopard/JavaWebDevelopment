package by.epam.appetizer.controller.command.impl;

import by.epam.appetizer.controller.command.Command;
import static by.epam.appetizer.controller.command.configuration.PathToJSP.ABOUT_PAGE_PATH;
import by.epam.appetizer.controller.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowAboutPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws CommandException {
        return ABOUT_PAGE_PATH;
    }
}
