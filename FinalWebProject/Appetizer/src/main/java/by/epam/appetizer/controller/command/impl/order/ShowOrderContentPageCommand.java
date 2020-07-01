package by.epam.appetizer.controller.command.impl.order;

import by.epam.appetizer.controller.command.Command;
import static by.epam.appetizer.controller.command.configuration.ParameterName.CART_ITEMS;
import static by.epam.appetizer.controller.command.configuration.ParameterName.ORDER;
import static by.epam.appetizer.controller.command.configuration.PathToJSP.ORDER_CONTENT_PAGE_PATH;
import by.epam.appetizer.controller.command.exception.CommandException;
import static by.epam.appetizer.dao.util.configuration.ColumnLabel.ORDER_ID;
import by.epam.appetizer.entity.CartItem;
import by.epam.appetizer.entity.Order;
import by.epam.appetizer.service.OrderService;
import by.epam.appetizer.service.ServiceFactory;
import by.epam.appetizer.service.exception.ServiceException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowOrderContentPageCommand implements Command {

    private final OrderService orderService = ServiceFactory.getInstance().getOrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws CommandException {

        String orderId = request.getParameter(ORDER_ID);
        try {
            List<CartItem> cartItems = orderService.getAllCartItemsByOrderId(orderId);
            Order order = orderService.getOrderById(orderId);
            request.setAttribute(ORDER, order);
            request.setAttribute(CART_ITEMS, cartItems);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return ORDER_CONTENT_PAGE_PATH;
    }
}
