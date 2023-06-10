package br.unipar.unipar.central.Services;

import br.unipar.unipar.central.Exceptions.EntidadeNaoInformadaException;
import br.unipar.unipar.central.Exceptions.EntidadeNaoPreenchidaExceptions;
import br.unipar.unipar.central.Exceptions.EntidadePreenchidaIncorretamente;
import br.unipar.unipar.central.Models.Conta;
import br.unipar.unipar.central.Repositories.ContaDAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class ContaService {

    private void validar(Conta conta) throws EntidadeNaoInformadaException, EntidadeNaoPreenchidaExceptions, EntidadePreenchidaIncorretamente{
     
        if (conta == null ){
            throw new EntidadeNaoInformadaException("Conta\n");
        }
        
        if (conta.getNumero() == null ||
            conta.getNumero().isEmpty() ||
            conta.getNumero().isBlank()){
            
            throw  new EntidadeNaoPreenchidaExceptions ("Número da conta\n");
        }


        if (conta.getNumero().length() > 10){
           throw new EntidadePreenchidaIncorretamente(" ",10 );
        }
        
        
        if (conta.getDigito().length() > 2){
           throw new EntidadePreenchidaIncorretamente(" ",2 );
        }
        
        
    }
    
    public List<Conta> findAll() throws SQLException{
         
        ContaDAO contaDAO = new ContaDAO();
       List<Conta> resultado = contaDAO.findall();
       
       return resultado;
    }
    
    
    public Conta findById(int id) throws SQLException, EntidadePreenchidaIncorretamente, Exception{
        if (id <= 0)
            throw new EntidadePreenchidaIncorretamente("id", 1);
        
        ContaDAO contaDAO = new ContaDAO();
        
        Conta retorno = contaDAO.findByid(id);
       
       if(retorno == null)
           throw new Exception("Não foi possivel encontrar um pais "
                   + "com o id: "+ id+" informado.");
           
           return retorno;
       }
    
     public void insert (Conta conta) throws SQLException,
             EntidadeNaoInformadaException,
             EntidadeNaoPreenchidaExceptions,
             EntidadePreenchidaIncorretamente{
         validar(conta);
         ContaDAO contaDAO = new ContaDAO();
         contaDAO.insert(conta);
     }
     
     public void update(Conta conta )throws SQLException,
             EntidadeNaoInformadaException,
             EntidadeNaoPreenchidaExceptions, 
             EntidadePreenchidaIncorretamente{
         validar(conta);
         ContaDAO contaDAO = new ContaDAO();
         contaDAO.update(conta);
     }
        public void delete( int id )throws SQLException, EntidadePreenchidaIncorretamente {
            
           if (id <= 0)
            throw new EntidadePreenchidaIncorretamente("id", 1);
             ContaDAO contaDAO = new ContaDAO();
             contaDAO.delete(id);
        }
    
}
