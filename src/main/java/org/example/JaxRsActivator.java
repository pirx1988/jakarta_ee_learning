package org.example;

import com.fasterxml.jackson.core.util.JacksonFeature;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class JaxRsActivator extends Application {
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(EmployeeResource.class);
        classes.add(CompanyResource.class);
        classes.add(JacksonConfig.class);
        return classes;
    }
}
