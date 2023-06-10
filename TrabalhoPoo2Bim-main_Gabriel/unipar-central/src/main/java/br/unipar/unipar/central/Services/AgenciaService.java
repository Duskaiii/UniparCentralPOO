package br.unipar.unipar.central.Services;

import br.unipar.unipar.central.Exceptions.EntidadeNaoInformadaException;
import br.unipar.unipar.central.Exceptions.EntidadeNaoPreenchidaExceptions;
import br.unipar.unipar.central.Exceptions.EntidadePreenchidaIncorretamente;
import br.unipar.unipar.central.Models.Agencia;
import br.unipar.unipar.central.Repositories.AgenciaDAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class AgenciaService {
    private void validar(Agencia agencia) throws EntidadeNaoInformadaException, EntidadeNaoPreenchidaExceptions, EntidadePreenchidaIncorretamente{
     
        if (agencia == null ){
            throw new EntidadeNaoInformadaException("Pais\n");
        }
        
        if (agencia.getCodigo() == null ||
            agencia.getCodigo().isEmpty() ||
                agencia.getCodigo().isBlank()){
            throw  new EntidadeNaoPreenchidaExceptions ("Codigo Agencia\n");
        }
        
        
        if (agencia.getDigito() == null ||
            agencia.getDigito().isEmpty() ||
            agencia.getDigito().isBlank()){
            throw  new EntidadeNaoPreenchidaExceptions ("Digito da Agencia não informado\n");
        }
        
        if (agencia.getRazaoSocial()== null ||
            agencia.getRazaoSocial().isEmpty() ||
            agencia.getRazaoSocial().isBlank()){
            throw  new EntidadeNaoPreenchidaExceptions ("Razão não informado\n");
        }
        
        if (agencia.getCNPJ()== null ||
            agencia.getCNPJ().isEmpty() ||
            agencia.getCNPJ().isBlank()){
            throw  new EntidadeNaoPreenchidaExceptions ("CNPJ não informado\n");
        }
        
        if (!(agencia.getDigito().length() > 2)){
           throw new EntidadePreenchidaIncorretamente(" ",2 );
        }
        
        if(agencia.getCodigo().length() > 10){
        throw new EntidadePreenchidaIncorretamente(" ",120);
        }
    }
    
    public List<Agencia> findAll() throws SQLException{
         
       AgenciaDAO agenciaDAO = new AgenciaDAO();
       List<Agencia> resultado = agenciaDAO.findall();
       return resultado;
    }
    
    
    public Agencia findById(int id) throws SQLException, EntidadePreenchidaIncorretamente, Exception{
        if (id <= 0)
            throw new EntidadePreenchidaIncorretamente("id", 1);
        
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        
        Agencia retorno = agenciaDAO.findByid(id);
       
       if(retorno == null)
           throw new Exception("Não foi possivel encontrar um pais "
                   + "com o id: "+ id+" informado.");
           
           return retorno;
       }
    
     public void insert (Agencia agencia) throws SQLException,
             EntidadeNaoInformadaException,
             EntidadeNaoPreenchidaExceptions,
             EntidadePreenchidaIncorretamente{
         validar(agencia);
         AgenciaDAO agenciaDAO = new AgenciaDAO();
         agenciaDAO.insert(agencia);
     }
     
     public void update(Agencia agencia )throws SQLException,
             EntidadeNaoInformadaException,
             EntidadeNaoPreenchidaExceptions, 
             EntidadePreenchidaIncorretamente{
         validar(agencia);
         AgenciaDAO agenciaDAO = new AgenciaDAO();
         agenciaDAO.update(agencia);
     }
        public void delete( int id )throws SQLException, EntidadePreenchidaIncorretamente {
            
           if (id <= 0)
            throw new EntidadePreenchidaIncorretamente("id", 1);
             AgenciaDAO agenciaDAO = new AgenciaDAO();
             agenciaDAO.delete(id);
        }
}
