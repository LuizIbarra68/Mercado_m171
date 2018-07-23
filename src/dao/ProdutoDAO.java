/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjCategoria;

import model.ObjProduto;

/**
 *
 * @author 181700008
 */
public class ProdutoDAO {
    public static void inserir(ObjProduto pro) {
        String sql = "INSERT INTO produtos "
                + " ( nome, preco, quantidade, perecivel , codCategoria ) "
                + "VALUES ( "
                + " '" + pro.getNome()                  + "' , "
                + "  " + pro.getPreco()                 + "  , "
                + "  " + pro.getQuantidade()            + " , "
                + "  " + pro.isPerecivel()              + " , "
                + "  " + pro.getCategoria().getCodigo() + "    "
                + " );";

        Conexao.executar(sql);
    }

    public static void editar(ObjProduto pro) {

        String sql = "UPDATE produtos SET "
                + " nome = '" + pro.getNome()                        + "' , "
                + " preco =  " + pro.getPreco()                      + " , "
                + " quantidade =  " + pro.getQuantidade()            + " , "
                + " perecivel =  " + pro.isPerecivel()               + " , "
                + " codCategoria = " + pro.getCategoria().getCodigo()+ "    "
                + " WHERE codigo = " + pro.getCodigo();

        Conexao.executar(sql);
    }

    public static void excluir(ObjProduto pro) {

        String sql = "DELETE FROM produtos "
                + " WHERE codigo = " + pro.getCodigo();

        Conexao.executar(sql);
    }

    public static List<ObjProduto> getProdutos() {
        List<ObjProduto> lista = new ArrayList<>();
        String sql = "SELECT c.codigo, d.codigo, c.nome,          "
                + " c.preco, c.quantidade,  c.perecivel, d.nome      "
                                         
                + " FROM produtos c                                "
                + " INNER JOIN categorias d ON c.codCategoria = d.codigo"
                + " ORDER BY c.nome";
        ResultSet rs = Conexao.consultar(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    ObjProduto pro = new ObjProduto();
                    pro.setCodigo(rs.getInt(1));
                    pro.setNome(rs.getString(3));
                    pro.setPreco(rs.getDouble(4));
                    pro.setQuantidade(rs.getDouble(5));
                    pro.setPerecivel(rs.getBoolean(6));

                    ObjCategoria cat = new ObjCategoria();
                    cat.setCodigo(rs.getInt(2));
                    cat.setNome(rs.getString(7));
                    
                    pro.setCategoria(cat);
                    
                    lista.add(pro);

                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e.toString());

            }

        }
        return lista;
    }

}

    

