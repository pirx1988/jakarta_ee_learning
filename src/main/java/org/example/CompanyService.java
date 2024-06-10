package org.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.logging.Logger;

@ApplicationScoped // CDI bean without session specific
@Transactional  // proxy - transaction for every method
public class CompanyService {

    private static final Logger logger = Logger.getLogger(ColorSerializer.class.getName());


    @PersistenceContext
    private EntityManager entityManager;

    public Company findCompany(Long id) {
        logger.info("Test!!!!!!!!!!!");
        return entityManager.find(Company.class, id);
    }

    @Transactional
    public void insertTestCompanies() {
        Company company1 = new Company();
        company1.setId(4L);
        company1.setName("Payara");
        entityManager.persist(company1);

        Company company2 = new Company();
        company2.setId(5L);
        company2.setName("ACME");
        entityManager.persist(company2);

        Company company3 = new Company();
        company3.setId(6L);
        company3.setName("TEST");
        entityManager.persist(company3);

        entityManager.flush();
    }
}
