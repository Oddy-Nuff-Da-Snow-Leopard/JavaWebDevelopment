package by.trjava.task01.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Alekseev Maksim
 */
public class Parser {

    private static final String STRING_PATTERN = "=(\\w+)";
    private static final String INTEGER_PATTERN = "=(\\w+)";
    private static final String DOUBLE_PATTERN = "=[0-9.]+";

    private static final String EQUAL = "=";

    public static String parseString(String str, String key) {
        String result = "";
        if (str != null && key != null) {
            Pattern pattern = Pattern.compile(key + STRING_PATTERN);
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                String s = matcher.group();
                result = s.substring(s.indexOf(EQUAL) + 1);
            }
        }
        return result;
    }

    public static int parseInt(String s, String key) {
        int result = 0;
        if (s != null && key != null) {
            Pattern pattern = Pattern.compile(key + INTEGER_PATTERN);
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                String str = matcher.group();
                str = str.substring(str.indexOf(EQUAL) + 1);
                result = Integer.parseInt(str);
            }
        }
        return result;
    }

    public static double parseDouble(String s, String key) {
        double result = 0;
        if (s != null && key != null) {
            Pattern pattern = Pattern.compile(key + DOUBLE_PATTERN);
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                String str = matcher.group();
                str = str.substring(str.indexOf(EQUAL) + 1);
                result = Double.parseDouble(str);
            }
        }
        return result;
    }
}
