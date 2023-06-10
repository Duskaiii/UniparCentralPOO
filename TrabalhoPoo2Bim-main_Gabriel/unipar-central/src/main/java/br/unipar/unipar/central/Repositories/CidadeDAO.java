package br.unipar.unipar.central.Repositories;

import br.unipar.unipar.central.Models.Estado;
import br.unipar.unipar.central.Models.Cidade;
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
public class CidadeDAO {
    //ID, NOME, RA, ESTADO_ID
    private static final String INSERT
            = "INSERT INTO CIDADE(ID, NOME, RA, ESTADO_ID)"
            + "VALUES(?,?,?,?) ";

    private static final String FIND_ALL
            = "SELECT ID, NOME, RA, ESTADO_ID FROM CIDADE";

    private static final String FIND_BY_ID
            = "SELECT ID, NOME, RA, ESTADO_ID FROM CIDADE WHERE ID = ? ";

    private static final String DELETE_BY_ID
            = "DELETE FROM CIDADE WHERE ID = ?";

    private static final String UPDATE
            = "UPDATE CIDADE SET ID=?, NOME=?, RA=?, ESTADO_ID=?"
            + "WHERE ID = ?";

    public List<Cidade> findall() throws SQLException {
        ArrayList<Cidade> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("ID"));
                cidade.setNome(rs.getString("Nome"));
                cidade.setRa(rs.getInt("RA"));
                //cidade.setEstado(rs.getString(Estado estado));
                

                retorno.add(cidade);
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

    public Cidade findByid(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Cidade retorno = null;
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Cidade();
                retorno.setId(rs.getInt("ID"));
                retorno.setNome(rs.getString("Nome"));
                retorno.setRa(rs.getInt("RA"));
                //retorno.setEstado(rs.getString("ESTADO"));
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

    public void insert(Cidade cidade) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, cidade.getId());
            pstmt.setString(2, cidade.getNome());
            //pstmt.setString(3, cidade.getEstado());
            pstmt.setInt(4, cidade.getRa());

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

    public void update(Cidade cidade) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, cidade.getNome());
            pstmt.setInt(2, cidade.getRa());
            
            pstmt.setInt(4, cidade.getId());
            
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
