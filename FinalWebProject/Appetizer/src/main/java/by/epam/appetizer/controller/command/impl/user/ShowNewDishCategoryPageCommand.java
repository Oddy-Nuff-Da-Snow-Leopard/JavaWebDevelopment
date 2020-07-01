package by.epam.appetizer.controller.command.impl.user;

import by.epam.appetizer.controller.command.Command;
import static by.epam.appetizer.controller.command.configuration.PathToJSP.NEW_DISH_CATEGORY_PAGE;
import by.epam.appetizer.controller.command.exception.CommandException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowNewDishCategoryPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws CommandException {
        return NEW_DISH_CATEGORY_PAGE;
    }
}
