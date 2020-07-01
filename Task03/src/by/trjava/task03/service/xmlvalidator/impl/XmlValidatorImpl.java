package by.trjava.task03.service.xmlvalidator.impl;

import by.trjava.task03.service.xmlvalidator.XmlValidator;
import by.trjava.task03.service.xmlvalidator.exception.XmlValidationException;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlValidatorImpl implements XmlValidator {

    @Override
    public void validateByXSD(String XMLPath, String XSDPath)
            throws XmlValidationException {

        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory schemaFactory = SchemaFactory.newInstance(language);

        try {
            File schemaLocation = new File(XSDPath);
            Schema schema = schemaFactory.newSchema(schemaLocation);
            Source source = new StreamSource(XMLPath);
            Validator validator = schema.newValidator();
            validator.validate(source);
        } catch (SAXException | IOException e) {
            throw new XmlValidationException("Xml file validation failed!", e);
        }
    }
}
