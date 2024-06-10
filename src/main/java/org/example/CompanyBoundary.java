package org.example;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CompanyBoundary {
    @PersistenceContext
    private EntityManager entityManager;

    public Company findCompany(Long id) {
        return entityManager.find(Company.class, id);
    }
}
