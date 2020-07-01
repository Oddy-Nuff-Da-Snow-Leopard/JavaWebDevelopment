package by.trjava.task02.service.comparator;

import by.trjava.task02.entity.Plane;
import java.util.Comparator;

public class ModelNameComparator implements Comparator<Plane> {

    @Override
    public int compare(Plane p1, Plane p2) {
        return p1.getModelName().compareTo(p2.getModelName());
    }
}
