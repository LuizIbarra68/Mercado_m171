/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.CidadeDAO;
import dao.ClienteDAO;
import dao.ClienteFisicoDAO;
import dao.ClienteJuridicoDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.ObjCidade;
import model.ObjCliente;
import model.ObjClienteFisico;
import model.ObjClienteJuridico;

/**
 *
 * @author 181700008
 */
public class FrmCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmCliente
     */
    private boolean novo;
    private Object cliente;
    private  ListClientes telaListClientes;
    private List<ObjCidade> listaDeCidades;

    public FrmCliente() {
        initComponents();
        esconder();
        carregarCidades();
        cliente = new ObjCliente();
        lblCodigo.setText("");
        novo = true;

    }

    public FrmCliente(int codigo, ListClientes telaListClientes) {
        initComponents();
        esconder();
        carregarCidades();
        novo = false;
        cliente = ClienteDAO.getClienteByCodigo(codigo);
        carregarFormulario();
        this.telaListClientes = telaListClientes;

    }

    private void carregarFormulario() {
        ObjCliente cli = (ObjCliente) cliente;
        txtNome.setText(cli.getNome());
        txtTelefone.setText(cli.getTelefone());
        txtEndereco.setText(cli.getEndereco());
        lblCodigo.setText(String.valueOf(cli.getCodigo()));

        for (int i = 1; i < listaDeCidades.size(); i++) {
            ObjCidade cid = listaDeCidades.get(i);
            if (cid.getCodigo() == cli.getCidade().getCodigo()) {
                cmbCidade.setSelectedIndex(i);
                break;
            }
        }
        if (cli.getTipo().equals(ObjCliente.PESSOA_FISICA)) {
            ObjClienteFisico cf = (ObjClienteFisico) cliente;
            rbPF.setSelected(true);
            txtCPF.setText(cf.getCpf());
            txtRG.setText((cf.getRg()));
        }
        if (cli.getTipo().equals(ObjCliente.PESSOA_JURIDICA)) {
            ObjClienteJuridico cf = (ObjClienteJuridico) cliente;
            rbPF.setSelected(true);
            txtCPF.setText(cf.getCnpj());
            txtRG.setText((cf.getIe()));
        }
    }

    private void carregarCidades() {
        listaDeCidades = CidadeDAO.getCidades();
        ObjCidade fake = new ObjCidade(0, "Selecione...");
        listaDeCidades.add(0, fake);

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        for (ObjCidade cid : listaDeCidades) {
            modelo.addElement(cid);
        }
        cmbCidade.setModel(modelo);

    }

    private void esconder() {
        lblCPF.setVisible(false);
        lblRG.setVisible(false);
        txtCPF.setVisible(false);
        txtRG.setVisible(false);
        lblCNPJ.setVisible(false);
        lblIE.setVisible(false);
        txtCNPJ.setVisible(false);
        txtIE.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbCidade = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        rbPF = new javax.swing.JRadioButton();
        rbPJ = new javax.swing.JRadioButton();
        lblCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        lblRG = new javax.swing.JLabel();
        txtRG = new javax.swing.JTextField();
        lblIE = new javax.swing.JLabel();
        txtIE = new javax.swing.JTextField();
        lblCNPJ = new javax.swing.JLabel();
        txtCNPJ = new javax.swing.JFormattedTextField();
        lblCodigo = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Formulário de Cliente");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("codigo:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Telefone:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Endereço:");

        txtEndereco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtTelefone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Cidade:");

        cmbCidade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Alvorada", "Canoas", "Capão da Canoa", "Porto Alegre", "Tangamandápio" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tipo:");

        buttonGroupTipo.add(rbPF);
        rbPF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbPF.setText("Pessoa Física");
        rbPF.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbPFItemStateChanged(evt);
            }
        });
        rbPF.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbPFStateChanged(evt);
            }
        });

        buttonGroupTipo.add(rbPJ);
        rbPJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbPJ.setText("Pessoa Juridica");
        rbPJ.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbPJItemStateChanged(evt);
            }
        });

        lblCPF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCPF.setText("CPF:");

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblRG.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblRG.setText("RG:");

        lblIE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblIE.setText("IE:");

        lblCNPJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCNPJ.setText("CNPJ:");

        try {
            txtCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCodigo.setText("ooo");

        btnLimpar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(rbPF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbPJ)
                .addGap(101, 101, 101))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addComponent(txtTelefone)
                            .addComponent(txtEndereco)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(48, 48, 48)
                                .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnLimpar)
                                    .addGap(311, 311, 311)
                                    .addComponent(btnSalvar))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(cmbCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblIE, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIE, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblRG, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(143, 143, 143))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rbPF)
                    .addComponent(rbPJ))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCPF)
                        .addComponent(lblRG)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCNPJ)
                        .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblIE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnSalvar))
                .addGap(89, 89, 89))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbPFStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbPFStateChanged

    }//GEN-LAST:event_rbPFStateChanged

    private void rbPFItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbPFItemStateChanged
        if (rbPF.isSelected()) {
            escolherPF();

        } else {
            escolherPJ();
        }
    }//GEN-LAST:event_rbPFItemStateChanged
    private void limparFormulario() {
        txtNome.setText("");
        txtTelefone.setText("");
        txtEndereco.setText("");
        txtCPF.setText("");
        txtCNPJ.setText("");
        txtRG.setText("");
        txtIE.setText("");
        buttonGroupTipo.clearSelection();
        cmbCidade.setSelectedIndex(0);
        esconder();

    }
    private void rbPJItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbPJItemStateChanged
        if (rbPJ.isSelected()) {
            escolherPJ();

        } else {
            escolherPF();
        }
    }//GEN-LAST:event_rbPJItemStateChanged

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparFormulario();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome = txtNome.getText();
        ObjCidade cidade = (ObjCidade) cmbCidade.getSelectedItem();
        if (nome.isEmpty() || cidade.getCodigo() == 0) {
            JOptionPane.showMessageDialog(this, "Prencha todos os campos obrigatórios! (Nome e cidade) ");
        } else {
            if (rbPF.isSelected()) {
                ObjClienteFisico cf = new ObjClienteFisico();
                cf.setCodigo((Integer.valueOf(lblCodigo.getText())));
                cf.setNome(nome);
                cf.setEndereco(txtEndereco.getText());
                cf.setTelefone(txtTelefone.getText());
                cf.setCidade(cidade);
                cf.setTipo(ObjCliente.PESSOA_FISICA);
                cf.setCpf(txtCPF.getText());
                cf.setRg(txtRG.getText());

                if (novo) {
                    ClienteFisicoDAO.inserir(cf);
                } else {
                    ClienteFisicoDAO.editar(cf);
                    telaListClientes.carregarTabela(ObjCliente.PESSOA_FISICA);
                }
            } else if (rbPJ.isSelected()) {
                ObjClienteJuridico cj = new ObjClienteJuridico();
                
                cj.setNome(nome);
                cj.setEndereco(txtEndereco.getText());
                cj.setTelefone(txtTelefone.getText());
                cj.setCnpj(txtCNPJ.getText());
                cj.setIe(txtIE.getText());
                cj.setCidade(cidade);
                cj.setTipo(ObjCliente.PESSOA_JURIDICA);

                if (novo) {

                    ClienteJuridicoDAO.inserir(cj);

                } else {
                  cj.setCodigo((Integer.valueOf(lblCodigo.getText())));
                  ClienteJuridicoDAO.editar(cj);
                  telaListClientes.carregarTabela(ObjCliente.PESSOA_JURIDICA);  
                }

            } else {
                ObjCliente cli = new ObjCliente();
                cli.setNome(nome);
                cli.setTelefone(txtTelefone.getText());
                cli.setEndereco(txtEndereco.getText());
                cli.setTipo("");
                cli.setCidade(cidade);

                if (novo) {
                    ClienteDAO.inserir(cli);
                } else {
                    cli.setCodigo((Integer.valueOf(lblCodigo.getText())));
                    ClienteDAO.editar(cli);
                    telaListClientes.carregarTabela("");  
                }

            }

            limparFormulario();
            if (!novo) {
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void escolherPF() {
        lblCPF.setVisible(true);
        lblRG.setVisible(true);
        txtCPF.setVisible(true);
        txtRG.setVisible(true);
        lblCNPJ.setVisible(false);
        lblIE.setVisible(false);
        txtCNPJ.setVisible(false);
        txtIE.setVisible(false);
    }

    private void escolherPJ() {
        lblCPF.setVisible(false);
        lblRG.setVisible(false);
        txtCPF.setVisible(false);
        txtRG.setVisible(false);
        lblCNPJ.setVisible(true);
        lblIE.setVisible(true);
        txtCNPJ.setVisible(true);
        txtIE.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroupTipo;
    private javax.swing.JComboBox<String> cmbCidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblCNPJ;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblIE;
    private javax.swing.JLabel lblRG;
    private javax.swing.JRadioButton rbPF;
    private javax.swing.JRadioButton rbPJ;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtIE;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRG;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
