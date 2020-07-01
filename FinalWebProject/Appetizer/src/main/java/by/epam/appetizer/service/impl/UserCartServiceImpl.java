package by.epam.appetizer.service.impl;

import by.epam.appetizer.service.UserCartService;
import by.epam.appetizer.service.exception.ServiceException;

import by.epam.appetizer.dao.DAOFactory;
import by.epam.appetizer.dao.UserCartDAO;
import by.epam.appetizer.dao.exception.DAOException;

public class UserCartServiceImpl implements UserCartService {

    private final UserCartDAO userCartDAO = DAOFactory.getInstance().getUserCartDAO();

    public int addUserCart(int userId) throws ServiceException {
        int userCartId;
//        final OrderDAO orderDAO = DAOFactory.getInstance().getOrderDAO();
        try {
//            Optional<CartUser> cartUserOptional = Optional.ofNullable(cartUserDAO.getLastCartUser(idUser));
//            Optional<Order> orderOptional = Optional.ofNullable(orderDAO.getLastOrderByUser(idUser));
//            if (cartUserOptional.isPresent() && orderOptional.isPresent()) {
//                if (!cartUserOptional.get().equals(orderOptional.get().getCartUser())) {
//                    idCartUser = cartUserOptional.get().getIdCartUser();
//                } else {
//                    idCartUser = cartUserDAO.addCartUser(idUser);
//                }
//            } else {
            userCartId = userCartDAO.addUserCart(userId);
//            }
            return userCartId;
        } catch (DAOException e) {
            throw new ServiceException("DAO Exception in CartUserService can't add cartUser" + e);
        }
    }
}
