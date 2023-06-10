package br.unipar.unipar.central.Repositories;

import br.unipar.unipar.central.Models.Agencia;
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
public class AgenciaDAO {
            //ID, CODIGO, DIGITO, RAZAOSOCIAL, CNPJ, RA
    private static final String INSERT
            = "INSERT INTO AGENCIA(ID, CODIGO, DIGITO, RAZAOSOCIAL, CNPJ, RA)"
            + "VALUES(?,?,?,?,?,?) ";

    private static final String FIND_ALL
            = "SELECT ID, CODIGO, DIGITO, RAZAOSOCIAL, CNPJ, RA FROM AGENCIA";

    private static final String FIND_BY_ID
            = "SELECT ID, CODIGO, DIGITO, RAZAOSOCIAL, CNPJ, RA FROM AGENCIA WHERE ID = ? ";

    private static final String DELETE_BY_ID
            = "DELETE FROM AGENCIA WHERE ID = ?";

    private static final String UPDATE
            = "UPDATE AGENCIA SET ID=?, CODIGO=?, DIGITO=?, RAZAOSOCIAL=?, CNPJ=?, RA=?"
            + "WHERE ID = ?";

    public List<Agencia> findall() throws SQLException {
        ArrayList<Agencia> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Agencia agencia = new Agencia();
                //ID, CODIGO, DIGITO, RAZAOSOCIAL, CNPJ, RA
                agencia.setId(rs.getInt("ID"));
                agencia.setCodigo(rs.getString("CODIGO"));
                agencia.setDigito(rs.getString("DIGITO"));
                agencia.setRazaoSocial(rs.getString("RAZAO SOCIAL"));
                agencia.setCNPJ(rs.getString("CNPJ"));
                agencia.setRa(rs.getInt("RA"));
                
                

                retorno.add(agencia);
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

    public Agencia findByid(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Agencia retorno = null;
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Agencia();
                retorno.setId(rs.getInt("ID"));
                retorno.setCodigo(rs.getString("CODIGO"));
                retorno.setDigito(rs.getString("DIGITO"));
                retorno.setRazaoSocial(rs.getString("RAZAO SOCIAL"));
                retorno.setCNPJ(rs.getString("CNPJ"));
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

    public void insert(Agencia agencia) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, agencia.getId());
            pstmt.setString(2, agencia.getCodigo());
            pstmt.setString(3, agencia.getDigito());
            pstmt.setString(4, agencia.getRazaoSocial());
            pstmt.setString(5, agencia.getCNPJ());
            pstmt.setInt(6, agencia.getRa());
            
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

    public void update(Agencia agencia) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, agencia.getCodigo());
            pstmt.setString(2, agencia.getDigito());
            pstmt.setString(3, agencia.getRazaoSocial());
            pstmt.setString(4, agencia.getCNPJ());
            pstmt.setInt(5, agencia.getRa());
            
            pstmt.setInt(6, agencia.getId());
            
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
