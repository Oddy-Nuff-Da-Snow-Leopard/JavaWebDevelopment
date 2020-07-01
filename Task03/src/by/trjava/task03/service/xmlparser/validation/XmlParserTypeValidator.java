package by.trjava.task03.service.xmlparser.validation;

import by.trjava.task03.service.xmlparser.type.ParserType;
import java.util.Arrays;

public class XmlParserTypeValidator {

    private static final String[] PARSERS_TYPES = Arrays.stream(ParserType.values())
            .map(Enum::name).toArray(String[]::new);

    public boolean validateType(String parserType) {
        return Arrays.stream(PARSERS_TYPES).anyMatch(s -> s.equalsIgnoreCase(parserType));
    }
}