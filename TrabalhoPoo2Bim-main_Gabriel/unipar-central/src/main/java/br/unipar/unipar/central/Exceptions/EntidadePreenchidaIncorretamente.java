/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.unipar.central.Exceptions;

/**
 *
 * @author 00210402
 */
public class EntidadePreenchidaIncorretamente extends Exception{
    
    
    public EntidadePreenchidaIncorretamente(String texto, int tamanho){
        super(texto + "Campo preenchido incorretamente, campo possui tamanho(" + tamanho
                +  ") verifique novamente!");
    }
}
