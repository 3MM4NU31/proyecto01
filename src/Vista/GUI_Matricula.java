/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Cursos;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Emmanuel Acuña Mora.
 */
public class GUI_Matricula extends javax.swing.JPanel {//Inicio clase
    private ActionListener controlador;
    DefaultListModel listaMatriculados;
    DefaultTableModel modelo;
    
    public GUI_Matricula() {//Constructor
        initComponents();
        listaMatriculados = new DefaultListModel();
        modelo=new DefaultTableModel();
        this.jTMatriculados.setModel(modelo);
        colocarTitulosTabla();
        
    }//Fin constructor

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jL_Cedula = new javax.swing.JLabel();
        jT_Cedula = new javax.swing.JTextField();
        jBAceptar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCMatriculables = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBMatricula = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTSiglas = new javax.swing.JTextField();
        jTCreditos = new javax.swing.JTextField();
        jTNombre = new javax.swing.JTextField();
        jTDireccion = new javax.swing.JTextField();
        jBGuardar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMatriculados = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTCodigoMatricula = new javax.swing.JTextField();
        jBLimpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setLayout(null);

        jL_Cedula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jL_Cedula.setForeground(new java.awt.Color(255, 255, 255));
        jL_Cedula.setText("Cédula.");
        add(jL_Cedula);
        jL_Cedula.setBounds(80, 20, 60, 40);

        jT_Cedula.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        add(jT_Cedula);
        jT_Cedula.setBounds(70, 50, 110, 30);

        jBAceptar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jBAceptar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Emmanuel\\Documents\\NetBeansProjects\\Ejercicio01\\src\\img\\Aceptar.png")); // NOI18N
        jBAceptar.setToolTipText("Aceptar");
        jBAceptar.setActionCommand("Aceptar");
        add(jBAceptar);
        jBAceptar.setBounds(190, 50, 50, 30);
        add(jSeparator1);
        jSeparator1.setBounds(-30, 90, 1010, 10);
        add(jSeparator2);
        jSeparator2.setBounds(-20, 170, 1120, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cursos para Matrícula.");
        add(jLabel1);
        jLabel1.setBounds(10, 90, 200, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cursos Matrículados.");
        add(jLabel2);
        jLabel2.setBounds(10, 170, 180, 20);

        jCMatriculables.setFont(new java.awt.Font("Consolas", 1, 10)); // NOI18N
        jCMatriculables.setEnabled(false);
        add(jCMatriculables);
        jCMatriculables.setBounds(100, 130, 160, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cursos.");
        add(jLabel3);
        jLabel3.setBounds(100, 110, 80, 16);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sigla.");
        add(jLabel4);
        jLabel4.setBounds(270, 110, 60, 20);

        jBMatricula.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jBMatricula.setIcon(new javax.swing.ImageIcon("C:\\Users\\Emmanuel\\Documents\\NetBeansProjects\\Ejercicio01\\src\\img\\Matricular.png")); // NOI18N
        jBMatricula.setText("Matrícular.");
        jBMatricula.setActionCommand("Matricular");
        jBMatricula.setEnabled(false);
        add(jBMatricula);
        jBMatricula.setBounds(400, 130, 120, 30);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Créditos.");
        add(jLabel5);
        jLabel5.setBounds(350, 110, 60, 20);

        jTSiglas.setEditable(false);
        jTSiglas.setFont(new java.awt.Font("Consolas", 1, 10)); // NOI18N
        add(jTSiglas);
        jTSiglas.setBounds(270, 130, 70, 30);

        jTCreditos.setEditable(false);
        jTCreditos.setFont(new java.awt.Font("Consolas", 1, 10)); // NOI18N
        add(jTCreditos);
        jTCreditos.setBounds(350, 130, 40, 30);

        jTNombre.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jTNombre.setForeground(new java.awt.Color(255, 255, 255));
        jTNombre.setToolTipText("Nombre");
        jTNombre.setEnabled(false);
        add(jTNombre);
        jTNombre.setBounds(270, 20, 150, 30);

        jTDireccion.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jTDireccion.setForeground(new java.awt.Color(255, 255, 255));
        jTDireccion.setToolTipText("Dirección");
        jTDireccion.setEnabled(false);
        add(jTDireccion);
        jTDireccion.setBounds(270, 60, 150, 30);

        jBGuardar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jBGuardar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Emmanuel\\Documents\\NetBeansProjects\\Ejercicio01\\src\\img\\Guar_dar.png")); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.setEnabled(false);
        add(jBGuardar);
        jBGuardar.setBounds(390, 200, 130, 40);

        jBEliminar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jBEliminar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Emmanuel\\Documents\\NetBeansProjects\\Ejercicio01\\src\\img\\Elimi_nar.png")); // NOI18N
        jBEliminar.setText("Eliminar");
        jBEliminar.setEnabled(false);
        add(jBEliminar);
        jBEliminar.setBounds(390, 240, 130, 40);

        jTMatriculados.setFont(new java.awt.Font("Consolas", 1, 10)); // NOI18N
        jTMatriculados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTMatriculados.setEnabled(false);
        jTMatriculados.setOpaque(false);
        jScrollPane1.setViewportView(jTMatriculados);

        add(jScrollPane1);
        jScrollPane1.setBounds(100, 200, 280, 110);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cod. Matrícula.");
        add(jLabel6);
        jLabel6.setBounds(460, 20, 120, 20);

        jTCodigoMatricula.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jTCodigoMatricula.setEnabled(false);
        add(jTCodigoMatricula);
        jTCodigoMatricula.setBounds(460, 60, 90, 30);

        jBLimpiar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jBLimpiar.setText("Limpiar");
        add(jBLimpiar);
        jBLimpiar.setBounds(390, 280, 130, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Datos.");
        add(jLabel7);
        jLabel7.setBounds(10, 10, 80, 20);
    }// </editor-fold>//GEN-END:initComponents
   
    //agregarEventos
    //envia el controlador a cada boton para ser escuchado
    public void agregarEventos(ActionListener controlador,ItemListener manejador){
         this.controlador=controlador;
         this.jT_Cedula.addActionListener(controlador);
         this.jBAceptar.addActionListener(controlador);
         this.jBGuardar.addActionListener(controlador);
         this.jCMatriculables.addItemListener(manejador);
         this.jBMatricula.addActionListener(controlador);
         this.jBEliminar.addActionListener(controlador);
         this.jBLimpiar.addActionListener(controlador);
    }
    //////////////////////////////Fin agregarEventos//////////////////////////////////
    
    //colocarTitulosTabla
    //coloca los nombres de las columnas al jTable de cursos
    public void colocarTitulosTabla(){
         modelo.addColumn("Sigla");
        modelo.addColumn("Nombre");
        modelo.addColumn("Créditos");
      }
     //////////////////////////////Fin colocarTitulos//////////////////////////////////
    
    //setCodigo
    //muestra el codigo de la matricula en el jTextfield correspondiente
    public void setCodigo(String codigo){
        jTCodigoMatricula.setText(codigo);
    }
     //////////////////////////////Fin setCdigo////////////////////////////////////////
    
    //getSiglaCurso
    //devuelve la sigla en jTextField jTSiglas
    public String getSiglaCurso(){
        return jTSiglas.getText();
    }
     //////////////////////////////Fin getSiglaCurso///////////////////////////////////
    
    //getSeleccionado
    //Envia el cursoSeleccionado en el jComboBox jCMatriculables.
    public String getSeleccionado(){
     return (String) jCMatriculables.getSelectedItem();
    }
    //////////////////////////////Fin getCursoSeleccionado////////////////////////////
    
    //getCedula
    //Envia la cedula escrita en el jTextField jT_Cedula
    public String getCedula(){
        return jT_Cedula.getText();
    }
    //////////////////////////////Fin getCedula///////////////////////////////////////
    
    //llenarDatosCursos
    //llena los textfields correspondientes a siglas y creditos
    public void llenarDatosCursos(String siglas,String creditos){
        jTSiglas.setText(siglas);
        jTCreditos.setText(creditos);
    }
    //////////////////////////////Fin llenarDatosCursos//////////////////////////////////
   
    //llenarListaMatriculados
    //llena el jTable con los cursos que se van agregando a la matricula.
    public void llenarListaMatriculados(){
        String [] matriculado= new String[3];
        matriculado[0]=jTSiglas.getText();
        matriculado[1]=""+jCMatriculables.getSelectedItem();
        matriculado[2]=""+jTCreditos.getText();
        modelo.addRow(matriculado);
        jCMatriculables.removeItem(jCMatriculables.getSelectedItem());
        if(jCMatriculables.getItemCount()==0){
            jCMatriculables.setEnabled(false);
            jBMatricula.setEnabled(false);
        }
    }   
    //////////////////////////////Fin llenarMatriculados////////////////////////////////
    

    ///////////////////////////////Fin llenarListaMatriculaExistente BD////////////////////
    //llenarListaMatriculaExistente
    //Llena el jTable con los cursos matriculados cuando existe un matricula consolidada en archivos planos.
    public void llenarListaMatriculaExistente(String [][] listaMatriculados){
        String[] listaMatriculadoAnadir;
//        System.out.println("LISTA CURSOS MATRCULADOS LENGTH: "+listaMatriculados.length);
        for(int contador=0;contador<listaMatriculados.length;contador++){
            listaMatriculadoAnadir=new String[3];
            System.out.println("CURSOS: "+listaMatriculados[contador][0]+listaMatriculados[contador][1]+listaMatriculados[contador][2]);
            listaMatriculadoAnadir[0]=listaMatriculados[contador][0];
            listaMatriculadoAnadir[1]=listaMatriculados[contador][1];
            listaMatriculadoAnadir[2]=listaMatriculados[contador][2];
            modelo.addRow(listaMatriculadoAnadir);
         }
        
    }
    ///////////////////////////////Fin llenarListaMatriculaExistente Arch. Planos////////////////////
    
    //iniciaMatricula
    //Habilita los botones y campos necesarios para matricular
    public void iniciaMatricula(String nombre,String direccion){
        jT_Cedula.setEnabled(false);
        jBMatricula.setEnabled(true);
        jBAceptar.setEnabled(false);
        jBGuardar.setEnabled(true);
        jTNombre.setText(nombre);
        jTDireccion.setText(direccion);
    }
    //////////////////////////////Fin iniciaMatricula/////////////////////////////////
    
    //reiniciar
    //Reinicia la ventana
    public void reiniciar(){
        listaMatriculados.clear();
        jBMatricula.setEnabled(false);
        jT_Cedula.setText("");
        jBAceptar.setEnabled(true);
        jCMatriculables.removeAllItems();
        jCMatriculables.setEnabled(false);
        jTSiglas.setText("");
        jTCreditos.setText("");
        jT_Cedula.setEnabled(true);
        jTNombre.setText("");
        jTDireccion.setText("");
        jTCodigoMatricula.setText("");
        jCMatriculables.setEnabled(true);
        jBEliminar.setEnabled(false);
        jBGuardar.setEnabled(false);
        reiniciarTabla();
    }
    //////////////////////////////Fin reiniciar///////////////////////////////////////
    
    //reiniciarTabla
    //reinicia la tabla
    public void reiniciarTabla(){
        System.out.println("Numero de Filas jList= "+modelo.getRowCount());
        for(int i=0;i<modelo.getRowCount();i++){
        modelo.removeRow(i);
        i--;
     }
    }
    //////////////////////////////Fin reiniciarTabla/////////////////////////////////
    
    //llenarJCMatriculables
    //llena el jComboBox con los cursos existentes para Matricular.
    public void llenarJCMatriculables(ArrayList<Cursos> cursos){
        for(int contador=0;contador<cursos.size();contador++){
            jCMatriculables.addItem(cursos.get(contador).getNombre());
        }
    }
    
    //////////////////////////////Fin llenarJCMatriculables//////////////////////////
    
        
   //mostrarMensaje
    //permite imprimir cualquier mensaje en un JOption
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }
    //////////////////////////////Fin mostrarMensaje/////////////////////////////////
    
    //accionarCampos
    //hablita el comboBox de cursos y el boton matricula
   public void accionarCampos() {
     jCMatriculables.setEnabled(true);
     jBMatricula.setEnabled(true);
      }
   //////////////////////////////Fin accionarCampos//////////////////////////////////
   
   //desaccionarCampos
   //Desacciona los campos cuando existe una matricula preExistente y acciona el boton Eliminar
   public void desaccionarCampos(){
       jCMatriculables.setEnabled(false);
       jBMatricula.setEnabled(false);
       jBGuardar.setEnabled(false);
       jBEliminar.setEnabled(true);
   }
   ////////////////////////////Fin DesaccionarCampos/////////////////////////////////
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAceptar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBMatricula;
    private javax.swing.JComboBox jCMatriculables;
    private javax.swing.JLabel jL_Cedula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTCodigoMatricula;
    private javax.swing.JTextField jTCreditos;
    private javax.swing.JTextField jTDireccion;
    private javax.swing.JTable jTMatriculados;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTSiglas;
    private javax.swing.JTextField jT_Cedula;
    // End of variables declaration//GEN-END:variables

   
}///////////////////////////////////////////////////FIN DE LA CLASE//////////////////////////////////////////////////////
