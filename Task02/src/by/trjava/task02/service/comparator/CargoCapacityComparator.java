package by.trjava.task02.service.comparator;

import by.trjava.task02.entity.Plane;
import java.util.Comparator;

public class CargoCapacityComparator implements Comparator<Plane> {

    @Override
    public int compare(Plane p1, Plane p2) {
        return Double.compare(p1.getCargoCapacity(), p2.getCargoCapacity());
    }
}
