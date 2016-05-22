/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_JF_MenuPrincipal;
import Modelo.Archivo;
import Modelo.ArchivosCursosXML;
import Modelo.ArchivosEstudianteXML;
import Modelo.ArchivosMatriculaXML;
import Modelo.ConexionBD;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Emmanuel
 */
public class JF_MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JF_MenuPrincipal
     */
    Controlador_JF_MenuPrincipal controlador_JF_MenuPrincipal;
    ConexionBD conexionBD;
    JF_MantenimientoUsuarios mantenimientoUsuarios;
    ArchivosEstudianteXML archivosEstudianteXML;
    public JF_MenuPrincipal(ConexionBD conexionBD,int tipoGuardado,Archivo archivo,ArchivosEstudianteXML archivosEstudianteXML,ArchivosCursosXML archivosCursosXML,ArchivosMatriculaXML archivosMatriculaXML) {//Construcor
        super("Control De Matrícula");
        initComponents();
        this.conexionBD=conexionBD;
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Emmanuel\\Documents\\NetBeansProjects\\Ejercicio01\\src\\img\\Girasol.png"));
        controlador_JF_MenuPrincipal= new Controlador_JF_MenuPrincipal(this.conexionBD, tipoGuardado,archivo,archivosEstudianteXML,archivosCursosXML,archivosMatriculaXML);
        agregarEventos();
        setVisible(false);
    }
    /////////////////////Fin Constructor//////////////////////////////////
    
    public void inicio(){
        
    }
    //agregarEventos
    //Agrega en controlador a los diferentes elementos
   public void agregarEventos(){
       this.jB_Estudiantes.addActionListener(controlador_JF_MenuPrincipal);
       this.jB_Cursos.addActionListener(controlador_JF_MenuPrincipal);
       this.jB_Matricula.addActionListener(controlador_JF_MenuPrincipal);
       this.jB_Usuarios.addActionListener(controlador_JF_MenuPrincipal);
   }
    //////////////Fin agregarEventos//////////////////////////////////////
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jB_Estudiantes = new javax.swing.JButton();
        jB_Cursos = new javax.swing.JButton();
        jB_Matricula = new javax.swing.JButton();
        jB_Usuarios = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(300, 0));
        setMaximumSize(new java.awt.Dimension(650, 450));
        setMinimumSize(new java.awt.Dimension(650, 450));
        setPreferredSize(new java.awt.Dimension(650, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        jB_Estudiantes.setBackground(new java.awt.Color(0, 51, 102));
        jB_Estudiantes.setForeground(new java.awt.Color(0, 51, 102));
        jB_Estudiantes.setIcon(new javax.swing.ImageIcon("C:\\Users\\Emmanuel\\Documents\\NetBeansProjects\\Ejercicio01\\src\\img\\Student.png")); // NOI18N
        jB_Estudiantes.setToolTipText("Estudiantes");
        jB_Estudiantes.setActionCommand("Estudiantes");
        jB_Estudiantes.setBorder(null);
        jB_Estudiantes.setBorderPainted(false);
        jB_Estudiantes.setContentAreaFilled(false);
        jB_Estudiantes.setFocusPainted(false);
        getContentPane().add(jB_Estudiantes);
        jB_Estudiantes.setBounds(10, 30, 120, 120);

        jB_Cursos.setBackground(new java.awt.Color(0, 51, 102));
        jB_Cursos.setForeground(new java.awt.Color(0, 51, 102));
        jB_Cursos.setIcon(new javax.swing.ImageIcon("C:\\Users\\Emmanuel\\Documents\\NetBeansProjects\\Ejercicio01\\src\\img\\Book.png")); // NOI18N
        jB_Cursos.setToolTipText("Cursos");
        jB_Cursos.setActionCommand("Cursos");
        jB_Cursos.setBorder(null);
        jB_Cursos.setBorderPainted(false);
        jB_Cursos.setContentAreaFilled(false);
        jB_Cursos.setFocusPainted(false);
        jB_Cursos.setOpaque(false);
        getContentPane().add(jB_Cursos);
        jB_Cursos.setBounds(10, 160, 120, 120);

        jB_Matricula.setBackground(new java.awt.Color(0, 51, 102));
        jB_Matricula.setForeground(new java.awt.Color(0, 51, 102));
        jB_Matricula.setIcon(new javax.swing.ImageIcon("C:\\Users\\Emmanuel\\Documents\\NetBeansProjects\\Ejercicio01\\src\\img\\Matri.png")); // NOI18N
        jB_Matricula.setToolTipText("Matriculas");
        jB_Matricula.setActionCommand("Matricula");
        jB_Matricula.setBorder(null);
        jB_Matricula.setBorderPainted(false);
        jB_Matricula.setContentAreaFilled(false);
        jB_Matricula.setFocusPainted(false);
        jB_Matricula.setOpaque(false);
        getContentPane().add(jB_Matricula);
        jB_Matricula.setBounds(10, 290, 120, 120);

        jB_Usuarios.setBackground(new java.awt.Color(0, 51, 102));
        jB_Usuarios.setForeground(new java.awt.Color(0, 51, 102));
        jB_Usuarios.setIcon(new javax.swing.ImageIcon("C:\\Users\\Emmanuel\\Documents\\NetBeansProjects\\Ejercicio01\\src\\img\\Users.png")); // NOI18N
        jB_Usuarios.setToolTipText("Usuarios");
        jB_Usuarios.setActionCommand("Usuarios");
        jB_Usuarios.setBorder(null);
        jB_Usuarios.setBorderPainted(false);
        jB_Usuarios.setContentAreaFilled(false);
        jB_Usuarios.setFocusPainted(false);
        getContentPane().add(jB_Usuarios);
        jB_Usuarios.setBounds(530, 30, 120, 120);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Emmanuel\\Documents\\NetBeansProjects\\Ejercicio01\\src\\img\\1462605666_splash_beta_orange.png")); // NOI18N
        jLabel3.setToolTipText("Version 1.1 -Inestable-.");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(390, 20, 50, 50);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(190, 350, 320, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Emmanuel\\Documents\\NetBeansProjects\\Ejercicio01\\src\\img\\Fondo(1).png")); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(852, 551));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-640, -290, 1930, 840);

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void setMantenimientoUsuarios(JF_MantenimientoUsuarios mantenimientoUsuarios) {
        controlador_JF_MenuPrincipal.setMantenimientoUsuarios(mantenimientoUsuarios);
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Cursos;
    private javax.swing.JButton jB_Estudiantes;
    private javax.swing.JButton jB_Matricula;
    private javax.swing.JButton jB_Usuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

   
}
////////////////////////////////////////Fin de la Clase////////////////////////////
