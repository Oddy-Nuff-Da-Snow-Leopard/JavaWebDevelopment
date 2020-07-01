package by.trjava.task03.service.xmlparser.handler;

import by.trjava.task03.entity.Appearance;
import by.trjava.task03.entity.type.CutMethod;
import by.trjava.task03.entity.Gem;
import by.trjava.task03.entity.type.Preciousness;
import by.trjava.task03.entity.Property;
import by.trjava.task03.entity.tag.GemXmlTag;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class GemSaxParserHandler extends DefaultHandler {

    private final List<Gem> gems = new ArrayList<>();
    private Gem.Builder gemBuilder;
    private Appearance.Builder appearanceBuilder;
    private Property.Builder propertyBuilder;

    private boolean name = false;
    private boolean origin = false;
    private boolean color = false;
    private boolean transparency = false;
    private boolean cutMethod = false;
    private boolean density = false;
    private boolean prefractiveIndex = false;
    private boolean MohsHardness = false;
    private boolean weight = false;

    public List<Gem> getGems() {
        return gems;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        GemXmlTag parameter = GemXmlTag.fromValue(qName);
        switch (parameter) {
            case GEM: {
                gemBuilder = new Gem.Builder();
                appearanceBuilder = new Appearance.Builder();
                propertyBuilder = new Property.Builder();

                gemBuilder.setId(attributes.getValue(GemXmlTag.ID.getValue()));
                gemBuilder.setPreciousness(Preciousness.fromValue(attributes.getValue(GemXmlTag.PRECIOUSNESS.getValue())));

            }
            break;

            case NAME: {
                name = true;
                break;
            }
            case ORIGIN: {
                origin = true;
                break;
            }
            case COLOR: {
                color = true;
                break;
            }
            case TRANSPARENCY: {
                transparency = true;
                break;
            }
            case CUT_METHOD: {
                cutMethod = true;
                break;
            }
            case DENSITY: {
                density = true;
                break;
            }
            case REFRACTIVE_INDEX: {
                prefractiveIndex = true;
                break;
            }
            case MOHS_HARDNESS: {
                MohsHardness = true;
                break;
            }
            case WEIGHT: {
                weight = true;
                break;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length);
        if (name) {
            gemBuilder.setName(value);
            name = false;
        } else if (origin) {
            gemBuilder.setOrigin(value);
            origin = false;
        } else if (color) {
            appearanceBuilder.setColor(value);
            color = false;
        } else if (transparency) {
            appearanceBuilder.setTransparency(Integer.parseInt(value));
            transparency = false;
        } else if (cutMethod) {
            appearanceBuilder.setCutMethod(CutMethod.fromValue(value));
            cutMethod = false;
        } else if (density) {
            propertyBuilder.setDensity(Double.parseDouble(value));
            density = false;
        } else if (prefractiveIndex) {
            propertyBuilder.setRefractiveIndex(Double.parseDouble(value));
            prefractiveIndex = false;
        } else if (MohsHardness) {
            propertyBuilder.setMohsHardness(Integer.parseInt(value));
            MohsHardness = false;
        } else if (weight) {
            gemBuilder.setWeight(Double.parseDouble(value));
            weight = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ((GemXmlTag.GEM.getValue()).equals(qName)) {
            gemBuilder.setProperties(propertyBuilder.build());
            gemBuilder.setAppearance(appearanceBuilder.build());
            gems.add(gemBuilder.build());
        }
    }
}
