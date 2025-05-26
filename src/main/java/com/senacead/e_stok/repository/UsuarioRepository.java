package com.senacead.e_stok.repository;

import com.senacead.e_stok.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Usuario findByNomeAndSenha(String nome, String senha);
}
