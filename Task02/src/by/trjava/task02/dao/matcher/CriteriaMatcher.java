package by.trjava.task02.dao.matcher;

import by.trjava.task02.entity.criteria.Criteria;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class CriteriaMatcher {

    private static final String EQUAL_SIGN = "=";

    private static final String REGEX = ":\\s*|,\\s*";

    private Map<String, Object> criteriaMap = new HashMap<>();

    private final String groupSearchName;

    public CriteriaMatcher(Criteria criteria) {
        this.criteriaMap = criteria.getCriteriaMap();
        this.groupSearchName = criteria.getGroupSearchName();
    }

    private String[] splitLine(String line) {
        return line.split(REGEX);
    }

    public boolean findMatch(String line) {

        return line.contains(groupSearchName)
                && criteriaMap.entrySet().stream()
                        .allMatch(e -> Arrays.stream(splitLine(line))
                        .anyMatch(s -> s.equals(e.getKey()
                        + EQUAL_SIGN + e.getValue().toString())));
    }
}
