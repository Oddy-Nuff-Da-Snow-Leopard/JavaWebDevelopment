package by.trjava.task02.service.impl;

import by.trjava.task02.service.exception.WrongParameterException;
import by.trjava.task02.service.type.Type;
import java.util.Arrays;
import org.apache.log4j.Logger;

public final class AirlineServiceHelper {

    private static final Logger LOGGER = Logger.getLogger(AirlineServiceHelper.class);

    public static final int ZERO = 0;

    public static final String COLON_SIGN = ":";
    public static final String EMPTY_STRING = "";

    public static final String REPLACE_REGEX = "[:,;]";
    public static final String SPLIT_REGEX = "\\s*\\w*=";

    private AirlineServiceHelper() {

    }

    private static boolean isNullOrEmpty(String line) {
        return line == null || line.isEmpty();
    }

    public static Type.PlaneType determinePlaneType(String line) throws WrongParameterException {
        if (isNullOrEmpty(line)) {
            LOGGER.warn("Method received wrong parameter!");
            throw new WrongParameterException("Method received wrong parameter!");
        }
        return Type.PlaneType.valueOf(line.substring(ZERO, line.lastIndexOf(COLON_SIGN)));
    }

    public static String[] getFieldsValues(String line) throws WrongParameterException {
        if (isNullOrEmpty(line)) {
            LOGGER.warn("Method received wrong parameter!");
            throw new WrongParameterException("Method received wrong parameter!");
        }
        line = line.substring(line.lastIndexOf(COLON_SIGN)).
                replaceAll(REPLACE_REGEX, EMPTY_STRING);

        return Arrays.stream(line.split(SPLIT_REGEX)).
                filter(t -> !t.isEmpty()).toArray(String[]::new);
    }
}
