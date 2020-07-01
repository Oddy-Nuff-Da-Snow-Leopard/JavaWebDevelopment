package by.trjava.task01.service;

import by.trjava.task01.entity.Appliance;
import by.trjava.task01.entity.criteria.Criteria;
import by.trjava.task01.service.exception.WrongArgumentException;
import java.util.List;

/**
 *
 * @author Alekseev Maksim
 */
public interface ApplianceService {

    List<Appliance> findBy(Criteria criteria) throws WrongArgumentException;
}
