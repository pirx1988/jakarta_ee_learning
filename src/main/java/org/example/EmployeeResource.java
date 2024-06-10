package org.example;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.logging.Logger;

@Path("/employee")
@RequestScoped
public class EmployeeResource {

    @Inject
    private EmployeeService employeeService;

    private static final Logger logger = Logger.getLogger(EmployeeService.class.getName());


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Employee> getEmployees() {
        logger.info("Retrieving all employees");
        return employeeService.getAllEmployees();
    }

    @GET
    @Path("/insert-new-employee")
    @Produces(MediaType.TEXT_PLAIN)
    public String insertEmployee() {
        this.employeeService.insertTestEmployee();
        return "TEST OK";
    }

}
