package br.unipar.unipar.central.Repositories;


import br.unipar.unipar.central.Models.PessoaFisica;
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
public class PessoaFisicaDAO {

    //NOME, CPF, RG, DATANASCIMENTO
    private static final String INSERT
            = "INSERT INTO PESSOAFISICA(NOME, CPF, RG, DATANASCIMENTO)"
            + "VALUES(?,?,?,?) ";

    private static final String FIND_ALL
            = "SELECT NOME, CPF, RG, DATANASCIMENTO FROM PESSOAFISICA";

    private static final String FIND_BY_ID
            = "SELECT NOME, CPF, RG, DATANASCIMENTO FROM PESSOAFISICA WHERE ID = ? ";

    private static final String DELETE_BY_ID
            = "DELETE FROM PESSOAFISICA WHERE ID = ?";

    private static final String UPDATE
            = "UPDATE PESSOAFISICA SET NOME=?, CPF=?, RG=?, DATANASCIMENTO=?"
            + "WHERE ID = ?";

    public List<PessoaFisica> findall() throws SQLException {
        ArrayList<PessoaFisica> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setNome(rs.getString("NOME"));
                pessoaFisica.setCPF(rs.getString("CPF"));
                pessoaFisica.setRG(rs.getString("RG"));
                pessoaFisica.setDataNascimento(rs.getDate("DATA"));
                pessoaFisica.setRA(rs.getInt("RA"));
                

                retorno.add(pessoaFisica);
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

    public PessoaFisica findByid(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaFisica retorno = null;
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new PessoaFisica();
                retorno.setNome(rs.getString("NOME"));
                retorno.setCPF(rs.getString("CPF"));
                retorno.setRG(rs.getString("RG"));
                retorno.setDataNascimento(rs.getDate("DATA"));
                retorno.setRA(rs.getInt("RA"));
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

    public void insert(PessoaFisica pessoaFisica) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = new DatabaseUtils().getConnection();

            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, pessoaFisica.getNome());
            pstmt.setString(2, pessoaFisica.getCPF());
            pstmt.setString(3, pessoaFisica.getRG());

            pstmt.setInt(4, pessoaFisica.getRa());

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

    public void update(PessoaFisica pessoaFisica) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, pessoaFisica.getNome());
            pstmt.setString(2, pessoaFisica.getCPF());
            pstmt.setString(3, pessoaFisica.getRG());

            pstmt.setInt(4, pessoaFisica.getRa());
            
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
