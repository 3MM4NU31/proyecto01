/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador2_JF_Matricula;
import Modelo.MetodosCursos;
import Modelo.MetodosEstudiantes;
import Controlador.Controlador_JF_Matricula;
import Modelo.Archivo;
import Modelo.ArchivosCursosXML;
import Modelo.ArchivosEstudianteXML;
import Modelo.ArchivosMatriculaXML;
import Modelo.ConexionBD;
import Modelo.Cursos;
import Modelo.MetodosMatricula;
import java.awt.Toolkit;
import java.util.ArrayList;
/**
 *
 * @author Emmanuel
 */
public class JF_Matricula extends javax.swing.JFrame {
   Controlador_JF_Matricula controlador_JF_Matricula;
   Controlador2_JF_Matricula manejadorItems;
   MetodosMatricula metodosMatricula;
    public JF_Matricula(MetodosEstudiantes metodosEstudiantes,MetodosCursos metodosCursos,ConexionBD conexionBD,int tipoGuardado,Archivo archivo,ArchivosEstudianteXML archivosEstudianteXML, ArchivosCursosXML archivosCursosXML, ArchivosMatriculaXML archivosMatriculaXML) {//Contructor
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Emmanuel\\Documents\\NetBeansProjects\\Ejercicio01\\src\\img\\Matricula_Icono_1.png"));
        setVisible(false);
        metodosMatricula=new MetodosMatricula(metodosEstudiantes,metodosCursos,conexionBD,archivo,archivosEstudianteXML,archivosCursosXML,archivosMatriculaXML);
        manejadorItems=new Controlador2_JF_Matricula(this,metodosEstudiantes,metodosCursos,metodosMatricula,tipoGuardado,conexionBD);
        controlador_JF_Matricula=new Controlador_JF_Matricula(this,metodosEstudiantes, metodosCursos,metodosMatricula, tipoGuardado);  
        gUI_Matricula1.agregarEventos(controlador_JF_Matricula,manejadorItems);
        metodosMatricula.cargarMatriculasArchivosPlanos();
    }
    
    ////////////////////////////Fin Constructor////////////////////////////////
    
    //seCodgoMatricula
    //Muestra el codigo de matricula que es generado en metodos matricula.
    public void setCodigoMatricula(String codigo){
        gUI_Matricula1.setCodigo(codigo);
    }
    //////////////////////////Fin setCodigoMatricula//////////////////////////
    
    //getSiglaCurso
    //devuelve la sigla del curso seleccionada en el comboBox en el GUI_Matricula
    public String getSiglaCurso(){
        return gUI_Matricula1.getSiglaCurso();
    }
  /////////////////////////Fin getSiglaCuros//////////////////////////////////
    
    //llenarListaMatriculas
    //llama al metodo del mismo nombre al momento de matricula un curso.
    public void llenarListaMatriculados(){
        gUI_Matricula1.llenarListaMatriculados();
        
    }
    
    /////////////////////////Fin llenarListaMatricula
    
    //llenarListaMatriculaConsolidada
    //llama al metodo del mismo nombre al momento ingresar un carne con matricula consolidada
    public void llenarListaMatriculaConsolidada(String [][] listaMatriculados){
         gUI_Matricula1.llenarListaMatriculaExistente(listaMatriculados);
    }
    
    /////////////////////////Fin llenarListaMatriculaConsolidad//////////////////
    
    //llenarDatosCurso
    //llamada al metodo del mismoNombre para llenar las casillas correspondientes
    public void llenarDatosCurso(String sigla, String creditos){
        gUI_Matricula1.llenarDatosCursos(sigla, creditos);
    }
    
    /////////////////////////Fin llenarDatosCurso
    
    //getSeleccionado
    //llama al metodo del mismo nombre para devolver el curso seleccionado
    public String getSeleccionado(){
        return gUI_Matricula1.getSeleccionado();
    }
    
    /////////////////////////Fin getSeleccionado///////////////////////////////
    
    //llenarMatriculables
    //Envia los datos para llenar el comboBox con los cursos existentes para matricula
    public void llenarMatriculables(ArrayList<Cursos> cursos){
        gUI_Matricula1.llenarJCMatriculables(cursos);
    }
    public void llenarMatriculablesConSiglasXML(ArrayList<String> siglas){
        
    }
    /////////////////////////Fin llenarMatriculables//////////////////////////
    
    //iniciaMatricula
    //Metodo para iniciar una nueva matricula
    public void iniciaMatricula(String nombre, String direccion){
        System.out.println("DATA3"+nombre+direccion);
        gUI_Matricula1.iniciaMatricula(nombre,direccion);
    }
    /////////////////////////Fin iniciaMatricula/////////////////////////////
    
    //getCedula
    public String getCedula(){
        return gUI_Matricula1.getCedula();
    }
    /////////////////////////////fin getcedula///////////////////////////
    
    //reiniciar
    //Reinicia el GUI_Matricula
    public void reiniciar(){
        gUI_Matricula1.reiniciar();
    }
    /////////////////////////Fin reiniciar//////////////////////////////
    
    //desaccionarCampos
    //llamada al metodo del mismo nombre
    public void desaccionarCampos(){
        gUI_Matricula1.desaccionarCampos();
    }
    /////////////////////////Fin desaccionarCampos
    
    //habilitarCampos
    public void habilitarCampos(){
        gUI_Matricula1.accionarCampos();
    }
     /////////////////////////Fin habilitarCampos
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gUI_Matricula1 = new Vista.GUI_Matricula();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setTitle("Matrícula");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(300, 0));
        setPreferredSize(new java.awt.Dimension(708, 555));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        gUI_Matricula1.setOpaque(false);
        getContentPane().add(gUI_Matricula1);
        gUI_Matricula1.setBounds(10, 70, 940, 310);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Emmanuel\\Documents\\NetBeansProjects\\Ejercicio01\\src\\img\\Matricula_Icono.png")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(190, 0, 120, 70);

        jLabel1.setFont(new java.awt.Font("Masque", 1, 24)); // NOI18N
        jLabel1.setText("Matrícula");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 10, 190, 29);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(280, 40, 170, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Emmanuel\\Documents\\NetBeansProjects\\Ejercicio01\\src\\img\\FondoMatricula01_1.png")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-380, 0, 1110, 930);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        reiniciar();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.GUI_Matricula gUI_Matricula1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
////////////////////////////////////Fin de la Clase////////////////////////////
