package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjCidade;
import model.ObjCliente;

public class ClienteDAO {

    public static void inserir(ObjCliente cli) {
        String sql = "INSERT INTO clientes "
                + " ( nome, endereco, telefone, tipo , codCidade ) "
                + "VALUES ( "
                + " '" + cli.getNome()               + "' , "
                + " '" + cli.getEndereco()           + "' , "
                + " '" + cli.getTelefone()           + "' , "
                + " '" + cli.getTipo()               + "' , "
                + "  " + cli.getCidade().getCodigo() + "    "
                + " );";

        Conexao.executar(sql);
    }

    public static void editar(ObjCliente cli) {

        String sql = "UPDATE clientes SET "
                + " nome = '" + cli.getNome()                    + "' , "
                + " endereco = '" + cli.getEndereco()            + "' , "
                + " telefone = '" + cli.getTelefone()            + "' , "
                + " tipo = '" + cli.getTipo()                    + "' , "
                + " codCidade = '" + cli.getCidade().getCodigo() + "    "
                + " WHERE codigo = " + cli.getCodigo();

        Conexao.executar(sql);
    }

    public static void excluir(ObjCliente cli) {

        String sql = "DELETE FROM clientes "
                + " WHERE codigo = " + cli.getCodigo();

        Conexao.executar(sql);
    }

    public static List<ObjCliente> getClientes() {
        List<ObjCliente> lista = new ArrayList<>();
        String sql = "SELECT c.codigo, d.codigo, c.nome,          "
                + " d.nome, c.endereco, c.telefone        "
                + " FROM clientes c                                "
                + " INNER JOIN cidades d ON c.codCidade = d.codigo "
                + " WHERE c.tipo = ''  "
                + " ORDER BY c.nome";
        ResultSet rs = Conexao.consultar(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    ObjCliente cli = new ObjCliente();
                    cli.setCodigo(rs.getInt(1));
                    cli.setNome(rs.getString(3));
                    cli.setEndereco(rs.getString(5));
                    cli.setTelefone(rs.getString(6));

                    ObjCidade cid = new ObjCidade();
                    cid.setCodigo(rs.getInt(2));
                    cid.setNome(rs.getString(4));
                    cli.setCidade(cid);
                    lista.add(cli);

                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e.toString());

            }

        }
        return lista;
    }

}
