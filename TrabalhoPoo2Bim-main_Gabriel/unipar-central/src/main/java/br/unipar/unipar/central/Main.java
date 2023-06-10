/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.unipar.unipar.central;

import br.unipar.unipar.central.Exceptions.EntidadeNaoInformadaException;
import br.unipar.unipar.central.Exceptions.EntidadeNaoPreenchidaExceptions;
import br.unipar.unipar.central.Exceptions.EntidadePreenchidaIncorretamente;
import br.unipar.unipar.central.Models.Pais;
import br.unipar.unipar.central.Repositories.PaisDAO;
import br.unipar.unipar.central.Services.PaisService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 00210402
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
        try {
            PaisService service = new PaisService();
            
            Pais pais = new Pais();
            pais.setId(0);
           
            
            service.delete(0);
            
            System.out.println("Registro inserido");
//            List<Pais> resultado = service.findAll();
//            
        
         Pais resultado = service.findById(1058);
          System.out.println(resultado.toString());
          
        
         }catch (Exception ex){
             JOptionPane.showMessageDialog(null, ex.getMessage());
         }
    }
    
}
