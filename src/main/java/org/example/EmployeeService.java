package org.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.awt.*;
import java.util.List;

@Transactional
@ApplicationScoped
public class EmployeeService {

    @PersistenceContext
    private EntityManager em;

    public List<Employee> getAllEmployees() {
        return em.createQuery("SELECT e from Employee e", Employee.class).getResultList();
    }
    // it does work!!
    public void insertTestEmployee() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("John");
        employee.setLastName("Michalski");
        employee.setFavoriteColor(new Color(255, 0, 0)); // Red color
        em.persist(employee);
        em.flush();
    }
}
