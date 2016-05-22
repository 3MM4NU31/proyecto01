/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.Matricula;
import Modelo.MetodosCursos;
import Modelo.MetodosEstudiantes;
import Modelo.MetodosMatricula;
import Vista.JF_Matricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Emmanuel
 */
public class Controlador_JF_Matricula implements ActionListener{//Inicio de la clase
    MetodosMatricula metodos;
    JF_Matricula matricula;
    MetodosEstudiantes metodosEstudiantes;
    MetodosCursos metodosCursos;
    Matricula matriculaObjeto;
    ConexionBD conexionBD;
    int tipoGuardado;
    ///////////////////////Constructor////////////////////////////
    public Controlador_JF_Matricula(JF_Matricula matricula, MetodosEstudiantes metodosEstudiantes, MetodosCursos metodosCursos,MetodosMatricula metodosMatricula,int tipoGuardado) {
        metodos=metodosMatricula;
        this.metodosEstudiantes=metodosEstudiantes;
        this.metodosCursos=metodosCursos;
        this.matricula=matricula;
        this.tipoGuardado=tipoGuardado;
    }
///////////////////////////Fin del Constructor////////////////////
    
    @Override
    //////////////////////////////Eventos//////////////////////////////
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Aceptar")){
            aceptar();
        }
        if(e.getActionCommand().equals("Matricular")){
            matricular();
        }
        if(e.getActionCommand().equals("Guardar")){
            guardar();
        }
        
        if(e.getActionCommand().equals("Eliminar")){
           eliminar();
        }
        
        if(e.getActionCommand().equals("Limpiar")){
            
            matricula.reiniciar();
        }
    }
    /////////////////////////////////Fin Eventos///////////////////////////////
    
    //Aceptar
    public void aceptar(){
        switch(tipoGuardado){
            case 1:
          if(metodos.corroborarExistenciaMatriculaBD(matricula.getCedula()).equals("")){
               
                if(metodos.corroborarCedulaExistenteBD(matricula.getCedula())){
                matriculaObjeto=new Matricula(matricula.getCedula(),metodos.getCodigo());
                matricula.llenarMatriculables(metodosCursos.getListaCursosMatriculablesBD());
                matricula.habilitarCampos();
                matricula.iniciaMatricula(metodosEstudiantes.consultarEstudianteBD(matricula.getCedula())[0],metodosEstudiantes.consultarEstudianteBD(matricula.getCedula())[1]);
//                 System.out.println("DATA2"+metodosEstudiantes.consultarEstudianteBD(matricula.getCedula())[0]+metodosEstudiantes.consultarEstudianteBD(matricula.getCedula())[1]);
                matricula.setCodigoMatricula(metodos.getCodigo());
             }  
                
            }else{
               matricula.iniciaMatricula(metodosEstudiantes.consultarEstudianteBD(matricula.getCedula())[0],metodosEstudiantes.consultarEstudianteBD(matricula.getCedula())[1]);
                matricula.setCodigoMatricula(metodos.getCodigoMatricula(matricula.getCedula()));
                matricula.llenarListaMatriculaConsolidada(metodos.getDatosDeMatricula(metodos.corroborarExistenciaMatriculaBD(matricula.getCedula())));
                matricula.desaccionarCampos();
            }
            break;
            case 2:
                if(metodos.corroborarExistenciaMatriculaXML(matricula.getCedula())){
                    
                }else{
                    if(metodosEstudiantes.buscarXML(matricula.getCedula())[0].equals("NO EXISTE")){
                        
                    }else{
                    matricula.iniciaMatricula(metodosEstudiantes.buscarXML(matricula.getCedula())[0],metodosEstudiantes.buscarXML(matricula.getCedula())[1]);
                    matricula.llenarMatriculables(metodos.siglasCurso());
                    matricula.habilitarCampos();
                    matricula.setCodigoMatricula(metodos.getCodigo());
                    matriculaObjeto=new Matricula(matricula.getCedula(),metodos.getCodigo());
                    }
                    
                }
                break;
                
            case 3:
                if(metodos.corroborarExistenciaMatriculaArchivosPlanos(matricula.getCedula())){
                     matricula.iniciaMatricula(metodosEstudiantes.consultarEstudianteArray(matricula.getCedula())[0],metodosEstudiantes.consultarEstudianteArray(matricula.getCedula())[1]);
                     matricula.setCodigoMatricula(metodos.getCodigoMatricula(matricula.getCedula()));
                     matricula.llenarListaMatriculaConsolidada(metodos.getCursosMatriculadosArchivosPlanos(matricula.getCedula()));
                     matricula.desaccionarCampos();
                }else{
                  if(metodos.corroborarCedulaExistenteArchivosPlanos(matricula.getCedula())){
                      matriculaObjeto=new Matricula(matricula.getCedula(),metodos.getCodigo());
                      matricula.llenarMatriculables(metodosCursos.enviarArrayCursos());
                      matricula.habilitarCampos();
                       matricula.iniciaMatricula(metodosEstudiantes.consultarEstudianteArray(matricula.getCedula())[0],metodosEstudiantes.consultarEstudianteArray(matricula.getCedula())[1]);
                       matricula.setCodigoMatricula(metodos.getCodigo());
                  }  
                }
                break;
        }
        
        
        
    }//Fin Aceptar
    
    //Matricular
    public void matricular(){
        switch(tipoGuardado){
            case 1:
          matriculaObjeto.agregarCurso(matricula.getSiglaCurso());
          matricula.llenarListaMatriculados();
            case 2:
                
                break;
                
            case 3:
                matriculaObjeto.agregarCurso(matricula.getSiglaCurso());
                matricula.llenarListaMatriculados();
                break;
        }
        
    }//fin Matricular
   
    //Guardar
    public void guardar(){
        
        switch(tipoGuardado){
            case 1:
          metodos.guardarMatriculaBD(matriculaObjeto);
          
            case 2:
                
                break;
                
            case 3:
                metodos.guardarMatriculaArchivoPlano(matriculaObjeto);
                metodos.actualizarArchivoPlano();
                matriculaObjeto=null;
                matricula.reiniciar();
                break;
        }
        
            
            matriculaObjeto=null;
            matricula.reiniciar();
    }//Fin Guardar
    
    //Eliminar
    public void eliminar(){
        switch(tipoGuardado){
            case 1:
            metodos.eliminarMatriculaBD(matricula.getCedula());
             matricula.reiniciar();    
            case 2:
                
                break;
                
            case 3:
            metodos.eliminarMatriculaArray(matricula.getCedula());
             metodos.actualizarArchivoPlano();
            matricula.reiniciar();
                break;
        }
        
            
    }//Fin Eliminar
    
}//**********************************Fin de la clase********************//
