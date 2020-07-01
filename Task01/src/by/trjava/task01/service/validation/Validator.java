package by.trjava.task01.service.validation;

import by.trjava.task01.entity.criteria.SearchCriteria;
import by.trjava.task01.entity.criteria.Criteria;
import java.util.Arrays;
import java.util.Map;

/**
 *
 * @author James Spleen
 */
public class Validator {

    public static boolean validateCtiteria(Criteria criteria) {

        if (criteria == null) {
            return false;
        }

        Map<String, Object> criteriaMap = criteria.getCriteriaMap();
        for (Map.Entry<String, Object> item : criteriaMap.entrySet()) {
            String key = item.getKey();
            Object value = item.getValue();
            if (key == null || value == null) {
                return false;
            }
        }

        for (Class<?> c : SearchCriteria.class.getClasses()) {
            if (criteria.getApplianceGroupName().equals(c.getSimpleName())) {
                String enumConstants = Arrays.toString(c.getEnumConstants());
                boolean flag = false;
                for (String key : criteriaMap.keySet()) {
                    if (!enumConstants.contains(key)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
