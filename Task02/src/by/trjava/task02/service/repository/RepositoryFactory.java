package by.trjava.task02.service.repository;

import by.trjava.task02.service.repository.impl.PlaneRepositoryImpl;

public final class RepositoryFactory {

    private static final RepositoryFactory INSTANCE = new RepositoryFactory();

    private final PlaneRepository planeRepository = new PlaneRepositoryImpl();

    private RepositoryFactory() {

    }

    public static RepositoryFactory getInstance() {
        return INSTANCE;
    }

    public PlaneRepository getPlaneRepository() {
        return planeRepository;
    }
}
