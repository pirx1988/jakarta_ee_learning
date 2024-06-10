package org.example;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Logger;
public class ColorSerializer extends JsonSerializer<Color> {
    private static final Logger logger = Logger.getLogger(ColorSerializer.class.getName());

    @Override
    public void serialize(Color color, JsonGenerator generator, SerializerProvider serializers) throws IOException {
        logger.info("Serializing color init ");
        if (color == null) {
            generator.writeNull();
        } else {
            String colorString = color.getRed() + "," + color.getGreen() + "," + color.getBlue();
            logger.info("Serializing color: " + colorString); // Add logging
            generator.writeString(colorString);
        }
    }
}
