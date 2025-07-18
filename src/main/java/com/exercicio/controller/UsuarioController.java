package com.exercicio.controller;

import com.exercicio.conversordto.ConverterDTO;
import com.exercicio.entity.dto.BuscarDTO;
import com.exercicio.entity.dto.UsuarioDTO;
import com.exercicio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ConverterDTO converterDTO;

    @PostMapping
    public ResponseEntity<UsuarioDTO>criarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        var criar = usuarioService.criarUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(criar);
    }
    @GetMapping
    public ResponseEntity<List<BuscarDTO>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO>atualizarUsuario(@PathVariable Long id,@RequestBody UsuarioDTO usuarioDTO){
        var atualizar = usuarioService.atualizarUsuario(id, usuarioDTO);
        return ResponseEntity.status(HttpStatus.OK).body(atualizar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO>buscarPorId(@PathVariable Long id){
        var buscar = usuarioService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(buscar);
    }
}
