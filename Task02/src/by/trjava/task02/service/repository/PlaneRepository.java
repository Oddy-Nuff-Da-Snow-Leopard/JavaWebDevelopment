package by.trjava.task02.service.repository;

import by.trjava.task02.entity.Plane;
import by.trjava.task02.service.repository.exception.PlaneRepositoryException;
import java.util.List;

public interface PlaneRepository {

    List<Plane> getPlanes();

    void addPlane(Plane plane) throws PlaneRepositoryException;

    void addPlaneList(List<Plane> planes) throws PlaneRepositoryException;

    void removePlane(Plane plane) throws PlaneRepositoryException;

    void removeAll();

}
