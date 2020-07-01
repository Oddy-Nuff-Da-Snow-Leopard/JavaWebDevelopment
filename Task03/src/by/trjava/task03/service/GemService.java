package by.trjava.task03.service;

import by.trjava.task03.entity.Gem;
import by.trjava.task03.service.exception.ServiceException;
import java.util.List;

public interface GemService {

    List<Gem> getGemsList(String xmlPath, String xsdPath,
            String parserName) throws ServiceException;
}
