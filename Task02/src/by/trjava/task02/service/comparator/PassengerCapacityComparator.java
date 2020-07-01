package by.trjava.task02.service.comparator;

import by.trjava.task02.entity.Plane;
import java.util.Comparator;

public class PassengerCapacityComparator implements Comparator<Plane> {

    @Override
    public int compare(Plane p1, Plane p2) {
        return Integer.compare(p1.getPassengerCapacity(), p2.getPassengerCapacity());
    }
}
