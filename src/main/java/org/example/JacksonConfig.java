package org.example;

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.MessageBodyReader;


@Provider
public class JacksonConfig extends JacksonJsonProvider {
    public JacksonConfig() {
        super();
        // Additional configuration if needed
    }
}
