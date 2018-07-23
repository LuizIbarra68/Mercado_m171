/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.ClienteDAO;
import dao.ClienteFisicoDAO;
import dao.ClienteJuridicoDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.ObjCliente;
import model.ObjClienteFisico;
import model.ObjClienteJuridico;

/**
 *
 * @author 181700008
 */
public class ListClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListClientes
     */
    public ListClientes() {
        initComponents();
        carregarTabela("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de Clientes");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tipo");

        cmbTipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clientes", "Clientes físicos", "Clientes jurídicos", "Todos" }));
        cmbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoItemStateChanged(evt);
            }
        });

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(416, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoItemStateChanged
        int posicao = cmbTipo.getSelectedIndex();
        switch ( posicao ){
            case 0 :
                carregarTabela("");
                break;
            case 1:
                carregarTabela(ObjCliente.PESSOA_FISICA);
                break;
                case 2:
                    carregarTabela(ObjCliente.PESSOA_JURIDICA);
                    break;
                
        }
    }//GEN-LAST:event_cmbTipoItemStateChanged

    private void carregarTabela( String tipo ){
        DefaultTableModel modelo = new DefaultTableModel();
        String[] colunas = {};
        
        switch( tipo ){
            case "" :
                colunas = new String[]{"Código", "Nome", "Telefone",
                    "Endereço", "Cidade"};
                modelo.setColumnIdentifiers(colunas);
                List<ObjCliente> listaClientes = ClienteDAO.getClientes();
                
                for (ObjCliente cli : listaClientes){
                   Object[] obj = {
                       cli.getCodigo(),
                       cli.getNome(),
                       cli.getTelefone(),
                       cli.getEndereco(),
                       cli.getCidade().getNome()
                   };
                   modelo.addRow(obj);
                }
                
                break;
                
                case ObjCliente.PESSOA_FISICA :
                    colunas = new String[] {"Código", "Nome", "Telefone",
                    "Endereço", "Cidade", "CPF", "RG"};
                    modelo.setColumnIdentifiers(colunas);
                    List<ObjClienteFisico> listaFisicos =
                            ClienteFisicoDAO.getClientes();
                    for( ObjClienteFisico cli : listaFisicos){
                       Object[] obj = {
                       cli.getCodigo(),
                       cli.getNome(),
                       cli.getTelefone(),
                       cli.getEndereco(),
                       cli.getCidade().getNome(),
                       cli.getCpf(),
                       cli.getRg()
                   };
                   modelo.addRow(obj);
                   
                }    
                        
                    break;
            case ObjCliente.PESSOA_JURIDICA :
                    colunas = new String[] {"Código", "Nome", "Telefone",
                    "Endereço", "Cidade", "CNPJ", "IE"};
                    modelo.setColumnIdentifiers(colunas);
                    List<ObjClienteJuridico> listaJuridicos =
                            ClienteJuridicoDAO.getClientes();
                    for( ObjClienteJuridico cli : listaJuridicos){
                       Object[] obj = {
                       cli.getCodigo(),
                       cli.getNome(),
                       cli.getTelefone(),
                       cli.getEndereco(),
                       cli.getCidade().getNome(),
                       cli.getCnpj(),
                       cli.getIe()
                   };
                   modelo.addRow(obj);
                   
                }    
                        
                    break;
        }
        
        
        
        
        
        tableClientes.setModel(modelo);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableClientes;
    // End of variables declaration//GEN-END:variables
}
