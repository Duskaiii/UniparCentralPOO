/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.unipar.central.Services;

import br.unipar.unipar.central.Exceptions.EntidadeNaoInformadaException;
import br.unipar.unipar.central.Exceptions.EntidadeNaoPreenchidaExceptions;
import br.unipar.unipar.central.Exceptions.EntidadePreenchidaIncorretamente;
import br.unipar.unipar.central.Models.Cidade;

/**
 *
 * @author 00210402
 */
public class CidadeService {
    
    
    public void validar(Cidade cidade) throws EntidadeNaoInformadaException, EntidadeNaoPreenchidaExceptions, EntidadePreenchidaIncorretamente{
        
         if (cidade == null ){
           throw new EntidadeNaoInformadaException("Cidade\n");
        }
         if (cidade.getNome() == null ||
            cidade.getNome().isEmpty() ||
            cidade.getNome().isBlank()){
              throw  new EntidadeNaoPreenchidaExceptions ("Nome Cidade\n");
             }
         
        if(cidade.getNome().length() > 60){
        throw new EntidadePreenchidaIncorretamente(" ",60);
        }
        
    }
        
    
        
    }

