/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.unipar.central.Services;

import br.unipar.unipar.central.Exceptions.EntidadeNaoInformadaException;
import br.unipar.unipar.central.Exceptions.EntidadeNaoPreenchidaExceptions;
import br.unipar.unipar.central.Exceptions.EntidadePreenchidaIncorretamente;
import br.unipar.unipar.central.Models.Endereco;
import br.unipar.unipar.central.Models.Telefone;

/**
 *
 * @author 00210402
 */
public class TelefoneService {
    
    
     public void validar(Telefone telefone) throws EntidadeNaoInformadaException, EntidadeNaoPreenchidaExceptions, EntidadePreenchidaIncorretamente{
         
        if (telefone == null ){
            throw new EntidadeNaoInformadaException("Endereco\n");
        }
         
        if (telefone.getNumero()== null ||
            telefone.getNumero().isEmpty() ||
            telefone.getNumero().isBlank()){
            throw  new EntidadeNaoPreenchidaExceptions ("Logradouro Endereco\n");
        }
        
        if (telefone.getOperadora()== null ||
            telefone.getOperadora().isEmpty() ||
            telefone.getOperadora().isBlank()){
            throw  new EntidadeNaoPreenchidaExceptions ("Logradouro Endereco\n");
        }
        
         if(telefone.getNumero().length() > 15){
        throw new EntidadePreenchidaIncorretamente(" ",15);
        }
         
         if(telefone.getOperadora().length() > 30){
        throw new EntidadePreenchidaIncorretamente(" ",30  );
        }
     }
}
