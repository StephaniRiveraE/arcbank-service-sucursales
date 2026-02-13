package com.arcbank.sucursales.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import java.time.LocalDate;

/**
 * Convierte LocalDate a String (ISO-8601) para DynamoDB.
 */
public class LocalDateConverter implements DynamoDBTypeConverter<String, LocalDate> {

    @Override
    public String convert(LocalDate object) {
        return (object == null) ? null : object.toString();
    }

    @Override
    public LocalDate unconvert(String object) {
        return (object == null) ? null : LocalDate.parse(object);
    }
}
