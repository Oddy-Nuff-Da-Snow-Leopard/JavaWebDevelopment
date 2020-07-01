package by.trjava.task02.service.repository.impl;

import by.trjava.task02.entity.Plane;
import by.trjava.task02.service.repository.PlaneRepository;
import by.trjava.task02.service.repository.exception.PlaneRepositoryException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class PlaneRepositoryImpl implements PlaneRepository {

    private static final Logger LOGGER = Logger.getLogger(PlaneRepositoryImpl.class);

    private final List<Plane> planes = new ArrayList<>();

    @Override
    public List<Plane> getPlanes() {
        return new ArrayList<>(planes);
    }

    @Override
    public void addPlane(Plane plane) throws PlaneRepositoryException {
        if (plane == null) {
            LOGGER.warn("Attempt to add null element"
                    + " to collection!");
            throw new PlaneRepositoryException("Attempt to add null element"
                    + " to collection!");
        }
        planes.add(plane);
    }

    @Override
    public void addPlaneList(List<Plane> planeList) throws PlaneRepositoryException {
        if (planeList == null || planeList.isEmpty()) {
            LOGGER.warn("Attempt to add null or empty"
                    + " list to collection!");
            throw new PlaneRepositoryException("Attempt to add null or empty"
                    + " list to collection!");
        }
        planes.addAll(planeList);
    }

    @Override
    public void removePlane(Plane plane) throws PlaneRepositoryException {
        if (plane == null) {
            LOGGER.warn("Attempt to remove null element"
                    + " to collection!");
            throw new PlaneRepositoryException("Attempt to remove null element"
                    + " to collection!");
        }
        planes.remove(plane);
    }

    @Override
    public void removeAll() {
        planes.clear();
    }
}
