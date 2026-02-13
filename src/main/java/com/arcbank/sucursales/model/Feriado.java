package com.arcbank.sucursales.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.arcbank.sucursales.converter.LocalDateConverter;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@DynamoDBDocument
@Getter
@Setter
public class Feriado {

    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = LocalDateConverter.class)
    private LocalDate fecha;
    @DynamoDBAttribute
    private String descripcion;
    @DynamoDBAttribute
    private String tipoFeriado;
    @DynamoDBAttribute
    private Boolean activo;

    public Feriado() { }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feriado feriado = (Feriado) o;
        return Objects.equals(fecha, feriado.fecha) &&
                Objects.equals(tipoFeriado, feriado.tipoFeriado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, tipoFeriado);
    }

    @Override
    public String toString() {
        return "Feriado{" +
                "fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                ", tipoFeriado='" + tipoFeriado + '\'' +
                ", activo=" + activo +
                '}';
    }

}
