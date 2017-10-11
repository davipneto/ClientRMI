package bolsav;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * A classe Client_BolsaV implementa um JFrame que exibe as opções de compra,
 * venda e monitoramento de ações na aplicação de forma visual.
 *
 * @author Davi Pereira Neto
 * @author Geovana Franco Santos
 */
public class Client_BolsaV extends javax.swing.JFrame {

    public CliImpl client;

    /**
     * Cria um novo frame para um cliente
     */
    public Client_BolsaV(CliImpl client) {
        initComponents();
        jPMonitor.setVisible(true);
        this.client = client;
        //atualiza a tabela de monitoramento
        setUpTableMonitor();
        this.client.frame_client = this;
        this.setTitle("Cliente " + client.id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPMonitor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBRefresh = new javax.swing.JButton();
        jBBuy = new javax.swing.JButton();
        jBMonitor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jBFilter = new javax.swing.JButton();
        jPWallet = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jBRegister = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jBSell = new javax.swing.JButton();
        jBRefresh2 = new javax.swing.JButton();
        jBLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empresa", "Valor", "Quantidade Disponível"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jBRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh-button.png"))); // NOI18N
        jBRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRefreshActionPerformed(evt);
            }
        });

        jBBuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buy.png"))); // NOI18N
        jBBuy.setText("Comprar");
        jBBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuyActionPerformed(evt);
            }
        });

        jBMonitor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/progress-report.png"))); // NOI18N
        jBMonitor.setText("Monitorar");
        jBMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMonitorActionPerformed(evt);
            }
        });

        jLabel1.setText("Empresa: ");

        jTextField1.setText(" ");

        jBFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/magnifier.png"))); // NOI18N
        jBFilter.setText("Filtrar");
        jBFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPMonitorLayout = new javax.swing.GroupLayout(jPMonitor);
        jPMonitor.setLayout(jPMonitorLayout);
        jPMonitorLayout.setHorizontalGroup(
            jPMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMonitorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPMonitorLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBRefresh))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPMonitorLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jBBuy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBMonitor)
                .addGap(43, 43, 43))
        );
        jPMonitorLayout.setVerticalGroup(
            jPMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPMonitorLayout.createSequentialGroup()
                .addGroup(jPMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPMonitorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBRefresh))
                    .addGroup(jPMonitorLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBFilter))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPMonitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBBuy)
                    .addComponent(jBMonitor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Monitor", jPMonitor);

        jLabel7.setText("Empresa:");

        jLabel8.setText("Quantidade:");

        jLabel9.setText("Preço Mínimo:");

        jBRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buy.png"))); // NOI18N
        jBRegister.setText("Cadastrar");
        jBRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegisterActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Disponível para Venda");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empresa", "Quantidade", "Preço", "Disponível"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
        }

        jBSell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/shopping.png"))); // NOI18N
        jBSell.setText("Vender");
        jBSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSellActionPerformed(evt);
            }
        });

        jBRefresh2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        jBRefresh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRefresh2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPWalletLayout = new javax.swing.GroupLayout(jPWallet);
        jPWallet.setLayout(jPWalletLayout);
        jPWalletLayout.setHorizontalGroup(
            jPWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPWalletLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPWalletLayout.createSequentialGroup()
                        .addGroup(jPWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPWalletLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel9))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField8)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPWalletLayout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPWalletLayout.createSequentialGroup()
                                .addComponent(jBRegister)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBRefresh2)
                                .addGap(28, 28, 28))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPWalletLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jBSell)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPWalletLayout.setVerticalGroup(
            jPWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPWalletLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPWalletLayout.createSequentialGroup()
                        .addGroup(jPWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPWalletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBRegister)
                        .addComponent(jBRefresh2)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSell)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Minha Carteira", jPWallet);

        jBLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        jBLogout.setText("Sair");
        jBLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBLogout)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Botão para atualizar os dados da tabela de monitoramento
     *
     * @param evt
     */
    private void jBRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRefreshActionPerformed
        //atualizar dados da tabela
        setUpTableMonitor();
    }//GEN-LAST:event_jBRefreshActionPerformed

    /**
     * Botão para executar a compra de ações selecionada
     *
     * @param evt
     */
    private void jBBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuyActionPerformed
        int linha = jTable1.getSelectedRow();
        double price = 0;
        int qntd = 0;
        if (linha != -1) {
            //se a ação está disponível para venda
            if (jTable1.getValueAt(linha, 2).toString().compareTo("0") != 0) {
                //código para mostrar um panel na caixa de diálogo
                JTextField priceField = new JTextField(5);
                JTextField qntdField = new JTextField(5);
                Object[] message = {"Informe preço máximo e quantidade desejada\n\nPreço:", priceField, "Quantidade:", qntdField};

                int result = JOptionPane.showConfirmDialog(null, message, "Compra", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION && !priceField.getText().isEmpty() && !qntdField.getText().isEmpty()) {
                    price = Double.parseDouble(priceField.getText().replace(".", ","));
                    qntd = Integer.parseInt(qntdField.getText());

                    String company = jTable1.getValueAt(linha, 0).toString();
                    try {
                        //chama o método do servidor para realizar a compra
                        client.server.buy(client, company, price, qntd);
                    } catch (RemoteException ex) {
                        Logger.getLogger(Client_BolsaV.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tente novamente e preencha todos os campos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ação selecionada não disponível para venda");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma ação selecionada");
        }

    }//GEN-LAST:event_jBBuyActionPerformed

    /**
     * Botão para deixar como disponível uma ação para venda, para isso pega o
     * valor da tabela e atualiza a disponibilidade
     *
     * @param evt
     */
    private void jBSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSellActionPerformed
        int linha = jTable2.getSelectedRow();
        if (linha != -1) {
            String company = jTable2.getValueAt(linha, 0).toString();
            int qntd = Integer.parseInt(jTable2.getValueAt(linha, 1).toString());
            Double price = Double.parseDouble(jTable2.getValueAt(linha, 2).toString());
            //cria uma nova ação com os dados da tabela
            Stock stock = new Stock(company, qntd, price);
            //atualiza disponibilidade de compra
            stock.setAvailable(true);
            //chama o método insert q verifica se existe a ação e a atualiza
            client.insertStock(stock);
            setUpTableWallet();
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma ação selecionada");
        }
    }//GEN-LAST:event_jBSellActionPerformed

    /**
     * Botão que cadastra uma nova ação a partir dos dados inseridos nas textbox
     *
     * @param evt
     */
    private void jBRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegisterActionPerformed
        if (!(jTextField7.getText().isEmpty() || jTextField8.getText().isEmpty() || jTextField9.getText().isEmpty())) {
            String company = jTextField7.getText();
            int qntd = Integer.parseInt(jTextField8.getText());
            Double price = Double.parseDouble(jTextField9.getText());
            Stock stock = new Stock(company, qntd, price);
            stock.setAvailable(jCheckBox1.isSelected());
            client.insertStock(stock);
            setUpTableWallet();
        }
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jCheckBox1.setSelected(false);
    }//GEN-LAST:event_jBRegisterActionPerformed

    /**
     * Botão que ativa um cliente para monitoramento de ações de uma determinada
     * companhia
     *
     * @param evt
     */
    private void jBMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMonitorActionPerformed
        int linha = jTable1.getSelectedRow();
        if (linha != -1) {
            try {
                //chama no cliente o método de se subscrever
                client.server.subscribe(client, jTable1.getValueAt(linha, 0).toString());
            } catch (RemoteException ex) {
                Logger.getLogger(Client_BolsaV.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma ação selecionada");
        }
    }//GEN-LAST:event_jBMonitorActionPerformed

    /**
     * Botão que filtra a empresa desejada pelo usuário
     *
     * @param evt
     */
    private void jBFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFilterActionPerformed
        if (!jTextField1.getText().isEmpty()) {
            String company = jTextField1.getText();
            //metodo que filtra os dados da tabela
            setUpTableMonitorSearch(company);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum dado para pesquisa");
        }
    }//GEN-LAST:event_jBFilterActionPerformed

    /**
     * Botão que atualiza a tabela da carteira do cliente
     *
     * @param evt
     */
    private void jBRefresh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRefresh2ActionPerformed
        // TODO add your handling code here:
        setUpTableWallet();
    }//GEN-LAST:event_jBRefresh2ActionPerformed

    /**
     * Botão que realiza o logout do cliente e apaga da base de dados do
     * servidor as ações que relacionam a ele
     *
     * @param evt
     */
    private void jBLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLogoutActionPerformed
        try {
            client.server.logout(client);
        } catch (RemoteException ex) {
            Logger.getLogger(Client_BolsaV.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_jBLogoutActionPerformed

    /**
     * Método que pega os dados da lista de ações presentes no servidor e
     * atualiza a tabela de monitoramento
     */
    void setUpTableMonitor() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            //atualizar a tabela a partir dos dados no servidor
            tableModel.setRowCount(0);
            int qntd;
            for (StockCli s : client.server.getStocks()) {
                //verifica se a ação não é do próprio cliente
                if (s.id != client.id) {
                    //se a ação não está disponível pra venda a quantidade aparece como 0
                    if (!s.getStock().isAvailable()) {
                        qntd = 0;
                    } else {
                        qntd = s.getStock().getQt();
                    }
                    tableModel.addRow(new Object[]{s.getStock().getCompany(), s.getStock().getPrice(), qntd});
                }
            }

            jTable1.setModel(tableModel);
            tableModel.fireTableDataChanged();
        } catch (RemoteException ex) {
            Logger.getLogger(Client_BolsaV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que pega os dados da lista de ações presentes no cliente e
     * atualiza a tabela de carteira
     */
    void setUpTableWallet() {
        DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
        //atualizar a tabela a partir dos dados no cliente
        tableModel.setRowCount(0);
        for (Stock s : client.getStocks()) {
            if (s.getQt() != 0) {
                tableModel.addRow(new Object[]{s.getCompany(), s.getQt(), s.getPrice(), s.isAvailable()});
            }
        }
        jTable2.setModel(tableModel);
        tableModel.fireTableDataChanged();
    }

    /**
     * Método que busca as ações presentes no servidor e filtra de acordo com o
     * que o cliente busca
     *
     * @param company com a empresa que o cliente busca
     */
    void setUpTableMonitorSearch(String company) {
        try {
            company = company.trim();
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            //atualizar a tabela a partir dos dados do servidor
            tableModel.setRowCount(0);
            int qntd;
            for (StockCli s : client.server.getStocks()) {
                //verifica se é ação da empresa buscada
                if (s.getStock().getCompany().contains(company)) {
                    //verifica se a ação não é do próprio cliente
                    if (s.id != client.id) {
                        if (!s.getStock().isAvailable()) {
                            qntd = 0;
                        } else {
                            qntd = s.getStock().getQt();
                        }
                        tableModel.addRow(new Object[]{s.getStock().getCompany(), s.getStock().getPrice(), qntd});
                    }
                }
            }

            jTable1.setModel(tableModel);
            tableModel.fireTableDataChanged();
        } catch (RemoteException ex) {
            Logger.getLogger(Client_BolsaV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuy;
    private javax.swing.JButton jBFilter;
    private javax.swing.JButton jBLogout;
    private javax.swing.JButton jBMonitor;
    private javax.swing.JButton jBRefresh;
    private javax.swing.JButton jBRefresh2;
    private javax.swing.JButton jBRegister;
    private javax.swing.JButton jBSell;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPMonitor;
    private javax.swing.JPanel jPWallet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
