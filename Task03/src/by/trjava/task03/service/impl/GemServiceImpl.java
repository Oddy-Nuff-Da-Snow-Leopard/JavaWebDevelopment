package by.trjava.task03.service.impl;

import by.trjava.task03.entity.Gem;

import by.trjava.task03.service.GemService;
import by.trjava.task03.service.exception.ServiceException;

import by.trjava.task03.service.xmlparser.exception.XmlParsingException;
import by.trjava.task03.service.xmlparser.factory.XmlParserFactory;
import by.trjava.task03.service.xmlparser.validation.XmlParserTypeValidator;
import by.trjava.task03.service.xmlparser.validation.exception.XmlParserNotFoundException;

import by.trjava.task03.service.xmlvalidator.XmlValidator;
import by.trjava.task03.service.xmlvalidator.exception.XmlValidationException;
import by.trjava.task03.service.xmlvalidator.impl.XmlValidatorImpl;
import java.util.List;
import by.trjava.task03.service.xmlparser.GemXmlParser;

public class GemServiceImpl implements GemService {

    public List<Gem> getGemsList(String xmlPath, String xsdPath, String parserType)
            throws ServiceException {

//        if (isNullOrEmpty(xmlPath)
//                || isNullOrEmpty(xsdPath)
//                || isNullOrEmpty(parserType)) {
//            throw new ServiceException("Illegal arguments");
//        }

        try {
            XmlParserTypeValidator xmlParserTypeValidator = new XmlParserTypeValidator();
            if (!xmlParserTypeValidator.validateType(parserType)) {
                throw new XmlParserNotFoundException("Wrong parser type! "
                        + "{parserName}");
            }

            XmlValidator xmlValidator = new XmlValidatorImpl();
            xmlValidator.validateByXSD(xmlPath, xsdPath);

            XmlParserFactory xmlParserFactory = XmlParserFactory.getInstance();
            GemXmlParser xmlParser = xmlParserFactory.createParser(parserType);
            return xmlParser.parse(xmlPath);

        } catch (XmlParserNotFoundException e) {
            throw new ServiceException("XmlParserNotFoundException!", e);
        } catch (XmlValidationException e) {
            throw new ServiceException("XmlValidationException!", e);
        } catch (XmlParsingException e) {
            throw new ServiceException("XmlParsingException!", e);
        }
    }

    private boolean isNullOrEmpty(String str) {
        return str != null && !str.isEmpty();
    }
}
