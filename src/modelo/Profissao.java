/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author leona
 */
public class Profissao {

    private int idprofissao;
    private String nomeprofissao;

    public Profissao() {
    }

    public Profissao(String nomeprofissao) {
        this.nomeprofissao = nomeprofissao;
    }

    public Profissao(int idprofissao, String nomeprofissao) {
        this.idprofissao = idprofissao;
        this.nomeprofissao = nomeprofissao;
    }

    public int getIdProfissao() {
        return idprofissao;
    }

    public void setIdProfissao(int idprofissao) {
        this.idprofissao = idprofissao;
    }

    public String getNomeProfissao() {
        return nomeprofissao;
    }

    public void setNomeProfissao(String nomeprofissao) {
        this.nomeprofissao = nomeprofissao;
    }

}
