package com.codegym.dao;

import com.codegym.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AppRoleDAO {
    @Autowired
    private EntityManager entityManager;

    public List<String> getRoleNames(Long userId) {
        String sqlQuery = "select ur.appRole.roleName from " +
                UserRole.class.getName() + " ur where ur.appUser.userId = :userId ";
        Query query = this.entityManager.createQuery(sqlQuery, String.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
