/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.unipar.central.Models;

/**
 *
 * @author 00210402
 */
public class Banco {
    
    
    private int id;
    private String nome;
    private int ra;

    public Banco() {
    }

    public Banco(int id, String nome, int ra) {
        this.id = id;
        this.nome = nome;
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

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    @Override
    public String toString() {
        return "Banco{" + "id=" + id + ", nome=" + nome + ", ra=" + ra + '}';
    }
    
    
    
    
}
