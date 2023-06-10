package br.unipar.unipar.central.Repositories;


import br.unipar.unipar.central.Models.Telefone;
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
public class TelefoneDAO {
            //ID, NUMERO, OPERADORA, RA
    private static final String INSERT
            = "INSERT INTO TELEFONE(ID, NUMERO, OPERADORA, RA)"
            + "VALUES(?,?,?,?) ";

    private static final String FIND_ALL
            = "SELECT ID, NUMERO, OPERADORA, RA FROM TELEFONE";

    private static final String FIND_BY_ID
            = "SELECT ID, NUMERO, OPERADORA, RA FROM TELEFONE WHERE ID = ? ";

    private static final String DELETE_BY_ID
            = "DELETE FROM TELEFONE WHERE ID = ?";

    private static final String UPDATE
            = "UPDATE TELEFONE SET ID=?, NUMERO=?, OPERADORA=?, RA=?"
            + "WHERE ID = ?";

    public List<Telefone> findall() throws SQLException {
        ArrayList<Telefone> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Telefone telefone = new Telefone();
                telefone.setId(rs.getInt("ID"));
                telefone.setNumero(rs.getString("NUMERO"));
                telefone.setOperadora(rs.getString("OPERADORA"));
                telefone.setRa(rs.getInt("RA"));

                retorno.add(telefone);
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

    public Telefone findByid(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Telefone retorno = null;
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Telefone();
                retorno.setId(rs.getInt("ID"));
                retorno.setNumero(rs.getString("NUMERO"));
                retorno.setOperadora(rs.getString("OPERADORA"));
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

    public void insert(Telefone telefone) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, telefone.getId());
            pstmt.setString(2, telefone.getNumero());
            pstmt.setString(3, telefone.getOperadora());
            pstmt.setInt(4, telefone.getRa());

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

    public void update(Telefone telefone) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, telefone.getNumero());
            pstmt.setString(2, telefone.getOperadora());
            pstmt.setInt(3, telefone.getRa());
            pstmt.setInt(4, telefone.getId());
            
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
