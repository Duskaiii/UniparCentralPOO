/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.unipar.central.Models;

/**
 *
 * @author 00210402
 */
public class PessoaJuridica extends Pessoa{
    
    private String razaoSocial;
    private String CNPJ;
    private String CnaePrincipal;
    private String fantasia;
    private Pessoa pessoa;
    private int ra;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String razaoSocial, String CNPJ, String CnaePrincipal, String fantasia, Pessoa pessoa, int ra, int id, String Email, int RA) {
        super(id, Email, RA);
        this.razaoSocial = razaoSocial;
        this.CNPJ = CNPJ;
        this.CnaePrincipal = CnaePrincipal;
        this.fantasia = fantasia;
        this.pessoa = pessoa;
        this.ra = ra;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCnaePrincipal() {
        return CnaePrincipal;
    }

    public void setCnaePrincipal(String CnaePrincipal) {
        this.CnaePrincipal = CnaePrincipal;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" + "razaoSocial=" + razaoSocial + ", CNPJ=" + CNPJ + ", CnaePrincipal=" + CnaePrincipal + ", fantasia=" + fantasia + ", pessoa=" + pessoa + ", ra=" + ra + '}';
    }
    
    
}
