package br.unipar.unipar.central.Repositories;


import br.unipar.unipar.central.Models.Conta;
import br.unipar.unipar.central.Utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuário
 */

//FALTOU A PARTE DO TIPO, POIS E UM ENUM, TENTEI CONVERTER/PUXAR 
//DE ALGUMA FORMA MAS NÃO CONSEGUI


public class ContaDAO {
        //ID, NUMERO, DIGITO, SALDO, TIPO, RA
    private static final String INSERT
            = "INSERT INTO CONTA(ID,NUMERO, DIGITO, SALDO, TIPO, RA)"
            + "VALUES(?,?,?,?,?,?) ";

    private static final String FIND_ALL
            = "SELECT ID,NUMERO, DIGITO, SALDO, TIPO, RA FROM CONTA";

    private static final String FIND_BY_ID
            = "SELECT ID,NUMERO, DIGITO, SALDO, TIPO, RA FROM CONTA WHERE ID = ? ";

    private static final String DELETE_BY_ID
            = "DELETE FROM CONTA WHERE ID = ?";

    private static final String UPDATE
            = "UPDATE CONTA SET NUMERO = ?, DIGITO =?, SALDO = ?, TIPO = ?, RA = ?"
            + "WHERE ID = ?";

    public List<Conta> findall() throws SQLException {
        ArrayList<Conta> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Conta conta = new Conta();
                
                conta.setId(rs.getInt("ID"));
                conta.setNumero(rs.getString("NUMERO"));
                conta.setDigito(rs.getString("DIGITO"));
                conta.setSaldo(rs.getInt("SALDO"));
                //conta.setTipoConta(rs.getInt("TIPO"));
                conta.setRa(rs.getInt("RA"));
                

                retorno.add(conta);
            }
        } finally {

            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }

        return retorno;
    }

    public Conta findByid(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Conta retorno = null;
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Conta();
                
                retorno.setId(rs.getInt("ID"));
                retorno.setNumero(rs.getString("NUMERO"));
                retorno.setDigito(rs.getString("DIGITO"));
                retorno.setSaldo(rs.getInt("SALDO"));
                //retorno.setTipoConta(rs.getInt("TIPO"));
                retorno.setRa(rs.getInt("RA"));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return retorno;

    }

    public void insert(Conta conta) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, conta.getId());
            pstmt.setString(2, conta.getNumero());
            pstmt.setString(3, conta.getDigito());
            pstmt.setDouble(4, conta.getSaldo());
            //pstmt.setString(5, conta.getTipoConta());
            pstmt.setInt(6, conta.getRa());
            
            
            pstmt.executeUpdate();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public void update(Conta conta) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, conta.getNumero());
            pstmt.setString(2, conta.getDigito());
            pstmt.setDouble(3, conta.getSaldo());
            //pstmt.setString(4, conta.getTipoConta());
            pstmt.setInt(5, conta.getRa());
            pstmt.setInt(6, conta.getId());
            
            
            pstmt.executeUpdate();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }
    public void delete(int id) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);
            pstmt.setInt(1, id);
            
                       
            pstmt.executeUpdate();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }
    
}
