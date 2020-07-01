package by.trjava.task02.main;

import by.trjava.task02.entity.*;
import by.trjava.task02.entity.criteria.Criteria;
import by.trjava.task02.entity.criteria.SearchCriteria;
import by.trjava.task02.service.AirlineService;
import by.trjava.task02.service.ServiceFactory;
import by.trjava.task02.service.exception.CriteriaValidationException;
import by.trjava.task02.service.exception.ServiceException;
import by.trjava.task02.service.exception.WrongParameterException;
import by.trjava.task02.service.repository.PlaneRepository;
import by.trjava.task02.service.repository.RepositoryFactory;
import by.trjava.task02.service.repository.exception.PlaneRepositoryException;
import by.trjava.task02.service.repository.specification.PlaneSearchSpecification;
import by.trjava.task02.service.repository.specification.impl.PlaneSearchSpecificationImpl;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        AirlineService airlineService = serviceFactory.getAirlineService();

        Criteria passengerPlaneCriteria = new Criteria(PassengerPlane.class.getSimpleName());
        passengerPlaneCriteria.add(SearchCriteria.PassengerPlane.MANUFACTURER.toString(), "Boeing");

        RepositoryFactory repositoryFactory = RepositoryFactory.getInstance();
        PlaneRepository planeRepository = repositoryFactory.getPlaneRepository();

        try {
            List<Plane> planeList = airlineService.findPlanesByCriteria(passengerPlaneCriteria);
            planeRepository.addPlaneList(planeList);

            for (Plane plane : planeList) {
                System.out.println(plane.toString() + "\n");
            }

            System.out.println();

            List<Plane> planes = planeRepository.getPlanes();
            int totalPassengerCapacity = airlineService.calculateTotalPassengerCapacity(planes);
            System.out.println("total passenger capacity = " + totalPassengerCapacity);

            double totalCargoCapacity = airlineService.calculateTotalCargoCapacity(planes);
            System.out.println("total cargo capacity = " + totalCargoCapacity);

            System.out.println("\n");
            System.out.println("Before sorting by passenger capacity:");
            for (Plane plane : planes) {
                System.out.println(plane.getId() + " passengerCapacity=" + plane.getPassengerCapacity());
            }

            airlineService.sortByPassengerCapacity(planes);
            System.out.println();
            System.out.println("After sorting by passenger capacity:");

            for (Plane plane : planes) {
                System.out.println(plane.getId() + " passengerCapacity=" + plane.getPassengerCapacity());
            }

            List<Plane> newPlanes = new ArrayList<>(planeRepository.getPlanes());
            newPlanes.get(2).setPassengerCapacity(200);
            System.out.println("\n");
            System.out.println("Before sorting by passenger capacity and cargo capacity:");
            for (Plane plane : newPlanes) {
                System.out.println(plane.getId() + " passengerCapacity=" + plane.getPassengerCapacity()
                        + " cargoCapacity=" + plane.getCargoCapacity());
            }

            airlineService.sortByPassengerCapacityAndCargoCapacity(newPlanes);
            System.out.println();
            System.out.println("After sorting by passenger capacity and cargo capacity:");

            for (Plane plane : newPlanes) {
                System.out.println(plane.getId() + " " + plane.getModelName()
                        + " passengerCapacity=" + plane.getPassengerCapacity()
                        + " cargoCapacity=" + plane.getCargoCapacity());
            }

            System.out.println();
            PlaneSearchSpecification searchSpecification = new PlaneSearchSpecificationImpl();
            System.out.println("Search specification: ");
            Plane p = searchSpecification.findPlaneByID(85);
            System.out.println(p.getId() + " " + p.getManufacturer());

        } catch (CriteriaValidationException | ServiceException | WrongParameterException | PlaneRepositoryException e) {

        }
    }
}
