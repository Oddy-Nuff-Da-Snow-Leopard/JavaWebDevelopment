package by.trjava.task03.main;

import by.trjava.task03.entity.Gem;

import by.trjava.task03.service.GemService;
import by.trjava.task03.service.ServiceFactory;
import by.trjava.task03.service.exception.ServiceException;

import java.util.List;

public class Main {

    private static final String XML_PATH = "resources/gems.xml";
    private static final String XSD_PATH = "resources/gems.xsd";

    public static void main(String[] args) {
        String parserName = "sax";
        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            GemService gemService =  serviceFactory.getGemService();
            List<Gem> gems = gemService.getGemsList(XML_PATH, XSD_PATH, parserName);
            for (Gem g : gems) {
                Printer.print(g.toString());
            }
        } catch (ServiceException e) {
            
        } catch (Exception e) {

        }
    }
}
