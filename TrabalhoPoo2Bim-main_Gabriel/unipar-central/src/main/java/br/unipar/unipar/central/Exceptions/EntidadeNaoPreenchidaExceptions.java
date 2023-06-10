/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.unipar.central.Exceptions;

/**
 *
 * @author 00210402
 */
public class EntidadeNaoPreenchidaExceptions extends Exception {
    
    
    public EntidadeNaoPreenchidaExceptions (String texto){
         super(texto + " Campo não preenchido, "
                 + "verifique novamente"); 
    }
}
