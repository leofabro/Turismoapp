package com.puce.turismo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.puce.turismo.Model.Actividad;

public interface ActividadRepository extends MongoRepository<Actividad, String>{

}
