package org.example;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.awt.*;
import java.util.logging.Logger;

@Converter(autoApply = true)
public class ColorConverter implements AttributeConverter<Color, String> {

    private static final Logger logger = Logger.getLogger(ColorSerializer.class.getName());


    @Override
    public String convertToDatabaseColumn(Color attribute) {
        logger.info("converter color color: " + attribute.toString()); // Add logging
        return attribute.getRed() +
                "," +
                attribute.getGreen() +
                "," +
                attribute.getBlue();
    }

    @Override
    public Color convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) {
            return null;
        }
        String[] parts = dbData.split(",");
        Color color = new Color(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        logger.info("Converting DB data to color: " + color.toString()); // Add logging
        return color;
    }
}
