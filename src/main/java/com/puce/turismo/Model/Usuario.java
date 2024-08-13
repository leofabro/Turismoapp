package com.puce.turismo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String idU;

    private String username;
    private String password;

    // Constructor
    public Usuario(String idU, String username, String password) {
        this.idU = idU;
        this.username = username;
        this.password = password;
    }

    // Constructor vacío
    public Usuario() {
    }

    public String getIdU() {
        return idU;
    }

    public void setIdU(String idU) {
        this.idU = idU;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
