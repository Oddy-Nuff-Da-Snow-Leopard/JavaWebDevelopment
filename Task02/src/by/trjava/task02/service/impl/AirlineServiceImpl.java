package by.trjava.task02.service.impl;

import static by.trjava.task02.service.impl.AirlineServiceHelper.*;

import java.util.List;
import by.trjava.task02.entity.criteria.Criteria;

import by.trjava.task02.dao.DAOFactory;
import by.trjava.task02.dao.PlaneDAO;
import by.trjava.task02.dao.exception.DAOException;
import by.trjava.task02.dao.exception.DataNotFoundException;

import by.trjava.task02.entity.Plane;

import by.trjava.task02.service.AirlineService;
import by.trjava.task02.service.setter.PlaneSetter;

import by.trjava.task02.service.comparator.*;

import by.trjava.task02.service.exception.CriteriaValidationException;
import by.trjava.task02.service.exception.ServiceException;
import by.trjava.task02.service.exception.WrongParameterException;

import by.trjava.task02.service.factory.PlaneFactory;
import by.trjava.task02.service.factory.exception.PlaneCreationException;
import by.trjava.task02.service.factory.impl.PlaneFactoryImpl;
import by.trjava.task02.service.setter.exception.PlaneSettingException;

import by.trjava.task02.service.type.Type.PlaneType;

import by.trjava.task02.service.validation.CriteriaValidator;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Comparator;

public class AirlineServiceImpl implements AirlineService {

    private static final Logger LOGGER = Logger.getLogger(AirlineServiceImpl.class);

    @Override
    public List<Plane> findPlanesByCriteria(Criteria criteria)
            throws CriteriaValidationException, ServiceException {

        if (!CriteriaValidator.validateCriteria(criteria)) {
            LOGGER.warn("Criteria validation failed!");
            throw new CriteriaValidationException("Criteria validation failed!");
        }

        DAOFactory factory = DAOFactory.getInstance();
        PlaneDAO planeDAO = factory.getPlaneDAO();

        try {
            List<String> lines = planeDAO.findLinesByCriteria(criteria);

            PlaneFactory planeFactory = new PlaneFactoryImpl(); // ???

            List<Plane> planes = new ArrayList<>();

            for (String line : lines) {

                PlaneType planeType = determinePlaneType(line);
                Plane plane = planeFactory.createPlane(planeType);

                String[] fieldsValues = getFieldsValues(line);
                PlaneSetter.setFromLine(planeType, plane, fieldsValues);

                planes.add(plane);
            }
            return planes;

        } catch (DataNotFoundException e) {
            LOGGER.warn("Service layer caught a DataNotFoundException!");
            throw new ServiceException("Service layer caught a DataNotFoundException!", e);
        } catch (DAOException e) {
            LOGGER.warn("Service layer caught a DAOException!");
            throw new ServiceException("Service layer caught a DAOException!", e);
        } catch (WrongParameterException e) {
            LOGGER.warn("Service layer caught a WrongArgumentException!");
            throw new ServiceException("Service layer caught a WrongArgumentException!", e);
        } catch (PlaneCreationException e) {
            LOGGER.warn("Service layer caught a PlaneCreationException!");
            throw new ServiceException("Service layer caught a PlaneCreationException!", e);
        } catch (PlaneSettingException e) {
            LOGGER.warn("Service layer caught a PlaneSettingException!");
            throw new ServiceException("Service layer caught a PlaneSettingException!", e);
        } catch (Exception e) {
            LOGGER.warn("Service layer caught some Exception!");
            throw new ServiceException("Service layer caught some Exception!", e);
        }
    }

    private boolean isNullOrEmpty(List<Plane> planes) {
        return planes == null || planes.isEmpty();
    }

    @Override
    public int calculateTotalPassengerCapacity(List<Plane> planes)
            throws WrongParameterException {
        if (isNullOrEmpty(planes)) {
            LOGGER.warn("Method received wrong parameter! List is null or empty!");
            throw new WrongParameterException("Method received wrong parameter! List is null or empty!");
        }
        int result = 0;
        for (Plane plane : planes) {
            result += plane.getPassengerCapacity();
        }
        return result;
    }

    @Override
    public double calculateTotalCargoCapacity(List<Plane> planes)
            throws WrongParameterException {
        if (isNullOrEmpty(planes)) {
            LOGGER.warn("Method received wrong parameter! List is null or empty!");
            throw new WrongParameterException("Method received wrong parameter! List is null or empty!");
        }
        int result = 0;
        for (Plane plane : planes) {
            result += plane.getCargoCapacity();
        }
        return result;

    }

    @Override
    public void sortByPassengerCapacity(List<Plane> planes)
            throws WrongParameterException {
        if (isNullOrEmpty(planes)) {
            LOGGER.warn("Method received wrong parameter! List is null or empty!");
            throw new WrongParameterException("Method received wrong parameter! List is null or empty!");
        }
        Comparator<Plane> comparator = new PassengerCapacityComparator();
        planes.sort(comparator);
    }

    @Override
    public void sortByPassengerCapacityAndCargoCapacity(List<Plane> planes)
            throws WrongParameterException {
        if (isNullOrEmpty(planes)) {
            LOGGER.warn("Method received wrong parameter! List is null or empty!");
            throw new WrongParameterException("Method received wrong parameter! List is null or empty!");
        }
        Comparator<Plane> comparator = new PassengerCapacityComparator()
                .thenComparing(new CargoCapacityComparator());
        planes.sort(comparator);
    }

    @Override
    public void sortByManufacturerAndModelName(List<Plane> planes)
            throws WrongParameterException {
        if (isNullOrEmpty(planes)) {
            LOGGER.warn("Method received wrong parameter! List is null or empty!");
            throw new WrongParameterException("Method received wrong parameter! List is null or empty!");
        }
        Comparator<Plane> comparator = new ManufacturerComparator()
                .thenComparing(new ModelNameComparator());
        planes.sort(comparator);
    }

    @Override
    public List<Plane> findByFuelConsumptionRange(List<Plane> planes,
            int firstLimit, int secondLimit) throws WrongParameterException {
        if (isNullOrEmpty(planes) || firstLimit < 0 || secondLimit < 0) {
            LOGGER.warn("Method received wrong parameter! List is null or empty!");
            throw new WrongParameterException("Method received wrong parameter! List is null or empty!");
        }
        List<Plane> result = null;

        for (Plane plane : planes) {
            int fuelConsumption = plane.getFuelConsumption();
            if (fuelConsumption >= firstLimit && fuelConsumption <= secondLimit) {
                result.add(plane);
            }
        }

        return result;
    }

}
