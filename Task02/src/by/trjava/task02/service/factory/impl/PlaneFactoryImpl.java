package by.trjava.task02.service.factory.impl;

import by.trjava.task02.entity.Plane;
import by.trjava.task02.entity.PassengerPlane;
import by.trjava.task02.entity.CargoPlane;
import by.trjava.task02.entity.MailPlane;

import by.trjava.task02.service.factory.PlaneFactory;
import by.trjava.task02.service.factory.exception.PlaneCreationException;

import by.trjava.task02.service.type.Type.PlaneType;
import org.apache.log4j.Logger;

public class PlaneFactoryImpl implements PlaneFactory {

    private static final Logger LOGGER = Logger.getLogger(PlaneFactoryImpl.class);

    public Plane createPlane(PlaneType planeType) throws PlaneCreationException {
        Plane plane = null;
        switch (planeType) {
            case PassengerPlane:
                plane = new PassengerPlane();
                break;
            case CargoPlane:
                plane = new CargoPlane();
                break;
            case MailPlane:
                plane = new MailPlane();
                break;
            default:
                LOGGER.warn("Plane creation failed!"
                        + " Wrong type of plane {" + planeType + "}");
                throw new PlaneCreationException("Plane creation failed!"
                        + " Wrong type of plane {" + planeType + "}");
        }
        return plane;
    }
}
