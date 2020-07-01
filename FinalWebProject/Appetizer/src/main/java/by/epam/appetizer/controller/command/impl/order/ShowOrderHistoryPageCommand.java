package by.epam.appetizer.controller.command.impl.order;

import by.epam.appetizer.controller.command.Command;
import static by.epam.appetizer.controller.command.configuration.ParameterName.*;
import static by.epam.appetizer.controller.command.configuration.PathToJSP.ORDER_HISTORY_PAGE_PATH;
import by.epam.appetizer.controller.command.exception.CommandException;
import by.epam.appetizer.entity.CartItem;
import by.epam.appetizer.entity.Order;
import by.epam.appetizer.entity.User;
import by.epam.appetizer.service.CartItemService;
import by.epam.appetizer.service.OrderService;
import by.epam.appetizer.service.ServiceFactory;
import by.epam.appetizer.service.exception.ServiceException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowOrderHistoryPageCommand implements Command {

    public static final int NUMBER_OF_ROWS_PER_PAGE = 5;
    public static final int FIRST_PAGE_NUMBER = 1;
    public static final int DEFAULT_NUMBER_OF_PAGE = 1;

    private final OrderService orderService = ServiceFactory.getInstance().getOrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        HttpSession session = request.getSession();
        int userId = ((User) session.getAttribute(USER)).getId();

        int firstIndex = 0;
        int lastIndex = firstIndex + NUMBER_OF_ROWS_PER_PAGE;

        try {
            List<Order> orders = orderService.getAllOrdersByUserId(userId);
            session.setAttribute("ordersFirstRow", firstIndex);
            session.setAttribute("ordersLastRow", lastIndex);

            int numberOfPages = (int) Math.ceil(orders.size() / (double) NUMBER_OF_ROWS_PER_PAGE);
            if (numberOfPages == 0) {
                numberOfPages = DEFAULT_NUMBER_OF_PAGE;
            }
            session.setAttribute("ordersNumberOfPages", numberOfPages);
            session.setAttribute("ordersCurrentPageNumber", FIRST_PAGE_NUMBER);

            session.setAttribute("orders", orders);

        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return ORDER_HISTORY_PAGE_PATH;
    }
}
