/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Profissao;

/**
 *
 * @author leona
 */
public class ProfissaoDao {

    private ConexaoBanco conexao;

    public ProfissaoDao() {
        this.conexao = new ConexaoBanco();
    }

    public ArrayList<Profissao> consultar() {

        ArrayList<Profissao> listaProfissao = new ArrayList<Profissao>();
        String sql = "SELECT idprofissao, nomeprofissao FROM cadprofissao ORDER BY nomeprofissao";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //recebe o resultado da consulta
                ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while (resultadoSentenca.next()) {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    Profissao profissao = new Profissao();
                    profissao.setIdProfissao(resultadoSentenca.getInt("idprofissao"));
                    profissao.setNomeProfissao(resultadoSentenca.getString("nomeprofissao"));

                    listaProfissao.add(profissao);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

            return listaProfissao;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
