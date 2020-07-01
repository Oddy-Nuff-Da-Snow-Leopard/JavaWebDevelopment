package by.trjava.task02.service;

import by.trjava.task02.entity.Plane;
import by.trjava.task02.entity.criteria.Criteria;

import by.trjava.task02.service.exception.CriteriaValidationException;
import by.trjava.task02.service.exception.ServiceException;
import by.trjava.task02.service.exception.WrongParameterException;

import java.util.List;

public interface AirlineService {

    public List<Plane> findPlanesByCriteria(Criteria criteria)
            throws CriteriaValidationException, ServiceException;

    public int calculateTotalPassengerCapacity(List<Plane> planes)
            throws WrongParameterException;

    public double calculateTotalCargoCapacity(List<Plane> planes)
            throws WrongParameterException;

    public void sortByPassengerCapacity(List<Plane> planes)
            throws WrongParameterException;

    public void sortByPassengerCapacityAndCargoCapacity(List<Plane> planes)
            throws WrongParameterException;

    public void sortByManufacturerAndModelName(List<Plane> planes)
            throws WrongParameterException;

    public List<Plane> findByFuelConsumptionRange(List<Plane> planes,
            int firstLimit, int secondLimit) throws WrongParameterException;
}
