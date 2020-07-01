package by.trjava.task03.service.xmlparser.impl;

import by.trjava.task03.entity.Gem;
import by.trjava.task03.service.xmlparser.exception.XmlParsingException;
import by.trjava.task03.service.xmlparser.handler.GemSaxParserHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;
import by.trjava.task03.service.xmlparser.GemXmlParser;

public class GemSaxParser implements GemXmlParser {

    private final GemSaxParserHandler handler;
    private SAXParser saxParser;

    public GemSaxParser() throws XmlParsingException {
        handler = new GemSaxParserHandler();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            saxParser = factory.newSAXParser();

        } catch (SAXException | ParserConfigurationException e) {
            throw new XmlParsingException("SAX parser exeption!", e);
        }
    }

    @Override
    public List<Gem> parse(String fileName) throws XmlParsingException {
        try {
            saxParser.parse(fileName, handler);
        } catch (IOException | SAXException e) {
            throw new XmlParsingException("Xml parsing failed!", e);
        }
        return handler.getGems();
    }
}
