package com.senacead.e_stok.service;

import com.senacead.e_stok.model.Produto;
import com.senacead.e_stok.model.Usuario;
import com.senacead.e_stok.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Usuario autenticar(String nome, String senha) {
    return usuarioRepository.findByNomeAndSenha(nome, senha);
    }
    
    public Usuario encontrarUsuario(int id){
        return usuarioRepository.findById(id).orElse(null);
    }
}
