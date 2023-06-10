/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.unipar.central.Models;

import java.util.Date;

/**
 *
 * @author 00210402
 */
public class PessoaFisica extends Pessoa{
    
    
    private String Nome;
    private String CPF;
    private String RG;
    private int Ra;
    private Date dataNascimento;
    private Pessoa pessoa;

    public PessoaFisica() {
    }

    public PessoaFisica(String Nome, String CPF, String RG, int Ra, Date dataNascimento, Pessoa pessoa, int id, String Email, int RA) {
        super(id, Email, RA);
        this.Nome = Nome;
        this.CPF = CPF;
        this.RG = RG;
        this.Ra = Ra;
        this.dataNascimento = dataNascimento;
        this.pessoa = pessoa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public int getRa() {
        return Ra;
    }

    public void setRa(int Ra) {
        this.Ra = Ra;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    
    @Override
    public String toString() {
        return "PessoaFisica{" + "Nome=" + Nome + ", CPF=" + CPF + ", RG=" + RG + ", Ra=" + Ra + ", dataNascimento=" + dataNascimento + ", pessoa=" + pessoa + '}';
    }
    
    
    
}
