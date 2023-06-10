package br.unipar.unipar.central.Repositories;

import br.unipar.unipar.central.Models.PessoaJuridica;
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
public class PessoaJuridicaDAO {

    //RAZAOSOCIAL, CNPJ, CNPJPRINCIPAL, FANTASIA
    private static final String INSERT
            = "INSERT INTO PESSOAJURIDICA(RAZAOSOCIAL, CNPJ, CNPJPRINCIPAL, FANTASIA)"
            + "VALUES(?,?,?,?) ";

    private static final String FIND_ALL
            = "SELECT RAZAOSOCIAL, CNPJ, CNPJPRINCIPAL, FANTASIA FROM PESSOAJURIDICA";

    private static final String FIND_BY_ID
            = "SELECT RAZAOSOCIAL, CNPJ, CNPJPRINCIPAL, FANTASIA FROM PESSOAJURIDICA WHERE ID = ? ";

    private static final String DELETE_BY_ID
            = "DELETE FROM PESSOAJURIDICA WHERE ID = ?";

    private static final String UPDATE
            = "UPDATE PESSOAJURIDICA SET RAZAOSOCIAL=?, CNPJ=?, CNPJPRINCIPAL=?, FANTASIA=?"
            + "WHERE ID = ?";

    public List<PessoaJuridica> findall() throws SQLException {
        ArrayList<PessoaJuridica> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setRazaoSocial(rs.getString("RAZÃO SOCIAL"));
                pessoaJuridica.setCNPJ(rs.getString("CNPJ"));
                pessoaJuridica.setCnaePrincipal(rs.getString("CNPJ PRINCIPAL"));
                pessoaJuridica.setFantasia(rs.getString("FANTASIA"));
                
                

                retorno.add(pessoaJuridica);
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

    public PessoaJuridica findByid(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaJuridica retorno = null;
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new PessoaJuridica();
                retorno.setRazaoSocial(rs.getString("RAZÃO SOCIAL"));
                retorno.setCNPJ(rs.getString("CNPJ"));
                retorno.setCnaePrincipal(rs.getString("CNPJ PRINCIPAL"));
                retorno.setFantasia(rs.getString("FANTASIA"));
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

    public void insert(PessoaJuridica pessoaJuridica) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, pessoaJuridica.getRazaoSocial());
            pstmt.setString(2, pessoaJuridica.getCNPJ());
            pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(4, pessoaJuridica.getFantasia());
            

            pstmt.setInt(4, pessoaJuridica.getRa());

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

    public void update(PessoaJuridica pessoaJuridica) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, pessoaJuridica.getRazaoSocial());
            pstmt.setString(2, pessoaJuridica.getCNPJ());
            pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(4, pessoaJuridica.getFantasia());

            pstmt.setInt(4, pessoaJuridica.getRa());
            
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
