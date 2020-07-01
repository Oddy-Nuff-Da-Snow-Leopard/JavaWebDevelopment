package by.epam.appetizer.controller;

import by.epam.appetizer.controller.command.Command;
import static by.epam.appetizer.controller.command.configuration.ParameterName.COMMAND;
import by.epam.appetizer.controller.command.exception.CommandException;
import by.epam.appetizer.controller.command.provider.CommandProvider;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import static by.epam.appetizer.controller.command.configuration.PathToJSP.ERROR_PAGE;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(Controller.class);

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String commandName = request.getParameter(COMMAND);
        try {
            System.out.println("DO GET " + commandName);
            CommandProvider provider = CommandProvider.getInstance();
            Command command = provider.getCommand(commandName);
            String commandResult = command.execute(request, response);
            request.getRequestDispatcher(commandResult).forward(request, response);
        } catch (CommandException e) {
            LOGGER.error(e);
            response.sendRedirect(ERROR_PAGE);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String commandName = request.getParameter(COMMAND);
        try {
            System.out.println("DO POST " + commandName);
            CommandProvider provider = CommandProvider.getInstance();
            Command command = provider.getCommand(commandName);
            String commandResult = command.execute(request, response);
            response.sendRedirect(commandResult);
        } catch (CommandException e) {
            LOGGER.error(e);
            response.sendRedirect(ERROR_PAGE);
        }
    }
}
