package by.trjava.task02.service.validation;

import by.trjava.task02.entity.criteria.Criteria;
import by.trjava.task02.entity.criteria.SearchCriteria;
import java.util.Arrays;
import java.util.Map;

public final class CriteriaValidator {

    private CriteriaValidator() {

    }

    public static boolean validateCriteria(Criteria criteria) {

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
            if (criteria.getGroupSearchName().equals(c.getSimpleName())) {
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
