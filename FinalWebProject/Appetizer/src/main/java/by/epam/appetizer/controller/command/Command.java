package by.epam.appetizer.controller.command;

import by.epam.appetizer.controller.command.exception.CommandException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws CommandException;
}
