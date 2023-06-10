/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.unipar.central.Services;

import br.unipar.unipar.central.Exceptions.EntidadeNaoInformadaException;
import br.unipar.unipar.central.Exceptions.EntidadeNaoPreenchidaExceptions;
import br.unipar.unipar.central.Exceptions.EntidadePreenchidaIncorretamente;
import br.unipar.unipar.central.Models.Endereco;
import br.unipar.unipar.central.Models.Estado;

/**
 *
 * @author 00210402
 */
public class EstadoService {
    
      public void validar(Estado estado) throws EntidadeNaoInformadaException, EntidadeNaoPreenchidaExceptions, EntidadePreenchidaIncorretamente{
          
           if (estado== null ){
            throw new EntidadeNaoInformadaException("Estado\n");
        }
        
        if (estado.getNome() == null ||
            estado.getNome().isEmpty() ||
            estado.getNome().isBlank()){
            throw  new EntidadeNaoPreenchidaExceptions ("Nome Estado\n");
        }
        
        
        if (estado.getSigla() == null ||
            estado.getSigla().isEmpty() ||
            estado.getSigla().isBlank()){
            throw  new EntidadeNaoPreenchidaExceptions ("Sigla Estado\n");
        }
        
        if (!(estado.getSigla().length() == 2)){
           throw new EntidadePreenchidaIncorretamente(" ",2 );
        }
        
        if(estado.getNome().length() > 60){
        throw new EntidadePreenchidaIncorretamente(" ",60);
        }
         
     }
    
}
