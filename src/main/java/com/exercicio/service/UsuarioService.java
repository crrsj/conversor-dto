package com.exercicio.service;

import com.exercicio.conversordto.ConverterDTO;
import com.exercicio.entity.Usuario;
import com.exercicio.entity.dto.BuscarDTO;
import com.exercicio.entity.dto.UsuarioDTO;
import com.exercicio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ConverterDTO converterDTO;

    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
       var criarUsuario = converterDTO.usuarioParaDto(usuarioDTO);
       var converter = usuarioRepository.save(criarUsuario);
       return converterDTO.dtoParaEntidade(converter);

    }

    public List<BuscarDTO>  buscarTodos(){
       return usuarioRepository
               .findAll()
               .stream()
               .map(converterDTO::buscarUsuarioDtoParaEntidade)
               .toList();
   }
    public UsuarioDTO atualizarUsuario( Long id, UsuarioDTO usuarioDTO) {
    usuarioDTO.setId(id);
    var criarUsuario = converterDTO.usuarioParaDto(usuarioDTO);
    var converter = usuarioRepository.save(criarUsuario);
    return converterDTO.dtoParaEntidade(converter);
   }

   public UsuarioDTO buscarPorId(Long id){
        var buscar =  usuarioRepository.findById(id).orElseThrow();
        return converterDTO.dtoParaEntidade(buscar);

   }
}


