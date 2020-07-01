package by.epam.appetizer.controller.command.impl.order;

import by.epam.appetizer.controller.command.Command;
import static by.epam.appetizer.controller.command.configuration.PathToJSP.ORDER_HISTORY_PAGE_PATH;
import by.epam.appetizer.controller.command.exception.CommandException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowPreviousPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        HttpSession session = request.getSession(true);

        String parameterFirstRowName = request.getParameter("firstRow");
        String parameterLastRowName = request.getParameter("lastRow");
        String currentPageNumberParameterName = request.getParameter("currentPageNumber");
        
        int lastIndex = Integer.parseInt(session.getAttribute(parameterFirstRowName).toString());
        int firstIndex = lastIndex - 5;
        int currentPageNumber = Integer.parseInt(session.getAttribute(currentPageNumberParameterName).toString());

        if (currentPageNumber > 1) {
            session.setAttribute(currentPageNumberParameterName, (--currentPageNumber));
            session.setAttribute(parameterFirstRowName, firstIndex);
            session.setAttribute(parameterLastRowName, lastIndex);
        }

        return ORDER_HISTORY_PAGE_PATH;
    }
}
