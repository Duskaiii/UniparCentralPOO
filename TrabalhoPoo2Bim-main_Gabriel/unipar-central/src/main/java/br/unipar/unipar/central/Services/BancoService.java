package br.unipar.unipar.central.Services;

import br.unipar.unipar.central.Exceptions.EntidadeNaoInformadaException;
import br.unipar.unipar.central.Exceptions.EntidadeNaoPreenchidaExceptions;
import br.unipar.unipar.central.Exceptions.EntidadePreenchidaIncorretamente;
import br.unipar.unipar.central.Models.Banco;
import br.unipar.unipar.central.Repositories.BancoDAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class BancoService {

    private void validar(Banco banco) throws EntidadeNaoInformadaException, EntidadeNaoPreenchidaExceptions, EntidadePreenchidaIncorretamente{
     
        if (banco == null ){
            throw new EntidadeNaoInformadaException("Pais\n");
        }
        
        if (banco.getNome() == null ||
            banco.getNome().isEmpty() ||
                banco.getNome().isBlank()){
            throw  new EntidadeNaoPreenchidaExceptions ("Nome Banco\n");
        }

        
        if(banco.getNome().length() > 120){
        throw new EntidadePreenchidaIncorretamente(" ",120);
        }
    }
    
    public List<Banco> findAll() throws SQLException{
         
        BancoDAO bancoDAO = new BancoDAO();
       List<Banco> resultado = bancoDAO.findall();
       return resultado;
    }
    
    
    public Banco findById(int id) throws SQLException, EntidadePreenchidaIncorretamente, Exception{
        if (id <= 0)
            throw new EntidadePreenchidaIncorretamente("id", 1);
        
        BancoDAO bancoDAO = new BancoDAO();
        
        Banco retorno = bancoDAO.findByid(id);
       
       if(retorno == null)
           throw new Exception("Não foi possivel encontrar um pais "
                   + "com o id: "+ id+" informado.");
           
           return retorno;
       }
    
     public void insert (Banco banco) throws SQLException,
             EntidadeNaoInformadaException,
             EntidadeNaoPreenchidaExceptions,
             EntidadePreenchidaIncorretamente{
         validar(banco);
         BancoDAO bancoDAO = new BancoDAO();
         bancoDAO.insert(banco);
     }
     
     public void update(Banco banco )throws SQLException,
             EntidadeNaoInformadaException,
             EntidadeNaoPreenchidaExceptions, 
             EntidadePreenchidaIncorretamente{
         validar(banco);
         BancoDAO bancoDAO = new BancoDAO();
         bancoDAO.update(banco);
     }
        public void delete( int id )throws SQLException, EntidadePreenchidaIncorretamente {
            
           if (id <= 0)
            throw new EntidadePreenchidaIncorretamente("id", 1);
             BancoDAO bancoDAO = new BancoDAO();
             bancoDAO.delete(id);
        }
    
}
