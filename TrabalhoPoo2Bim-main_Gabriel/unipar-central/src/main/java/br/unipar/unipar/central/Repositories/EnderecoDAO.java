package br.unipar.unipar.central.Repositories;

/**
 *
 * @author Usuário
 */
import br.unipar.unipar.central.Models.Endereco;
import br.unipar.unipar.central.Utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 00210402
 */
public class EnderecoDAO {

    private static final String INSERT
            = "INSERT INTO ENDERECO(ID,LOGRADOURO, NUMERO, BAIRRO, CEP, COMPLEMENTO, RA)"
            + "VALUES(?,?,?,?,?,?,?) ";

    private static final String FIND_ALL
            = "SELECT ID,LOGRADOURO, NUMERO, BAIRRO, CEP, COMPLEMENTO, RA FROM ENDERECO";

    private static final String FIND_BY_ID
            = "SELECT ID,LOGRADOURO, NUMERO, BAIRRO, CEP, COMPLEMENTO, RA FROM ENDERECO WHERE ID = ? ";

    private static final String DELETE_BY_ID
            = "DELETE FROM ENDERECO WHERE ID = ?";

    private static final String UPDATE
            = "UPDATE ENDERECO SET LOGRADOURO = ?, NUMERO =?, BAIRRO = ?, CEP=?, COMPLEMENTO=?, RA=?"
            + "WHERE ID = ?";

    public List<Endereco> findall() throws SQLException {
        ArrayList<Endereco> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Endereco endereco = new Endereco();
                
                endereco.setId(rs.getInt("ID"));
                endereco.setLogradouro(rs.getString("LOGRADOURO"));
                endereco.setNumero(rs.getString("NUMERO"));
                endereco.setBairro(rs.getString("BAIRRO"));
                endereco.setCep(rs.getString("CEP"));
                endereco.setComplemento(rs.getString("COMPLEMENTO"));
                endereco.setRa(rs.getInt("ID"));

                retorno.add(endereco);
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

    public Endereco findByid(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Endereco retorno = null;
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Endereco();
                retorno.setId(rs.getInt("ID"));
                retorno.setLogradouro(rs.getString("LOGRADOURO"));
                retorno.setNumero(rs.getString("NUMERO"));
                retorno.setBairro(rs.getString("BAIRRO"));
                retorno.setCep(rs.getString("CEP"));
                retorno.setComplemento(rs.getString("COMPLEMENTO"));
                retorno.setRa(rs.getInt("ID"));
                
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

    public void insert(Endereco endereco) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, endereco.getId());
            pstmt.setString(2, endereco.getLogradouro());
            pstmt.setInt(3, Integer.parseInt(endereco.getNumero()));
            pstmt.setInt(4, Integer.parseInt(endereco.getBairro()));
            pstmt.setInt(5, Integer.parseInt(endereco.getCep()));
            pstmt.setInt(6, Integer.parseInt(endereco.getCep()));
            pstmt.setInt(7, Integer.parseInt(endereco.getComplemento()));
            pstmt.setInt(8, endereco.getRa());

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

    public void update(Endereco endereco) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, endereco.getLogradouro());
            pstmt.setInt(2, Integer.parseInt(endereco.getNumero()));
            pstmt.setInt(3, Integer.parseInt(endereco.getBairro()));
            pstmt.setInt(4, Integer.parseInt(endereco.getCep()));
            pstmt.setInt(5, Integer.parseInt(endereco.getCep()));
            pstmt.setInt(6, Integer.parseInt(endereco.getComplemento()));
            pstmt.setInt(7, endereco.getRa());
            pstmt.setInt(8,endereco.getId());
            
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
