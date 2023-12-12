/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import modelo.Cadastro;

public class CadastroDao2 implements DaoGenerica2<Cadastro> {

    private ConexaoBanco conexao;

    public CadastroDao2() {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(Cadastro cadastro) {
        //string com a consulta que será executada no banco
        String sql = "INSERT INTO cadastrobasico (nomecadastro, cpf,cep, idsexo, idprofissao,foto) VALUES (?,?,?,(select idsexo from cadsexo where nomesexo = ?),(select idprofissao from cadprofissao where nomeprofissao = ?),?)";

        try {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
            if (this.conexao.conectar()) {
                //prepara a sentença com a consulta da string
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //subtitui as interrograções da consulta, pelo valor específico
                sentenca.setString(1, cadastro.getNomeCadastro()); //subsitui a primeira ocorrência da interrogação pelo atributo nome
                sentenca.setString(2, cadastro.getCpf());
                sentenca.setString(3, cadastro.getCep());
                sentenca.setString(4, cadastro.getNomeSexo());
                sentenca.setString(5, cadastro.getNomeProfissao());
                sentenca.setString(6, cadastro.getFoto());

                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void alterar(Cadastro cadastro) {
        String sql = "UPDATE cadastrobasico SET nomecadastro = ?, cpf = ?,cep=? , idsexo = (select idsexo from cadsexo where nomesexo = ?),idprofissao = (select idprofissao from cadprofissao where nomeprofissao = ?), foto = ? where idcadastro = ?";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setString(1, cadastro.getNomeCadastro());
                sentenca.setString(2, cadastro.getCpf());
                sentenca.setString(3, cadastro.getCep());
                sentenca.setString(4, cadastro.getNomeSexo());
                sentenca.setString(5, cadastro.getNomeProfissao());
                sentenca.setString(6, cadastro.getFoto());
                sentenca.setInt(7, cadastro.getIdCadastro());
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void excluir() {
        String sql = "DELETE FROM ESCOLA";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void excluirID(int id) {
        String sql = "DELETE FROM cadastrobasico WHERE idcadastro = ?";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setInt(1, id);

                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public ArrayList<Cadastro> consultar() {

        ArrayList<Cadastro> listaCadastros = new ArrayList<Cadastro>();
        String sql = "SELECT c.idcadastro, c.nomecadastro, c.cpf, c.cep,j.nomeprofissao, s.nomesexo "
                + "FROM cadastrobasico as c "
                + "LEFT JOIN cadsexo AS s ON (s.idsexo = c.idsexo) "
                + "LEFT JOIN cadprofissao AS j ON (j.idprofissao = c.idprofissao) "
                + "ORDER BY c.idcadastro ";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //recebe o resultado da consulta
                ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while (resultadoSentenca.next()) {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    Cadastro cadastro = new Cadastro();
                    cadastro.setIdCadastro(resultadoSentenca.getInt("idcadastro"));
                    cadastro.setNomeCadastro(resultadoSentenca.getString("nomecadastro"));
                    cadastro.setCpf(resultadoSentenca.getString("cpf"));
                    cadastro.setCep(resultadoSentenca.getString("cep"));
                    cadastro.SetNomeSexo(resultadoSentenca.getString("nomesexo"));
                    cadastro.SetNomeProfissao(resultadoSentenca.getString("nomeprofissao"));

                    listaCadastros.add(cadastro);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

            return listaCadastros;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<Cadastro> dashboard() {

        ArrayList<Cadastro> ListarDashBoard = new ArrayList<Cadastro>();
        //String sql = "select count(idcadastro) as numcadastro, count(idcadastro)*2 as sumcad, (select count(idsexo)+100 from cadsexo) as numsexualidade from cadastrobasico;";
        String sql = " SELECT"
                + " (SELECT COUNT(*) FROM log WHERE tipoalteracao=10) AS cadastrousuarios,\n"
                + " (SELECT COUNT(*) FROM log WHERE tipoalteracao=50) AS atualizacao,\n"
                + " (SELECT COUNT(*) FROM log WHERE tipoalteracao=100) AS deletes";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //recebe o resultado da consulta
                ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while (resultadoSentenca.next()) {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    Cadastro cadastro = new Cadastro();
                    cadastro.setCadastroUsuarios(resultadoSentenca.getInt("cadastrousuarios"));
                    cadastro.SetAtualizacao(resultadoSentenca.getInt("atualizacao"));
                    cadastro.SetDeletes(resultadoSentenca.getInt("deletes"));

                    ListarDashBoard.add(cadastro);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

            return ListarDashBoard;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
