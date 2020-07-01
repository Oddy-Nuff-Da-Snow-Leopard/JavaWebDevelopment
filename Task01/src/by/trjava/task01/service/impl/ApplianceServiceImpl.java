package by.trjava.task01.service.impl;

import by.trjava.task01.dao.*;
import by.trjava.task01.entity.Appliance;
import by.trjava.task01.entity.criteria.Criteria;
import by.trjava.task01.service.ApplianceService;
import by.trjava.task01.service.exception.WrongArgumentException;
import by.trjava.task01.service.validation.Validator;
import java.util.List;

/**
 *
 * @author Alekseev Maksim
 */
public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public List<Appliance> findBy(Criteria criteria) throws WrongArgumentException {

        if (!Validator.validateCtiteria(criteria)) {
            throw new WrongArgumentException("Method received wrong arguments!");
        }

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        List<Appliance> appliances = applianceDAO.findBy(criteria);

        return appliances;
    }
}
