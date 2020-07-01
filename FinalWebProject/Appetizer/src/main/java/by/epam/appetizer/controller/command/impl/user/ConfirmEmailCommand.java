package by.epam.appetizer.controller.command.impl.user;

import by.epam.appetizer.controller.command.Command;
import by.epam.appetizer.controller.command.exception.CommandException;
import by.epam.appetizer.entity.Token;
import by.epam.appetizer.service.ServiceFactory;
import by.epam.appetizer.service.TokenService;
import by.epam.appetizer.service.UserCartService;
import by.epam.appetizer.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfirmEmailCommand implements Command {

    private final UserService userService = ServiceFactory.getInstance().getUserService();
    private final TokenService tokenService = ServiceFactory.getInstance().getTokenService();
    private final UserCartService userCartService = ServiceFactory.getInstance().getUserCartService();

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws CommandException {

        String confirmationCode = request.getParameter("confirmationCode");
        HttpSession session = request.getSession(true);
//        int userId = tokenService.getUserIdByTokenHash(confirmationCode);
//
//        if (userId != 0) {
//
//            User user = userRepository.findByEmailIdIgnoreCase(token.getUser().getEmailId());
//            user.setEnabled(true);
//            userRepository.save(user);
//            modelAndView.setViewName("accountVerified");
//        } else {
//            modelAndView.addObject("message", "The link is invalid or broken!");
//            modelAndView.setViewName("error");
//        }
//
//        return modelAndView;
        return null;
    }
}
