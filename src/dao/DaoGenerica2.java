/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author leona
 * @param <ObjetoGenerico>
 */
public interface DaoGenerica2<ObjetoGenerico> {

    public void inserir(ObjetoGenerico objt);

    public void alterar(ObjetoGenerico objt);

    public void excluir();

    public ArrayList<ObjetoGenerico> consultar();

    public ArrayList<ObjetoGenerico> dashboard();
}
