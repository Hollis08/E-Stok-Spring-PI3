package com.senacead.e_stok.service;

import com.senacead.e_stok.model.Produto;
import com.senacead.e_stok.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }
    
    public List<Produto> listarProduto(){
        return produtoRepository.findAll();
    }
    
    public Produto buscarPorId(int id){
        return produtoRepository.findById(id).orElse(null);
    }
    
    public void excluir(int id){
        produtoRepository.deleteById(id);
    }
    
}
