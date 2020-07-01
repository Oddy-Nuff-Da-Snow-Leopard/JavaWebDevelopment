package by.trjava.task03.service.xmlparser.impl;
//Locking -> ======================================= <-
//это захват внешнего контекста
import by.trjava.task03.entity.Appearance;
import by.trjava.task03.entity.type.CutMethod;
import by.trjava.task03.entity.Gem;
import by.trjava.task03.entity.type.Preciousness;
import by.trjava.task03.entity.Property;
import by.trjava.task03.entity.tag.GemXmlTag;
import by.trjava.task03.service.xmlparser.exception.XmlParsingException;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import by.trjava.task03.service.xmlparser.GemXmlParser;

public class GemStaxParser implements GemXmlParser {

    public List<Gem> parse(String fileName) throws XmlParsingException {
        List<Gem> gems = new ArrayList<>();
        String tagName = null;
        Gem.Builder gemBuilder = null;
        Appearance.Builder appearanceBuilder = null;
        Property.Builder propertyBuilder = null;
        Gem gem;
        try {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = xmlInputFactory
                    .createXMLStreamReader(fileName, new FileInputStream(fileName));
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        tagName = reader.getLocalName();

                        if (tagName.equals(GemXmlTag.GEM.getValue())) {

                            gemBuilder = new Gem.Builder();
                            appearanceBuilder = new Appearance.Builder();
                            propertyBuilder = new Property.Builder();

                            gemBuilder.setId(reader.getAttributeValue(0));
                            gemBuilder.setPreciousness(Preciousness.fromValue(reader.getAttributeValue(1)));
                        }
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {

                        String tagValue = reader.getText().trim();
                        if (tagValue.isEmpty()) {
                            break;
                        }
                        GemXmlTag param = GemXmlTag.fromValue(tagName);
                        switch (param) {
                            case NAME: {
                                Objects.requireNonNull(gemBuilder).setName(tagValue);
                                break;
                            }
                            case ORIGIN: {
                                Objects.requireNonNull(gemBuilder).setOrigin(tagValue);
                                break;
                            }
                            case WEIGHT: {
                                Objects.requireNonNull(gemBuilder).setWeight(Double.parseDouble(tagValue));
                                break;
                            }
                            case COLOR: {
                                Objects.requireNonNull(appearanceBuilder).setColor(tagValue);
                                break;
                            }
                            case TRANSPARENCY: {
                                Objects.requireNonNull(appearanceBuilder).setTransparency(Integer.parseInt(tagValue));
                                break;
                            }
                            case CUT_METHOD: {
                                Objects.requireNonNull(appearanceBuilder).setCutMethod(CutMethod.fromValue(tagValue));
                                break;
                            }
                            case DENSITY: {
                                Objects.requireNonNull(propertyBuilder).setDensity(Double.parseDouble(tagValue));
                                break;
                            }
                            case REFRACTIVE_INDEX: {
                                Objects.requireNonNull(propertyBuilder).setRefractiveIndex(Double.parseDouble(tagValue));
                                break;
                            }
                            case MOHS_HARDNESS: {
                                Objects.requireNonNull(propertyBuilder).setRefractiveIndex(Integer.parseInt(tagValue));
                                break;
                            }
                        }
                        Objects.requireNonNull(gemBuilder).setAppearance(Objects.requireNonNull(appearanceBuilder).build());
                        Objects.requireNonNull(gemBuilder).setProperties(Objects.requireNonNull(propertyBuilder).build());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        tagName = reader.getLocalName();
                        if ((GemXmlTag.GEM.getValue()).equals(tagName)) {
                            gem = Objects.requireNonNull(gemBuilder).build();
                            gems.add(gem);
                        }
                        break;
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            throw new XmlParsingException("Xml parsin failed!", e);
        }
        return gems;
    }
}
