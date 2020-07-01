package by.trjava.task01.service.impl;

import by.trjava.task01.entity.Appliance;
import by.trjava.task01.entity.Oven;
import by.trjava.task01.entity.criteria.Criteria;
import by.trjava.task01.entity.criteria.SearchCriteria;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author James Spleen
 */
public class ApplianceServiceImplTest {

    @Test
    public void testFindByNullCriteria() {
        Criteria criteria = null;
        ApplianceServiceImpl instance = new ApplianceServiceImpl();
        List<Appliance> expResult = null;
        List<Appliance> result = instance.findBy(criteria);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindByNullKeyAndValue() {
        Criteria ovenCriteria = new Criteria(Oven.class.getSimpleName());
        ovenCriteria.add(null, null);
        ApplianceServiceImpl instance = new ApplianceServiceImpl();
        List<Appliance> expResult = null;
        List<Appliance> result = instance.findBy(ovenCriteria);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindByNullKey() {
        Criteria ovenCriteria = new Criteria(Oven.class.getSimpleName());
        ovenCriteria.add(null, 33);
        ApplianceServiceImpl instance = new ApplianceServiceImpl();
        List<Appliance> expResult = null;
        List<Appliance> result = instance.findBy(ovenCriteria);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindByNullValue() {
        Criteria ovenCriteria = new Criteria(Oven.class.getSimpleName());
        ovenCriteria.add(SearchCriteria.Oven.CAPACITY.toString(), null);
        ApplianceServiceImpl instance = new ApplianceServiceImpl();
        List<Appliance> expResult = null;
        List<Appliance> result = instance.findBy(ovenCriteria);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindByOvenCapacity() {
        Criteria ovenCriteria = new Criteria(Oven.class.getSimpleName());
        ovenCriteria.add(SearchCriteria.Oven.CAPACITY.toString(), 32);
        ApplianceServiceImpl instance = new ApplianceServiceImpl();
        List<Appliance> expResult = new ArrayList<>();
        Oven oven = new Oven(1000, 10, 32, 60, 45.5, 59.5);
        expResult.add(oven);
        List<Appliance> result = instance.findBy(ovenCriteria);
        assertEquals(expResult, result);
    }

}
