package by.trjava.task01.dao.impl;

import by.trjava.task01.dao.ApplianceDAO;
import by.trjava.task01.entity.Appliance;
import by.trjava.task01.entity.criteria.Criteria;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author James Spleen
 */
public class FileApplianceDAOImpl implements ApplianceDAO {

    private static final String FILEPATH = "resources\\appliances_db.txt";
    private static final String PACKAGE_NAME = "by.trjava.task01.entity.";
    private static final String SEPARATOR = "=";
    private static final String EMPTY_STRING = "";

    @Override
    public List<Appliance> findBy(Criteria criteria) {

        List<Appliance> appliances = new ArrayList<>();
        String applianceGroupName = criteria.getApplianceGroupName();

        try {
            List<String> searchList = new ArrayList<>();
            FileReader fileReader = new FileReader(FILEPATH);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.equals(EMPTY_STRING)) {
                    String applianceName = line.substring(0, line.indexOf(":")).trim();
                    if (applianceName.equals(applianceGroupName)) {
                        searchList.add(line);
                    }
                }
            }

            if (searchList.isEmpty()) {
                return null;
            }

            List<String> keyValueList = new ArrayList<>();
            for (Map.Entry<String, Object> item : criteria.getCriteriaMap().entrySet()) {
                keyValueList.add(item.getKey() + SEPARATOR
                        + item.getValue().toString());
            }

            boolean flag;
            for (String s1 : searchList) {
                flag = true;
                for (String s2 : keyValueList) {
                    if (!s1.contains(s2)) {
                        flag = false;
                    }
                }
                if (flag) {
                    Object obj = Class.forName(PACKAGE_NAME + applianceGroupName).newInstance();
                    Appliance appliance = (Appliance) obj;
                    appliance.setFromString(s1);
                    appliances.add(appliance);
                }
            }

        } catch (FileNotFoundException | ClassNotFoundException
                | IllegalAccessException | InstantiationException e) {

        }
        return appliances;
    }
}
