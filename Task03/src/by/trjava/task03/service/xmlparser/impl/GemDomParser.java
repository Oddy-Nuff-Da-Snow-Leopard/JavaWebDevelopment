package by.trjava.task03.service.xmlparser.impl;

import by.trjava.task03.entity.Appearance;
import by.trjava.task03.entity.type.CutMethod;
import by.trjava.task03.entity.Gem;
import by.trjava.task03.entity.type.Preciousness;
import by.trjava.task03.entity.Property;
import by.trjava.task03.entity.tag.GemXmlTag;
import by.trjava.task03.service.xmlparser.exception.XmlParsingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import by.trjava.task03.service.xmlparser.GemXmlParser;

public class GemDomParser implements GemXmlParser {

    List<Gem> gems;
    Gem.Builder gemBuilder;

    @Override
    public List<Gem> parse(String fileName) throws XmlParsingException {
        DocumentBuilder documentBuilder;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new XmlParsingException("Xml parsing failed!", e);
        }

        gems = new ArrayList<>();
        try {
            Document document = documentBuilder.parse(fileName);
            Element root = document.getDocumentElement();
            NodeList nodeList = root.getElementsByTagName(GemXmlTag.GEM.getValue());

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                parseElement(element);
            }

        } catch (IOException | SAXException e) {
            throw new XmlParsingException("Xml parsing failed!", e);
        }
        return gems;
    }

    private void parseElement(Element element) {
        Gem gem = buildGem(element);
        gems.add(gem);
    }

    private Gem buildGem(Element element) {
        gemBuilder = new Gem.Builder();
        setFields(element);
        return gemBuilder.build();
    }

    private void setFields(Element element) {
        gemBuilder.setId(element.getAttribute(GemXmlTag.ID.getValue()));
        gemBuilder.setPreciousness(Preciousness.fromValue(element.getAttribute(GemXmlTag.PRECIOUSNESS.getValue())));
        gemBuilder.setName(getElementByTagName(element, GemXmlTag.NAME.getValue()));
        gemBuilder.setOrigin(getElementByTagName(element, GemXmlTag.ORIGIN.getValue()));
        gemBuilder.setAppearance(getAppearance(element));
        gemBuilder.setProperties(getProperty(element));
        gemBuilder.setWeight(Double.parseDouble(getElementByTagName(element, GemXmlTag.WEIGHT.getValue())));
    }

    private Appearance getAppearance(Element element) {
        Appearance.Builder appearanceBuilder = new Appearance.Builder();
        appearanceBuilder.setColor(getElementByTagName(element, GemXmlTag.COLOR.getValue()));
        appearanceBuilder.setTransparency(Integer.parseInt(getElementByTagName(element, GemXmlTag.TRANSPARENCY.getValue())));
        appearanceBuilder.setCutMethod(CutMethod.fromValue(getElementByTagName(element, GemXmlTag.CUT_METHOD.getValue())));
        return appearanceBuilder.build();
    }

    private Property getProperty(Element element) {
        Property.Builder propertiesBuilder = new Property.Builder();
        propertiesBuilder.setDensity(Double.parseDouble(getElementByTagName(element, GemXmlTag.DENSITY.getValue())));
        propertiesBuilder.setRefractiveIndex(Double.parseDouble(getElementByTagName(element, GemXmlTag.REFRACTIVE_INDEX.getValue())));
        propertiesBuilder.setMohsHardness(Integer.parseInt(getElementByTagName(element, GemXmlTag.MOHS_HARDNESS.getValue())));
        return propertiesBuilder.build();
    }

    private static String getElementByTagName(Element element, String tagName) {
        NodeList nList = element.getElementsByTagName(tagName);
        return nList.item(0).getTextContent();
    }
}
