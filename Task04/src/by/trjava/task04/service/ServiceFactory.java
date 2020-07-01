package by.trjava.task04.service;

import by.trjava.task04.service.impl.MatrixServiceImpl;

public final class ServiceFactory {

    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private final MatrixService matrixService = new MatrixServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public MatrixService getMatrixService() {
        return matrixService;
    }
}
