package by.epam.appetizer.controller.command.provider;

import by.epam.appetizer.controller.command.impl.*;
import by.epam.appetizer.controller.command.impl.cart.*;
import by.epam.appetizer.controller.command.impl.order.*;
import by.epam.appetizer.controller.command.impl.user.*;
import by.epam.appetizer.controller.command.configuration.CommandName;
import by.epam.appetizer.controller.command.Command;

import static by.epam.appetizer.controller.command.configuration.CommandName.*;

import by.epam.appetizer.controller.command.provider.exception.CommandProviderException;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {

    private final Map<CommandName, Command> commandMap = new HashMap<>();

    private CommandProvider() {
        commandMap.put(SHOW_HOME_PAGE, new ShowHomePageCommand());
        commandMap.put(SHOW_ABOUT_PAGE, new ShowAboutPageCommand());
        commandMap.put(SHOW_MENU_PAGE, new ShowMenuPageCommand());

        commandMap.put(SHOW_SIGN_UP_PAGE, new ShowSignUpPageCommand());
        commandMap.put(SHOW_SIGN_IN_PAGE, new ShowSignInPageCommand());

        commandMap.put(SHOW_PERSONAL_CABINET_PAGE, new ShowPersonalCabinetPageCommand());
        commandMap.put(SHOW_ORDERS_LIST_PAGE, new ShowOrdersListPageCommand());
        commandMap.put(SHOW_ORDER_INFO_PAGE, new ShowOrderInfoPageCommand());
        commandMap.put(SHOW_ORDER_HISTORY_PAGE, new ShowOrderHistoryPageCommand());
        commandMap.put(SHOW_NEXT_PAGE, new ShowNextPageCommand());
        commandMap.put(SHOW_PREVIOUS_PAGE, new ShowPreviousPageCommand());
        commandMap.put(SHOW_ORDER_CONTENT_PAGE, new ShowOrderContentPageCommand());
        commandMap.put(CONFIRM_ORDER, new ConfirmOrderCommand());

        commandMap.put(SHOW_NEW_DISH_CATEGORY_PAGE, new ShowNewDishCategoryPageCommand());
        commandMap.put(SHOW_NEW_DISH_PAGE, new ShowNewDishPageCommand());

        commandMap.put(ADD_TO_CART, new AddToCartCommand());
        commandMap.put(SHOW_CART_PAGE, new ShowCartPageCommand());
        commandMap.put(UPDATE_QUANTITY, new UpdateQuantityCommand());
        commandMap.put(DELETE_FROM_CART, new DeleteFromCartCommand());
        commandMap.put(CLEAR_CART, new ClearCartCommand());

        commandMap.put(ADD_ORDER, new AddOrderCommand());
        commandMap.put(CANCEL_ORDER, new CancelOrderCommand());

        commandMap.put(SIGN_UP, new SignUpCommand());
        commandMap.put(CONFIRM_EMAIL, new SignUpCommand());
        commandMap.put(SIGN_IN, new SignInCommand());
        commandMap.put(LOGOUT, new LogoutCommand());

        commandMap.put(CHANGE_LOCALE, new ChangeLocaleCommand());
    }

    private static class CommandProviderHolder {

        private static final CommandProvider INSTANCE = new CommandProvider();
    }

    public static CommandProvider getInstance() {
        return CommandProviderHolder.INSTANCE;
    }

    public Command getCommand(String commandName) throws CommandProviderException {
        if (commandName == null) {
            throw new CommandProviderException("Command name equals null");
        }
        try {
            return commandMap.get(CommandName.valueOf(commandName.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new CommandProviderException("No such command");
        }
    }
}
