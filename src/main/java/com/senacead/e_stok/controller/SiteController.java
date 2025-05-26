package com.senacead.e_stok.controller;

import com.senacead.e_stok.model.Usuario;
import com.senacead.e_stok.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class SiteController {
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/")
    public String inicio(Model model){
        model.addAttribute("usuario", new Usuario());
        return "index";
    }
    
    @GetMapping("/pagina-inicial")
    public String paginaInicial(){
        return "pagina-inicial";
    }
    /*
    @GetMapping("/produto-cadastro")
    public String produtoCadastro(){
        return "produto-cadastro";
    }
    
    @GetMapping("/produto-lista")
    public String produtoLista(){
        return "produto-lista";
    }
  */
    
}
