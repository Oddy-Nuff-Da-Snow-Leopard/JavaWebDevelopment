package by.trjava.task02.service;

import by.trjava.task02.service.impl.AirlineServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private final AirlineService applianceService = new AirlineServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public AirlineService getAirlineService() {
        return applianceService;
    }
}
