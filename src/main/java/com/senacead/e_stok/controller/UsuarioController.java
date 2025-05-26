package com.senacead.e_stok.controller;

import com.senacead.e_stok.model.Usuario;
import com.senacead.e_stok.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/login")
    public String processarLogin(@ModelAttribute Usuario usuario, Model model) {
        Usuario encontrado = usuarioService.autenticar(usuario.getNome(), usuario.getSenha());

        if (encontrado != null) {
            return "redirect:/pagina-inicial";
        } else {
            model.addAttribute("erro", "Usuário ou senha inválidos");
            return "index";
        }
    }
    
    
}
