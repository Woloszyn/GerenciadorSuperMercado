/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Essa classe serve para setar informações sobre produtos e para pegar essas informações
 * @author Eduardo Woloszyn, Leonardo Tadeu Jaques Steinke, Bruno Trindade e Silva, Denilson Laucsen
 * @version 1.0
 * @since 23/03/2018
 */
@Entity
@Table(name = "Estoque")
public class Produtos implements Serializable {
    @Id
    @Column(name = "id_Estoque")
    private int id ;
    
    
    private String nome ; 
    
    private int quantidade ;
    
    private double preco ;
    
    private String validade;
    
    private int lote ;
    
    @OneToMany
    @Column(name = "Filial")
    private Filial aFilial ; 
    
    @OneToMany
    @Column(name="Fornecedor")
    private Fornecedores fornecedor ;

   

    public Produtos() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public Filial getaFilial() {
        return aFilial;
    }

    public void setaFilial(Filial aFilial) {
        this.aFilial = aFilial;
    }

    public Fornecedores getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedores fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id;
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + this.quantidade;
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        hash = 43 * hash + Objects.hashCode(this.validade);
        hash = 43 * hash + this.lote;
        hash = 43 * hash + Objects.hashCode(this.aFilial);
        hash = 43 * hash + Objects.hashCode(this.fornecedor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produtos other = (Produtos) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (this.lote != other.lote) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.validade, other.validade)) {
            return false;
        }
        if (!Objects.equals(this.aFilial, other.aFilial)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produtos{" + "id=" + id + ", nome=" + nome + ", quantidade=" + quantidade + ", preco=" + preco + ", validade=" + validade + ", lote=" + lote + ", aFilial=" + aFilial + ", fornecedor=" + fornecedor + '}';
    }
    
    
    
    
}