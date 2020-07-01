package by.epam.appetizer.service.validation;

public final class InputDataValidator {

    private static final InputDataValidator INSTANCE = new InputDataValidator();

    private InputDataValidator() {
    }

    public static InputDataValidator getInstance() {
        return INSTANCE;
    }

    public boolean isEmpty(String value) {
        return value.length() == 0;
    }
}
