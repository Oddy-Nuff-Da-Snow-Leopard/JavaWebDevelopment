package by.trjava.task02.dao;

import by.trjava.task02.entity.criteria.Criteria;

import by.trjava.task02.dao.exception.DataNotFoundException;
import by.trjava.task02.dao.exception.DAOException;

import java.util.List;

public interface PlaneDAO {

    List<String> findLinesByCriteria(Criteria criteria)
            throws DataNotFoundException, DAOException;
}
