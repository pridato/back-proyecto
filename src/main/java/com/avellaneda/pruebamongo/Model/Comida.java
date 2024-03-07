package com.avellaneda.pruebamongo.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Document(collection = "Comidas")
public class Comida {
    @Id
    private String id;
    private String nombre;
    private String tipo;
    private List<String> ingredientes;
    private InformacionAdicional informacionAdicional;
    private double precio;
    private String imagenBASE64;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class InformacionAdicional {
        private int calorias;
        private int grasas;
        private int proteinas;
        private int carbohidratos;
    }
}
