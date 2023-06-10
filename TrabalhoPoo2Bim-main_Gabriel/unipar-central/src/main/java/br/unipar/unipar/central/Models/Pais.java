/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.unipar.central.Models;

/**
 *
 * @author 00210402
 */
public class Pais {
    
    private int id;
    private String nome;
    private String Sigla;
    private int ra;

   

    public Pais() {
    }

    public Pais(int id, String nome, String Sigla, int ra) {
        this.id = id;
        this.nome = nome;
        this.Sigla = Sigla;
        this.ra = ra;
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

    public String getSigla() {
        return Sigla;
    }

    public void setSigla(String Sigla) {
        this.Sigla = Sigla;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    @Override
    public String toString() {
        return "Pais{" + "id=" + id + ", nome=" + nome + ", Sigla=" + Sigla + ", ra=" + ra + '}';
    }
    
     

   
 
    
    
    
}
