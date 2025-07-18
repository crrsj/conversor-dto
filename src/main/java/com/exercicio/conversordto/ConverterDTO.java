package com.exercicio.conversordto;

import com.exercicio.entity.Usuario;
import com.exercicio.entity.dto.BuscarDTO;
import com.exercicio.entity.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

@Component
public class ConverterDTO {
 public Usuario usuarioParaDto(UsuarioDTO usuarioDTO){
     var usuario = new Usuario();
     usuario.setId(usuarioDTO.getId());
     usuario.setNome(usuarioDTO.getNome());
     usuario.setFone(usuarioDTO.getFone());
     usuario.setEmail(usuarioDTO.getEmail());
     return usuario;
 }

 public UsuarioDTO dtoParaEntidade(Usuario usuario){
     var novoUsuario = new UsuarioDTO();
     novoUsuario.setId(usuario.getId());
     novoUsuario.setNome(usuario.getNome());
     novoUsuario.setFone(usuario.getFone());
     novoUsuario.setEmail(usuario.getEmail());
     return novoUsuario;
 }

    public BuscarDTO buscarUsuarioDtoParaEntidade(Usuario usuario){
        var buscarUsuario = new BuscarDTO();
        buscarUsuario.setId(usuario.getId());
        buscarUsuario.setNome(usuario.getNome());
        buscarUsuario.setFone(usuario.getFone());
        buscarUsuario.setEmail(usuario.getEmail());
        return buscarUsuario;
    }
}


