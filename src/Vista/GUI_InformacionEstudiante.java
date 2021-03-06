/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_JF_MantenimientoEstudiantes;

/**
 *
 * @author Emmanuel
 */
public class GUI_InformacionEstudiante extends javax.swing.JPanel {

    /**
     * Creates new form GUI_InformacionEstudiante
     */
    public GUI_InformacionEstudiante() {
        initComponents();
    }
    public void desactivarCasillaCedula(){
         jTCedula.setEnabled(false);
     }
   public String[] devolverInformacion(){
       String arreglo[];
       arreglo=new String[3];
       arreglo[0]=this.jTCedula.getText();
       arreglo[1]=this.jTNombre.getText();
       arreglo[2]=this.jTDireccion.getText();
       return arreglo;
   }
   public String devolverCedula(){
       return this.jTCedula.getText();
   }
   public String devolverNombre(){
       return this.jTNombre.getText();
   }
   public String devolverDireccion(){
       return this.jTDireccion.getText();
   }
   public void setDatos(String[] info){
       jTNombre.setText(info[0]);
       jTDireccion.setText(info[1]);
   }
   public void limpiar(){
       jTCedula.setText(null);
       jTCedula.setEnabled(true);
       jTNombre.setText(null);
       jTDireccion.setText(null);
       
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLCedula = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jLDireccion = new javax.swing.JLabel();
        jTCedula = new javax.swing.JTextField();
        jTNombre = new javax.swing.JTextField();
        jTDireccion = new javax.swing.JTextField();

        setOpaque(false);

        jLCedula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLCedula.setForeground(new java.awt.Color(255, 255, 255));
        jLCedula.setText("Cédula");

        jLNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLNombre.setText("Nombre");

        jLDireccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLDireccion.setForeground(new java.awt.Color(255, 255, 255));
        jLDireccion.setText("Dirección");

        jTCedula.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCedulaKeyReleased(evt);
            }
        });

        jTNombre.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNombreActionPerformed(evt);
            }
        });

        jTDireccion.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLDireccion)
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addComponent(jLNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(jTCedula))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCedula)
                    .addComponent(jTCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNombreActionPerformed

    private void jTCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCedulaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCedulaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLCedula;
    private javax.swing.JLabel jLDireccion;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JTextField jTCedula;
    private javax.swing.JTextField jTDireccion;
    private javax.swing.JTextField jTNombre;
    // End of variables declaration//GEN-END:variables
}
