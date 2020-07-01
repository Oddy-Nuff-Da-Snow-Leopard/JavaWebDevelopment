package by.trjava.task01.main;

import by.trjava.task01.entity.*;
import by.trjava.task01.entity.criteria.*;
import by.trjava.task01.service.*;
import by.trjava.task01.service.exception.WrongArgumentException;

import java.util.List;

/**
 *
 * @author James Spleen
 */
public class Main {

    public static void main(String[] args) throws WrongArgumentException {

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService applianceService = factory.getApplianceService();

        Criteria ovenCriteria = new Criteria(Laptop.class.getSimpleName());
        
        ovenCriteria.add(SearchCriteria.Laptop.CPU.toString(), 1.2);
        ovenCriteria.add(SearchCriteria.Laptop.OS.toString(), "Windows");
        ovenCriteria.add(SearchCriteria.Laptop.MEMORY_ROM.toString(), 4000);

        List<Appliance> appliances = applianceService.findBy(ovenCriteria);
        for (Appliance a : appliances) {
            System.out.println(a.toString());
        }
    }
}
