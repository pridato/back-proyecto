package com.avellaneda.pruebamongo.Model;

import com.avellaneda.pruebamongo.utils.DiaLaboral;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@Document(collection = "Cocineros")
public class Cocinero {

    @Id
    private String id;
    private String usuario_id;
    private String especialidad;
    private String entrada;
    private String salida;
    private List<DiaLaboral> diasLaborales;
    private int aniosExperiencia;
    private Credenciales credenciales;
}
