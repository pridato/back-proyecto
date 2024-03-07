package com.avellaneda.pruebamongo.controller;

import com.avellaneda.pruebamongo.Model.RestMessage;
import com.avellaneda.pruebamongo.Model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.avellaneda.pruebamongo.repository.UsuarioRepository;

import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // save a new user post

    @PostMapping("/add")
    public ResponseEntity<?> saveUsuario(@RequestBody Usuarios usuario){
        try {
            usuario.setId(String.valueOf(UUID.randomUUID()));
            usuarioRepository.save(usuario);

            // preparar restMessage para enviar
            RestMessage message = new RestMessage(200, "Usuario creado", null, null, usuario, null);

            return ResponseEntity.status(200).body(message);
        } catch(Exception e){
            RestMessage message = new RestMessage(500, "Error", e.getMessage(), null, null, null);
            return ResponseEntity.status(500).body(message);
        }
    }

    // get all users
    @GetMapping
    public ResponseEntity<?> getAllUsuarios(){
        try {
            return ResponseEntity.status(200).body(usuarioRepository.findAll());
        } catch(Exception e){
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    // get user by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable String id){
        try {
            return ResponseEntity.status(200).body(usuarioRepository.findById(id));
        } catch(Exception e){
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    // updte user, find by id and update the full user
    @PostMapping("/update")
    public ResponseEntity<?> updateUsuario(@RequestBody Usuarios usuario){
        try {
            usuarioRepository.save(usuario);
            return ResponseEntity.status(200).body("Usuario actualizado");
        } catch(Exception e){
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}
