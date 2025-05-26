package com.senacead.e_stok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SiteController {
    @GetMapping("/")
    public String inicio(){
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
