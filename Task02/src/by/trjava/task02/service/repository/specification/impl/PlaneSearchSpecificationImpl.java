package by.trjava.task02.service.repository.specification.impl;

import by.trjava.task02.entity.Plane;

import by.trjava.task02.service.repository.RepositoryFactory;

import java.util.List;
import by.trjava.task02.service.repository.specification.PlaneSearchSpecification;

public class PlaneSearchSpecificationImpl implements PlaneSearchSpecification {

    public Plane findPlaneByID(long id) {

        RepositoryFactory factory = RepositoryFactory.getInstance();

        List<Plane> planes = factory.getPlaneRepository().getPlanes();

        Plane result = null;
        for (Plane plane : planes) {
            if (plane.getId() == id) {
                result = plane;
                break;
            }
        }
        return result;
    }

    public List<Plane> findPlaneByIdRange(long firstLimit, long secondLimit) {

        RepositoryFactory factory = RepositoryFactory.getInstance();

        List<Plane> planes = factory.getPlaneRepository().getPlanes();

        List<Plane> result = null;
        for (Plane plane : planes) {
            long id = plane.getId();
            if (id >= firstLimit && id <= secondLimit) {
                result.add(plane);
            }
        }
        return result;
    }
}
