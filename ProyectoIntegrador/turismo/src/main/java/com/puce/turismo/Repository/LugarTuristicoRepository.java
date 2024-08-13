package com.puce.turismo.Repository;

import com.puce.turismo.Model.LugarTuristico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LugarTuristicoRepository extends MongoRepository<LugarTuristico, String> {
    
}