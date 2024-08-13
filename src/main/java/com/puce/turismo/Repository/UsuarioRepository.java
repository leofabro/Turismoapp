package com.puce.turismo.Repository;

import com.puce.turismo.Model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByUsernameAndPassword(String username, String password);
}