package com.codegym.dao;

import com.codegym.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AppUserDAO {
    @Autowired
    private EntityManager entityManager;

    public AppUser findUserAccount(String userName) {
        try {
            String sqlQuery = "select e from " + AppUser.class.getName() +
                    " e where e.userName = :userName";

            Query query = this.entityManager.createQuery(sqlQuery, AppUser.class);
            query.setParameter("userName", userName);
            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
