package com.example.lab10_iweb.Daos;

import com.example.lab10_iweb.Beans.Credentianls;

import java.sql.*;

public class DaoLogin extends DaoBase{

    public Credentianls buscarUsuario(String nroDoc, String password) {

        Credentianls credencialUsuario = null;


        try(Connection conn = getConnection();
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM bi_corp_business.credentials WHERE nro_documento= ? and hashedPassword= sha2(?,256);")){

            pstm.setString(1, nroDoc);
            pstm.setString(2,password);
            try (ResultSet rs = pstm.executeQuery();){
                if(rs.next()){
                    credencialUsuario = new Credentianls();
                    credencialUsuario.setNumeroDocumento(rs.getString(1));
                    credencialUsuario.setTipoUsuario(rs.getInt(4));
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return credencialUsuario;
    }
    public void createCredentialCliente(Credentianls credentianl, String password) {

        String sql = "INSERT INTO bi_corp_business.credentials (nro_documento, password, hashedPassword, tipoUsuario)" +
                "VALUES (?,?,SHA2(?,256),?);";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, credentianl.getNumeroDocumento());
            pstmt.setString(2,password);
            pstmt.setString(3,password);
            pstmt.setInt(4, credentianl.getTipoUsuario());

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
