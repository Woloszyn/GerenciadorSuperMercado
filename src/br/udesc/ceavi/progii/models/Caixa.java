/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *Esta classe define os métodos que o Caixa irá gerenciar
 * @author Eduardo Woloszyn, Leonardo Tadeu Jaques Steinke, Bruno Trindade e Silva, Denilson Laucsen
 * @version 1.0
 * @since 23/03/2018 teste
 */
@Entity
public class Caixa implements Serializable {
    @Column(name = "saldo")
    private double saldo ; 
    
    @Column(name="entrada")
    private double entrada;
    
    @Column(name = "saida")
    private double saida ;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_saldo;
    public Caixa() {
    }

    public Caixa(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getEntrada() {
        return entrada;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }

    public double getSaida() {
        return saida;
    }

    public void setSaida(double saida) {
        this.saida = saida;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.entrada) ^ (Double.doubleToLongBits(this.entrada) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.saida) ^ (Double.doubleToLongBits(this.saida) >>> 32));
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
        final Caixa other = (Caixa) obj;
        if (Double.doubleToLongBits(this.saldo) != Double.doubleToLongBits(other.saldo)) {
            return false;
        }
        if (Double.doubleToLongBits(this.entrada) != Double.doubleToLongBits(other.entrada)) {
            return false;
        }
        if (Double.doubleToLongBits(this.saida) != Double.doubleToLongBits(other.saida)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Caixa{" + "saldo=" + saldo + ", entrada=" + entrada + ", saida=" + saida + '}';
    }

    public Long getId_saldo() {
        return id_saldo;
    }

    public void setId_saldo(Long id_saldo) {
        this.id_saldo = id_saldo;
    }
    
   
    
    
}
