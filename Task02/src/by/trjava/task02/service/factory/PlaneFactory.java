package by.trjava.task02.service.factory;

import by.trjava.task02.entity.Plane;

import by.trjava.task02.service.factory.exception.PlaneCreationException;
import by.trjava.task02.service.type.Type.PlaneType;

public interface PlaneFactory {

    Plane createPlane(PlaneType planeType) throws PlaneCreationException;
}
