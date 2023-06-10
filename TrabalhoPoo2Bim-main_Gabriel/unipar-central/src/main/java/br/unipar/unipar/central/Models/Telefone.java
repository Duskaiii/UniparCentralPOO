/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.unipar.central.Models;

/**
 *
 * @author 00210402
 */
public class Telefone {
    
    
    private int id;
    private String Numero;
    private String operadora;
    private int ra;

    public Telefone() {
    }

    public Telefone(int id, String Numero, String operadora, int ra) {
        this.id = id;
        this.Numero = Numero;
        this.operadora = operadora;
        this.ra = ra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    @Override
    public String toString() {
        return "Telefone{" + "id=" + id + ", Numero=" + Numero + ", operadora=" + operadora + ", ra=" + ra + '}';
    }

   
   
    
    
}
