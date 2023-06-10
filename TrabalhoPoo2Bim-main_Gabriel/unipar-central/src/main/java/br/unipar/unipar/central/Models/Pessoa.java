/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.unipar.central.Models;


import br.unipar.unipar.central.Enums.TipoContaEnum;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author 00210402
 */
public class Pessoa {
    
    
    private int id;
    private String Email;
    private int RA;
    
    public Pessoa() {
    }

    public Pessoa(int id, String Email, int RA) {
        this.id = id;
        this.Email = Email;
        this.RA = RA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getRA() {
        return RA;
    }

    public void setRA(int RA) {
        this.RA = RA;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", Email=" + Email + ", RA=" + RA + '}';
    }
    
    

   
    
    
    
    
}
