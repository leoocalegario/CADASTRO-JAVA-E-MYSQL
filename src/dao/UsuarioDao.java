/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author leona
 */
public class UsuarioDao {

    private ConexaoBanco conexao;

    public UsuarioDao() {
        this.conexao = new ConexaoBanco();
    }

    public boolean LoginUsuario(String Usuario, String Senha) {
        String sql = "SELECT * FROM usuarios WHERE nomeusuario=? and senha=?";
        boolean checkUser = false;
        try {
            if (conexao.conectar()) {
                PreparedStatement sentenca = conexao.getConnection().prepareStatement(sql);
                sentenca.setString(1, Usuario);
                sentenca.setString(2, Senha);
                ResultSet rs = sentenca.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Usuario Valido");
                    checkUser = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario nao Valido");
                    checkUser = false;
                }
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return checkUser;
    }
}
