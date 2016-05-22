/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorUsuarios;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Emmanuel
 */
public class JF_MantenimientoUsuarios extends javax.swing.JFrame {

    ControladorUsuarios controlador;
    JF_MenuPrincipal menuPrincipal;
    public JF_MantenimientoUsuarios(ControladorUsuarios controlador) {
        initComponents();
        this.controlador=controlador;
        gUI_Botones1.desactivarBotones();
        gUI_Botones1.agregarEventos(controlador);
    }
    
    public void desactivarCedula(){
        jT_Cedula.setEnabled(false);
    }
     public void activarCedula(){
        jT_Cedula.setEnabled(true);
    }
    public String getCedula(){
        return jT_Cedula.getText();
    }
    public String getNombre(){
        return jT_Nombre.getText();
    }
    public String getPassword(){
        String a=String.valueOf(jP_Password.getPassword());
        return a;
    }
   
    public void setCedula(String ced){
        jT_Cedula.setText(ced);
    }
    
    public void setNombre(String nombre){
        jT_Nombre.setText(nombre);
    }
    
    public void setNombre(){
        jP_Password.setText("");
    }
    public void limpiar(){
          jT_Cedula.setText("");
           jT_Nombre.setText("");
            jP_Password.setText("");
    }
    public void activarBotones(){
        gUI_Botones1.activarBotones();
    }
    
    public void desactivarBotones(){
        gUI_Botones1.desactivarBotones();
    }
    public void activarMensaje(String mensaje){
    JOptionPane.showMessageDialog(null,mensaje);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jT_Nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jT_Cedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jP_Password = new javax.swing.JPasswordField();
        gUI_Botones1 = new Vista.GUI_Botones();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setLocation(new java.awt.Point(300, 0));
        setMinimumSize(new java.awt.Dimension(448, 426));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(238, 238, 238));
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 160, 90, 20);
        getContentPane().add(jT_Nombre);
        jT_Nombre.setBounds(190, 120, 140, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(238, 238, 238));
        jLabel3.setText("Cedula");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 80, 60, 16);
        getContentPane().add(jT_Cedula);
        jT_Cedula.setBounds(190, 80, 140, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(238, 238, 238));
        jLabel4.setText("Nombre");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 120, 70, 20);
        getContentPane().add(jP_Password);
        jP_Password.setBounds(190, 160, 140, 20);
        getContentPane().add(gUI_Botones1);
        gUI_Botones1.setBounds(20, 210, 360, 70);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Emmanuel\\Documents\\NetBeansProjects\\Ejercicio01\\src\\img\\UsersIcono.png")); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 0, 70, 70);

        jLabel6.setFont(new java.awt.Font("Masque", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(238, 238, 238));
        jLabel6.setText("Mantenimiento Usuarios");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(100, 10, 320, 50);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(100, 50, 300, 10);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Emmanuel\\Documents\\NetBeansProjects\\Ejercicio01\\src\\img\\UsersFondo.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-670, -70, 1180, 860);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.GUI_Botones gUI_Botones1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jP_Password;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jT_Cedula;
    private javax.swing.JTextField jT_Nombre;
    // End of variables declaration//GEN-END:variables
}
