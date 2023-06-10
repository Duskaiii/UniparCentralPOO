/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.unipar.central.Services;

import br.unipar.unipar.central.Exceptions.EntidadeNaoInformadaException;
import br.unipar.unipar.central.Exceptions.EntidadeNaoPreenchidaExceptions;
import br.unipar.unipar.central.Exceptions.EntidadePreenchidaIncorretamente;
import br.unipar.unipar.central.Models.Pais;
import br.unipar.unipar.central.Repositories.PaisDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 00210402
 */
public class PaisService {
    
    private void validar(Pais pais) throws EntidadeNaoInformadaException, EntidadeNaoPreenchidaExceptions, EntidadePreenchidaIncorretamente{
     
        if (pais == null ){
            throw new EntidadeNaoInformadaException("Pais\n");
        }
        
        if (pais.getNome() == null ||
            pais.getNome().isEmpty() ||
                pais.getNome().isBlank()){
            throw  new EntidadeNaoPreenchidaExceptions ("Nome Pais\n");
        }
        
        
        if (pais.getSigla() == null ||
            pais.getSigla().isEmpty() ||
            pais.getSigla().isBlank()){
            throw  new EntidadeNaoPreenchidaExceptions ("Sigla Pais\n");
        }
        
        if (!(pais.getSigla().length() == 2)){
           throw new EntidadePreenchidaIncorretamente(" ",2 );
        }
        
        if(pais.getNome().length() > 120){
        throw new EntidadePreenchidaIncorretamente(" ",120);
        }
    }
    
    public List<Pais> findAll() throws SQLException{
         
        PaisDAO paisDAO = new PaisDAO();
       List<Pais> resultado = paisDAO.findall();
       return resultado;
    }
    
    
    public Pais findById(int id) throws SQLException, EntidadePreenchidaIncorretamente, Exception{
        if (id <= 0)
            throw new EntidadePreenchidaIncorretamente("id", 1);
        
        PaisDAO paisDao = new PaisDAO();
        
        Pais retorno = paisDao.findByid(id);
       
       if(retorno == null)
           throw new Exception("Não foi possivel encontrar um pais "
                   + "com o id: "+ id+" informado.");
           
           return retorno;
       }
    
     public void insert (Pais pais) throws SQLException,
             EntidadeNaoInformadaException,
             EntidadeNaoPreenchidaExceptions,
             EntidadePreenchidaIncorretamente{
         validar(pais);
         PaisDAO paisDAO = new PaisDAO();
         paisDAO.insert(pais);
     }
     
     public void update(Pais pais )throws SQLException,
             EntidadeNaoInformadaException,
             EntidadeNaoPreenchidaExceptions, 
             EntidadePreenchidaIncorretamente{
         validar(pais);
         PaisDAO paisDAO = new PaisDAO();
         paisDAO.update(pais);
     }
        public void delete( int id )throws SQLException, EntidadePreenchidaIncorretamente {
            
           if (id <= 0)
            throw new EntidadePreenchidaIncorretamente("id", 1);
             PaisDAO paisDAO = new PaisDAO();
             paisDAO.delete(id);
        }
     
}
