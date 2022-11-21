/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

/**
 *
 * @author migue
 */
public class FormularioMenu extends javax.swing.JFrame {

    /**
     * Creates new form FormularioMenu
     */
    
    FormularioBebidas formBebidas;
    FormularioCliente formCliente;
    FormularioProveedorAp formProveedorAp;
    FormularioProveedor formProveedor;
    FormularioEmpleado formEmpleado;
    FormularioFranquicia formFranquicia;
    FormularioGerente formGerente;
    
    public FormularioMenu() {
        initComponents();
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
        jButtonBebidas = new javax.swing.JButton();
        jButtonClientes = new javax.swing.JButton();
        jButtonProveedores = new javax.swing.JButton();
        jButtonEmpleados = new javax.swing.JButton();
        jButtonProveedorAP = new javax.swing.JButton();
        jButtonGerente = new javax.swing.JButton();
        jButtonFranquicia = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Bienvenido al menú de la empresa ");

        jButtonBebidas.setText("Bebidas");
        jButtonBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBebidasActionPerformed(evt);
            }
        });

        jButtonClientes.setText("Clientes");
        jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientesActionPerformed(evt);
            }
        });

        jButtonProveedores.setText("Proveedores");
        jButtonProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProveedoresActionPerformed(evt);
            }
        });

        jButtonEmpleados.setText("Empleados");
        jButtonEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEmpleadosActionPerformed(evt);
            }
        });

        jButtonProveedorAP.setText("Proveedor Aprobado");
        jButtonProveedorAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProveedorAPActionPerformed(evt);
            }
        });

        jButtonGerente.setText("Gerente");
        jButtonGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenteActionPerformed(evt);
            }
        });

        jButtonFranquicia.setText("Franquicia");
        jButtonFranquicia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFranquiciaActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(204, 255, 255));
        jSeparator1.setOpaque(true);

        jSeparator3.setBackground(new java.awt.Color(204, 255, 255));
        jSeparator3.setOpaque(true);

        jSeparator4.setBackground(new java.awt.Color(204, 255, 255));
        jSeparator4.setOpaque(true);

        jSeparator5.setBackground(new java.awt.Color(204, 255, 255));
        jSeparator5.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonProveedorAP, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(178, 178, 178)
                                        .addComponent(jButtonFranquicia, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(96, 96, 96))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonProveedorAP, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonFranquicia, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator3)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBebidasActionPerformed
        // TODO add your handling code here:
        dispose();
        this.formBebidas = new FormularioBebidas();
        formBebidas.setVisible(true);
    }//GEN-LAST:event_jButtonBebidasActionPerformed

    private void jButtonEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmpleadosActionPerformed
        // TODO add your handling code here:
        dispose();
        this.formEmpleado = new FormularioEmpleado();
        formEmpleado.setVisible(true);
    }//GEN-LAST:event_jButtonEmpleadosActionPerformed

    private void jButtonGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenteActionPerformed
        // TODO add your handling code here:
        dispose();
        this.formGerente = new FormularioGerente();
        formGerente.setVisible(true);
    }//GEN-LAST:event_jButtonGerenteActionPerformed

    private void jButtonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientesActionPerformed
        // TODO add your handling code here:
        dispose();
        this.formCliente = new FormularioCliente();
        formCliente.setVisible(true);
    }//GEN-LAST:event_jButtonClientesActionPerformed

    private void jButtonProveedorAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProveedorAPActionPerformed
        // TODO add your handling code here:
        dispose();
        this.formProveedorAp = new FormularioProveedorAp();
        formProveedorAp.setVisible(true);
    }//GEN-LAST:event_jButtonProveedorAPActionPerformed

    private void jButtonProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProveedoresActionPerformed
        // TODO add your handling code here:
        dispose();
        this.formProveedor = new FormularioProveedor();
        formProveedor.setVisible(true);
    }//GEN-LAST:event_jButtonProveedoresActionPerformed

    private void jButtonFranquiciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFranquiciaActionPerformed
        // TODO add your handling code here:
        dispose();
        this.formFranquicia = new FormularioFranquicia();
        formFranquicia.setVisible(true);
    }//GEN-LAST:event_jButtonFranquiciaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBebidas;
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonEmpleados;
    private javax.swing.JButton jButtonFranquicia;
    private javax.swing.JButton jButtonGerente;
    private javax.swing.JButton jButtonProveedorAP;
    private javax.swing.JButton jButtonProveedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
