package by.trjava.task03.service.xmlparser;

import by.trjava.task03.entity.Gem;
import by.trjava.task03.service.xmlparser.exception.XmlParsingException;
import java.util.List;

public interface GemXmlParser {
    List<Gem> parse(String fileName) throws XmlParsingException;
}
