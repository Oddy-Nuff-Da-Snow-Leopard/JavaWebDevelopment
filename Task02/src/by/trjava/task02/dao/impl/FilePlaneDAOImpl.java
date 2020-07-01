package by.trjava.task02.dao.impl;

import by.trjava.task02.dao.PlaneDAO;
import by.trjava.task02.dao.exception.DAOException;
import by.trjava.task02.dao.exception.DataNotFoundException;
import by.trjava.task02.dao.matcher.CriteriaMatcher;
import by.trjava.task02.entity.criteria.Criteria;

import static by.trjava.task02.util.config.FileConfig.FILE_PATH;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.log4j.Logger;

public class FilePlaneDAOImpl implements PlaneDAO {

    private static final Logger LOGGER = Logger.getLogger(FilePlaneDAOImpl.class);

    @Override
    public List<String> findLinesByCriteria(Criteria criteria)
            throws DataNotFoundException, DAOException {

        try (Stream<String> stream = Files.lines(Paths.get(FILE_PATH))) {

            CriteriaMatcher matcher = new CriteriaMatcher(criteria);

            List<String> lines = stream.filter(matcher::findMatch)
                    .collect(Collectors.toList());

            if (lines.isEmpty()) {
                LOGGER.warn("No data was found in the file!");
                throw new DataNotFoundException("No data was found in the file!");
            }
            return lines;

        } catch (NullPointerException e) {
            LOGGER.warn("DAO layer caught a NullPointerException!");
            throw new DAOException("DAO layer caught a NullPointerException!", e);
        } catch (IOException e) {
            LOGGER.warn("DAO layer caught an IOException!");
            throw new DAOException("DAO layer caught an IOException!", e);
        }
    }
}
