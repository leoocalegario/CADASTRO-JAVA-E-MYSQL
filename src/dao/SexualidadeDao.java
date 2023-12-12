/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Sexualidade;

/**
 *
 * @author leona
 */
public class SexualidadeDao {

    private ConexaoBanco conexao;

    public SexualidadeDao() {
        this.conexao = new ConexaoBanco();
    }

    public ArrayList<Sexualidade> consultar() {

        ArrayList<Sexualidade> listaSexualidade = new ArrayList<Sexualidade>();
        String sql = "SELECT idsexo, nomesexo FROM cadsexo ORDER BY nomesexo";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //recebe o resultado da consulta
                ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while (resultadoSentenca.next()) {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    Sexualidade sexualidade = new Sexualidade();
                    sexualidade.setIdSexo(resultadoSentenca.getInt("idsexo"));
                    sexualidade.setNomeSexo(resultadoSentenca.getString("nomesexo"));

                    listaSexualidade.add(sexualidade);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

            return listaSexualidade;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
