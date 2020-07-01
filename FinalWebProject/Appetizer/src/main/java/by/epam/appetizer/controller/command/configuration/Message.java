package by.epam.appetizer.controller.command.configuration;

public final class Message {

    private Message() {
    }

    // Common
    public static final String EMPTY_INPUT_DATA = "message.emptyInputData";
    public static final String INVALID_DATA_FORMAT = "message.invalidDataFormat";

    // Sign up
    public static final String SUCCESSFUL_SIGN_UP = "message.successfulSignUp";
    public static final String PASSWORDS_DO_NOT_MATCH = "message.passwordsDoNotMatch";
    public static final String EMAIL_IS_ALREADY_USED = "message.emailIsAlreadyUsed";

    // Sign in
    public static final String SUCCESSFUL_SIGN_IN = "message.successfulSignIn";
    public static final String INCORRECT_EMAIL = "message.incorrectEmail";
    public static final String INCORRECT_PASSWORD = "message.incorrectPassword";

}
