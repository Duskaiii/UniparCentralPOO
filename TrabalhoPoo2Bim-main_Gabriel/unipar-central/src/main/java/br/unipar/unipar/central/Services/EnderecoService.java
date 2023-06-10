/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.unipar.central.Services;

import br.unipar.unipar.central.Exceptions.EntidadeNaoInformadaException;
import br.unipar.unipar.central.Exceptions.EntidadeNaoPreenchidaExceptions;
import br.unipar.unipar.central.Exceptions.EntidadePreenchidaIncorretamente;
import br.unipar.unipar.central.Models.Endereco;
import br.unipar.unipar.central.Models.Pais;

/**
 *
 * @author 00210402
 */
public class EnderecoService {
    
    
     public void validar(Endereco endereco) throws EntidadeNaoInformadaException, EntidadeNaoPreenchidaExceptions, EntidadePreenchidaIncorretamente{
         
        if (endereco == null ){
            throw new EntidadeNaoInformadaException("Endereco\n");
        }
        
        if (endereco.getLogradouro()== null ||
            endereco.getLogradouro().isEmpty() ||
            endereco.getLogradouro().isBlank()){
            throw  new EntidadeNaoPreenchidaExceptions ("Logradouro Endereco\n");
        }
        
        
        if (endereco.getNumero()== null ||
            endereco.getNumero().isEmpty() ||
            endereco.getNumero().isBlank()){
            throw  new EntidadeNaoPreenchidaExceptions ("Numero Endereco\n");
        }
         
        if (endereco.getBairro() == null ||
            endereco.getBairro().isEmpty() ||
            endereco.getBairro().isBlank()){
            throw  new EntidadeNaoPreenchidaExceptions ("Bairro Endereco\n");
        }
          
        if (endereco.getCep() == null ||
            endereco.getCep().isEmpty() ||
            endereco.getCep().isBlank()){
            throw  new EntidadeNaoPreenchidaExceptions ("Cep Endereco\n");
        }
        
        if (endereco.getComplemento() == null ||
            endereco.getComplemento().isEmpty() ||
            endereco.getComplemento().isBlank()){
            throw  new EntidadeNaoPreenchidaExceptions ("Complemento Endereco\n");
        }
        
         if(endereco.getLogradouro().length() > 100){
        throw new EntidadePreenchidaIncorretamente(" ",100);
        }
         
         if(endereco.getNumero().length() > 10){
        throw new EntidadePreenchidaIncorretamente(" ",10);
        }
         
       if(endereco.getBairro().length() > 100){
        throw new EntidadePreenchidaIncorretamente(" ",100);
        }
       
        if(endereco.getCep().length() > 10){
        throw new EntidadePreenchidaIncorretamente(" ",10);
        }
        
        if(endereco.getComplemento().length() > 30){
        throw new EntidadePreenchidaIncorretamente(" ",9);
        }
     }
}
