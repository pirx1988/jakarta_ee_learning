package org.example;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;

@Path("/company")
@RequestScoped
public class CompanyResource {

    @Inject
    private CompanyService companyService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Company getCompany(@PathParam("id") Long id) {
        return companyService.findCompany(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insert-companies}")
    public List<Company> insertCompanies() {
        companyService.insertTestCompanies();
        return List.of();
    }

}
