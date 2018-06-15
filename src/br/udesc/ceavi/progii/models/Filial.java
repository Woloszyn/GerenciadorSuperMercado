/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe modelo para Filiais
 * @author Eduardo Woloszyn
 * @since 07/05/2018
 * @version 1.0
 */
@Entity
@Table(name = "Filial")
public class Filial implements Serializable {
    @Column(name = "nome_filial")
    private String nome ;
    @Id
    private String cnpj ;
    @Column(name = "cep_filial")
    private String cep ;
    @Column(name= "numero_filial")
    private int numero ;
    @Column(name = "cidade_filial")
    private String cidade ;
    @Column(name="rua_filial")
    private String rua ;
    @Column(name="bairro_filial")
    private String bairro ;
    
    public Filial() {
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
}

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.nome);
        hash = 19 * hash + Objects.hashCode(this.cnpj);
        hash = 19 * hash + Objects.hashCode(this.cep);
        hash = 19 * hash + this.numero;
        hash = 19 * hash + Objects.hashCode(this.cidade);
        hash = 19 * hash + Objects.hashCode(this.rua);
        hash = 19 * hash + Objects.hashCode(this.bairro);
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
        final Filial other = (Filial) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Filial{" + "nome=" + nome + ", cnpj=" + cnpj + ", cep=" + cep + ", numero=" + numero + ", cidade=" + cidade + ", rua=" + rua + ", bairro=" + bairro + '}';
    }

    
    
    
    
}
