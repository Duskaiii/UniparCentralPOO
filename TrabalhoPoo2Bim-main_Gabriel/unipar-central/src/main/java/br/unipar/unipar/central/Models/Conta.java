/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.unipar.central.Models;

import br.unipar.unipar.central.Enums.TipoContaEnum;

/**
 *
 * @author 00210402
 */
public class Conta {
    
    
    private int id;
    private String numero;
    private String digito;
    private double saldo;
    private TipoContaEnum tipoConta;
    private String codigo;
    private int ra;
    private Agencia agencia;
    private Pessoa pessoa;

    public Conta() {
    }

    public Conta(int id, String numero, String digito, double saldo, TipoContaEnum tipoConta, String codigo, int ra, Agencia agencia, Pessoa pessoa) {
        this.id = id;
        this.numero = numero;
        this.digito = digito;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.codigo = codigo;
        this.ra = ra;
        this.agencia = agencia;
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDigito() {
        return digito;
    }

    public void setDigito(String digito) {
        this.digito = digito;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public TipoContaEnum getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoContaEnum tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Conta{" + "id=" + id + ", numero=" + numero + ", digito=" + digito + ", saldo=" + saldo + ", tipoConta=" + tipoConta + ", codigo=" + codigo + ", ra=" + ra + ", agencia=" + agencia + ", pessoa=" + pessoa + '}';
    }
    
    
   
    
}
