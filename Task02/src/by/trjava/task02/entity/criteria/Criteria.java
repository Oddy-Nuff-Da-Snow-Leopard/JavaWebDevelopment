package by.trjava.task02.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public final class Criteria {

    private final String groupSearchName;

    private final Map<String, Object> criteriaMap = new HashMap<>();

    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    public String getGroupSearchName() {
        return groupSearchName;
    }

    public Map<String, Object> getCriteriaMap() {
        return new HashMap<>(criteriaMap);
    }

    public void add(String searchCriteria, Object value) {
        criteriaMap.put(searchCriteria, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Criteria criteria = (Criteria) obj;
        return groupSearchName.equals(criteria.groupSearchName)
                && criteriaMap.equals(criteria.criteriaMap);

    }

    @Override
    public int hashCode() {
        Object[] fields = new Object[]{groupSearchName, criteriaMap};
        int result = 1;
        for (Object field : fields) {
            result = 31 * result + (field == null ? 0 : field.hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString()).append("\n");
        str.append("groupSearchName=").append(groupSearchName).append("\n");
        str.append("criteriaMap: ").append(criteriaMap);
        return str.toString();
    }
}
