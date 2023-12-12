/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Cadastro {

    private int idcadastro;
    private String nomecadastro;
    private String cpf;
    private String cep;
    private String foto;
    private int idsexo;
    private int idprofissao;
    private String nomesexo;
    private String nomeprofissao;
    private int cadastrousuarios;
    private int atualizacao;
    private int deletes;

    public Cadastro() {
    }

    public Cadastro(int idcadastro, String nomecadastro, String cpf, String cep, String foto, int idsexo, int idprofissao, String nomesexo, String nomeprofissao) {
        this.idcadastro = idcadastro;
        this.nomecadastro = nomecadastro;
        this.cpf = cpf;
        this.nomesexo = nomesexo;
        this.nomeprofissao = nomeprofissao;
        this.cep = cep;
        this.foto = foto;
        this.idprofissao = idprofissao;
        this.idsexo = idsexo;
    }

    public Cadastro(int numCadastros, int somaCodigos, int numSexualidade) {
        this.cadastrousuarios = cadastrousuarios;
        this.atualizacao = atualizacao;
        this.deletes = deletes;
    }

    public int getIdCadastro() {
        return idcadastro;
    }

    public void setIdCadastro(int idcadastro) {
        this.idcadastro = idcadastro;
    }

    public String getNomeCadastro() {
        return nomecadastro;
    }

    public void setNomeCadastro(String nomecadastro) {
        this.nomecadastro = nomecadastro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getIdSexo() {
        return idsexo;
    }

    public void setIdSexo(int idsexo) {
        this.idsexo = idsexo;
    }

    public int getIdProfissao() {
        return idprofissao;
    }

    public void setIdProfissao(int idprofissao) {
        this.idprofissao = idprofissao;
    }

    public String getNomeSexo() {
        return nomesexo;
    }

    public void SetNomeSexo(String nomesexo) {
        this.nomesexo = nomesexo;
    }

    public String getNomeProfissao() {
        return nomeprofissao;
    }

    public void SetNomeProfissao(String nomeprofissao) {
        this.nomeprofissao = nomeprofissao;
    }

    public int getCadastroUsuarios() {
        return cadastrousuarios;
    }

    public void setCadastroUsuarios(int cadastrousuarios) {
        this.cadastrousuarios = cadastrousuarios;
    }

    public int getAtualizacao() {
        return atualizacao;
    }

    public void SetAtualizacao(int atualizacao) {
        this.atualizacao = atualizacao;
    }

    public int getDeletes() {
        return deletes;
    }

    public void SetDeletes(int deletes) {
        this.deletes = deletes;
    }

}
