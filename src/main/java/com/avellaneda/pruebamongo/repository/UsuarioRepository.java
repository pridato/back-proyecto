package com.avellaneda.pruebamongo.repository;

import com.avellaneda.pruebamongo.Model.Usuarios;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuarios, String> {
}
