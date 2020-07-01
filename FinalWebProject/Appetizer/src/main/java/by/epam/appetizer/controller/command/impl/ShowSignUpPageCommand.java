package by.epam.appetizer.controller.command.impl;

import by.epam.appetizer.controller.command.Command;
import static by.epam.appetizer.controller.command.configuration.PathToJSP.SIGN_UP_PAGE_PATH;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.appetizer.controller.command.exception.CommandException;

public class ShowSignUpPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws CommandException {
        return SIGN_UP_PAGE_PATH;
    }
}
