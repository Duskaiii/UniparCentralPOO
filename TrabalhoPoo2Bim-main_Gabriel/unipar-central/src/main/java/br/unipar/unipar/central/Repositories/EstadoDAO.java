package br.unipar.unipar.central.Repositories;

/**
 *
 * @author Usuário
 */

import br.unipar.unipar.central.Models.Estado;
import br.unipar.unipar.central.Utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EstadoDAO {

    private static final String INSERT
            = "INSERT INTO ESTADO (ID, NOME, SIGLA, RA)"
            + "VALUES(?,?,?,?)";
    
    private static final String FIND_ALL
            = "SELECT ID, NOME, SIGLA, RA FROM ESTADO";

    private static final String FIND_BY_ID
            = "SELECT ID, NOME, SIGLA, RA FROM ESTADO WHERE ID = ? ";

    private static final String DELETE_BY_ID
            = "DELETE FROM ESTADO WHERE ID = ?";

    private static final String UPDATE
            = "UPDATE ESTADO SET NOME = ?, SIGLA =?, RA = ?"
            + "WHERE ID = ?";
    
    
    public List<Estado> fildall() throws SQLException{
        ArrayList<Estado> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn  = new DatabaseUtils().getConnection();
            
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setId(rs.getInt("ID"));
                estado.setNome(rs.getString("Nome"));
                estado.setRa(rs.getInt("RA"));
                estado.setSigla(rs.getString("Sigla"));

                retorno.add(estado);
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

    public Estado findByid(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Estado retorno = null;
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Estado();
                retorno.setId(rs.getInt("ID"));
                retorno.setNome(rs.getString("Nome"));
                retorno.setRa(rs.getInt("RA"));
                retorno.setSigla(rs.getString("SIGLA"));
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

    public void insert(Estado estado) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, estado.getId());
            pstmt.setString(2, estado.getNome());
            pstmt.setString(3, estado.getSigla());
            pstmt.setInt(4, estado.getRa());

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

    public void update(Estado estado) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, estado.getNome());
            pstmt.setString(2, estado.getSigla());
            pstmt.setInt(3, estado.getRa());
            pstmt.setInt(4, estado.getId());
            
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
