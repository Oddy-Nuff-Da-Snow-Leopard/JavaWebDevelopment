package by.trjava.task03.service;

import by.trjava.task03.service.impl.GemServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private final GemService gemService = new GemServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public GemService getGemService() {
        return gemService;
    }
}
