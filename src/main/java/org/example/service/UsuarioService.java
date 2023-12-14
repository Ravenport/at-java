package org.example.service;

import org.example.dto.UsuarioDTOInput;
import org.example.dto.UsuarioDTOOutput;
import org.example.model.Usuario;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private List<Usuario> data = new ArrayList<>();
    private ModelMapper modelMapper = new ModelMapper();

    public void adicionar(UsuarioDTOInput usuario) {
        Usuario usuarioMap = modelMapper.map(usuario, Usuario.class);
        data.add(usuarioMap);
    }

    public List<UsuarioDTOOutput> listar() {
        List<UsuarioDTOOutput> listUsuarios = new ArrayList<>();

        for (Usuario usuario : data) {
            listUsuarios.add(modelMapper.map(usuario, UsuarioDTOOutput.class));
        }

        return listUsuarios;
    }

    public void alterar(UsuarioDTOInput usuarioUpdt, Integer id) {
        Usuario usuarioMap = modelMapper.map(usuarioUpdt, Usuario.class);
        data.set(id, usuarioMap);
    }

    public UsuarioDTOOutput buscar(Integer id) {
        UsuarioDTOOutput usuarioSelecionado = new UsuarioDTOOutput();
        for (Usuario usuario : data) {
            if(usuario.getId().equals(id)) {
                usuarioSelecionado = modelMapper.map(usuario, UsuarioDTOOutput.class);
            }
        }
        return usuarioSelecionado;
    }

    public void excluir(Integer id) {
        for (Usuario usuario : data) {
            if(usuario.getId().equals(id)) {
                data.remove(usuario);
            }
        }
    }
}
