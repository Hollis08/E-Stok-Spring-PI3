package com.senacead.e_stok.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Table(name="Produto")
@Component
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codigo;
    private String nome;
    private double valor;
    private String categoria;
    private Date validade;
    private int quantidade; 
}
