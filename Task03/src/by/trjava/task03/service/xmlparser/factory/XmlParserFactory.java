package by.trjava.task03.service.xmlparser.factory;

import by.trjava.task03.service.xmlparser.exception.XmlParsingException;
import by.trjava.task03.service.xmlparser.impl.GemDomParser;
import by.trjava.task03.service.xmlparser.impl.GemSaxParser;
import by.trjava.task03.service.xmlparser.impl.GemStaxParser;
import by.trjava.task03.service.xmlparser.type.ParserType;
import by.trjava.task03.service.xmlparser.GemXmlParser;

public class XmlParserFactory {

    private XmlParserFactory() {
    }

    private static final XmlParserFactory INSTANCE = new XmlParserFactory();

    public static XmlParserFactory getInstance() {
        return INSTANCE;
    }

    public GemXmlParser createParser(String parserName)
            throws XmlParsingException {

        ParserType type = ParserType.valueOf(parserName.toUpperCase());
        GemXmlParser parser = null;

        switch (type) {
            case DOM: {
                parser = new GemDomParser();
                break;
            }
            case STAX: {
                parser = new GemStaxParser();
                break;
            }
            case SAX: {
                parser = new GemSaxParser();
                break;
            }
        }
        return parser;
    }
}
