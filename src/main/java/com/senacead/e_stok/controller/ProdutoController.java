package com.senacead.e_stok.controller;

import com.senacead.e_stok.model.Produto;
import com.senacead.e_stok.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping("/produto-cadastro")
    public String exibirFormulario(Model model){
        model.addAttribute("produto", new Produto());
        return "produto-cadastro";
    }
    
    @PostMapping("gravar")
    public String processarFormulario(@ModelAttribute Produto produto){
        produtoService.salvar(produto);
        return "redirect:/produto-lista";
    }
    
    @GetMapping("/produto-lista")
    public String exibirListagem(Model model){
        model.addAttribute("produtos", produtoService.listarProduto());
        return "produto-lista";
    }
    
    @GetMapping("/produto-alterar/{id}")
    public String alterar(@PathVariable int id,Model model){
        model.addAttribute("produto", produtoService.buscarPorId(id));
        return "produto-cadastro";
    }
    
    @GetMapping("excluir/{id}")
    public String excluir(@PathVariable int id){
        produtoService.excluir(id);
        return "redirect:/produto-lista";
    }
    
    
    
}
