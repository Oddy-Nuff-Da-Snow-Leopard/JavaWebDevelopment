package by.trjava.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alekseev Maksim
 */
public class Criteria {

    private final String applianceGroupName;
    private final Map<String, Object> criteriaMap = new HashMap<>();

    public Criteria(String applianceGroupName) {
        this.applianceGroupName = applianceGroupName;
    }

    public Map<String, Object> getCriteriaMap() {
        return criteriaMap;
    }

    public String getApplianceGroupName() {
        return applianceGroupName;
    }

    public void add(String searchCriteria, Object value) {
        criteriaMap.put(searchCriteria, value);
    }
}
