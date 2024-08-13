package com.puce.turismo.Service;

import com.puce.turismo.Model.Usuario;
import com.puce.turismo.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository uRepository;

    public List<Usuario> findAll() {
        return uRepository.findAll();
    }

    public Usuario findById(String id) {
        return uRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return uRepository.save(usuario);
    }

    public void delete(String id) {
        uRepository.deleteById(id);
    }

    public Usuario autenticar (String username, String password) {
        return uRepository.findByUsernameAndPassword(username, password);
    }
}