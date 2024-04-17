package com.avellaneda.pruebamongo.repository;

import com.avellaneda.pruebamongo.Model.Cocinero;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CocineroRepository extends MongoRepository<Cocinero, String> {
}
