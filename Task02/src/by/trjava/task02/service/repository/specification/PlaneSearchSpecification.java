package by.trjava.task02.service.repository.specification;

import by.trjava.task02.entity.Plane;
import java.util.List;

public interface PlaneSearchSpecification {

    Plane findPlaneByID(long id);

    List<Plane> findPlaneByIdRange(long firstLimit, long secondLimit);
}
