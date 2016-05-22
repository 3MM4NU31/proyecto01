/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.MetodosCursos;
import Vista.JF_MantenimientoCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Emmanuel
 */
public class Controlador_JF_Cursos implements ActionListener {
    MetodosCursos metodosCursos;
    JF_MantenimientoCursos jf_MantenimientoCursos;
    int tipoGuardado;
    
    public Controlador_JF_Cursos(JF_MantenimientoCursos mantenimiento,MetodosCursos metodosCursos,ConexionBD conexionBD,int tipoGuardado){
        jf_MantenimientoCursos=mantenimiento;
        this.metodosCursos=metodosCursos;
        this.tipoGuardado=tipoGuardado;
    }
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("Buscar")){
          buscar();
       }
        if(e.getActionCommand().equals("Guardar")){
            guardar();
       }
         if(e.getActionCommand().equals("Editar")){
             editar();
       }
          if(e.getActionCommand().equals("Eliminar")){
              eliminar();
       }
    }
    
    public void buscar(){
        if(jf_MantenimientoCursos.devolverSigla().equals("")){
            jf_MantenimientoCursos.activarMensaje("Escriba La Sigla.\nGracias.");
        }else{
           switch(tipoGuardado){
            case 1:
                 if(metodosCursos.corroborarExistenciaCurso(jf_MantenimientoCursos.devolverSigla())){
          jf_MantenimientoCursos.mostrarInformacion(metodosCursos.consultarCursoBD(jf_MantenimientoCursos.devolverSigla()));
          jf_MantenimientoCursos.desactivarCasillaSiglas();
          jf_MantenimientoCursos.activarBotones();
           }else{
                jf_MantenimientoCursos.activarMensaje("El Curso No existe.\nGracias.");
           }
                break;
              
        case 2:
            String[] infoAuxiliar=metodosCursos.buscarXML(jf_MantenimientoCursos.devolverSigla());
            System.out.print("INFORMACION RECIBIDA CURSO"+infoAuxiliar[0]+infoAuxiliar[1]+infoAuxiliar[2]);
               if( infoAuxiliar[0].equals("NO EXISTE")){
                    jf_MantenimientoCursos.activarMensaje("El Curso No existe.\nGracias.");
               }else{
                   jf_MantenimientoCursos.mostrarInformacion(infoAuxiliar);
                   jf_MantenimientoCursos.desactivarCasillaSiglas();
                   jf_MantenimientoCursos.activarBotones();
               }
                break;
        
        case 3:
                if(metodosCursos.corroborarExistenciaCursoArchivoPlano(jf_MantenimientoCursos.devolverSigla())){
          jf_MantenimientoCursos.mostrarInformacion(metodosCursos.consultarCursoArchivoPlano(jf_MantenimientoCursos.devolverSigla()));
          jf_MantenimientoCursos.desactivarCasillaSiglas();
          jf_MantenimientoCursos.activarBotones();
           }else{
                jf_MantenimientoCursos.activarMensaje("El Curso No existe.\nGracias.");
           }
                break;    
                
          } 
        }
        
    }//Fin buscar
    
    public void guardar(){
        if(jf_MantenimientoCursos.devolverSigla().equals("")){
            jf_MantenimientoCursos.activarMensaje("Escriba La Sigla.\nGracias.");
        }
        if(jf_MantenimientoCursos.devolverNombre().equals("")){
            jf_MantenimientoCursos.activarMensaje("Escriba El Nombre.\nGracias.");
        }else{
        switch(tipoGuardado){
            case 1:
                
            if(metodosCursos.corroborarExistenciaCurso(jf_MantenimientoCursos.devolverSigla())){
                jf_MantenimientoCursos.activarMensaje("Ya Existe un curso asociado a las siglas "+jf_MantenimientoCursos.devolverSigla());
            }else{
           metodosCursos.agregar(jf_MantenimientoCursos.agregarCurso());
            jf_MantenimientoCursos.activarMensaje("Curso Agregado Correctamente.\nGracias.");
           jf_MantenimientoCursos.limpiarCampos();
            }
                break;
              
        case 2:
                if(metodosCursos.corroborarExistenciaXML(jf_MantenimientoCursos.devolverSigla())){
                    jf_MantenimientoCursos.activarMensaje("Ya Existe un curso asociado a las siglas "+jf_MantenimientoCursos.devolverSigla());
                }else{
                    metodosCursos.agregarCursosXML(jf_MantenimientoCursos.getInformacion());
                    jf_MantenimientoCursos.activarMensaje("Curso Agregado Correctamente.\nGracias.");
                    jf_MantenimientoCursos.limpiarCampos();
                }
                break;
        
        case 3:
                if(metodosCursos.corroborarExistenciaCursoArchivoPlano(jf_MantenimientoCursos.devolverSigla())){
                jf_MantenimientoCursos.activarMensaje("Ya Existe un curso asociado a las siglas "+jf_MantenimientoCursos.devolverSigla());
            }else{
           metodosCursos.agregarArchivoPlano(jf_MantenimientoCursos.agregarCurso());
            jf_MantenimientoCursos.activarMensaje("Curso Agregado Correctamente.\nGracias.");
           jf_MantenimientoCursos.limpiarCampos();
            }
                break;    
                
        }
     }  
    }//FIN AGREGAR
    
    public void editar(){
        if(jf_MantenimientoCursos.devolverSigla().equals("")){
            jf_MantenimientoCursos.activarMensaje("Escriba La Sigla.\nGracias.");
        }else{
            switch(tipoGuardado){
            
            case 1:
           metodosCursos.modificarCurso(jf_MantenimientoCursos.agregarCurso().getSiglas(), jf_MantenimientoCursos.agregarCurso().getNombre(), ""+jf_MantenimientoCursos.agregarCurso().getCreditos());
                    jf_MantenimientoCursos.activarMensaje("Curso Editado Correctamente.\nGracias.");
                    jf_MantenimientoCursos.desactivarBotones();
                    jf_MantenimientoCursos.limpiarCampos();
                break;
              
        case 2:
                metodosCursos.editarXML(jf_MantenimientoCursos.getInformacion());
                jf_MantenimientoCursos.activarMensaje("Curso Editado Correctamente.\nGracias.");
                jf_MantenimientoCursos.desactivarBotones();
                jf_MantenimientoCursos.limpiarCampos();
                break;
        
        case 3:
                
           metodosCursos.modificarCursoArchivoPlano(jf_MantenimientoCursos.agregarCurso().getSiglas(), jf_MantenimientoCursos.agregarCurso().getNombre(), ""+jf_MantenimientoCursos.agregarCurso().getCreditos());
            jf_MantenimientoCursos.activarMensaje("Curso Editado Correctamente.\nGracias.");
            jf_MantenimientoCursos.desactivarBotones();
           jf_MantenimientoCursos.limpiarCampos();
           metodosCursos.actualizarArchivoPlano();
                break;    
                
          }
        }
        
    }//FIN EDITAR
    
    public void eliminar(){
        switch(tipoGuardado){
            case 1:
            metodosCursos.eliminarCurso(jf_MantenimientoCursos.devolverSigla());
            jf_MantenimientoCursos.activarMensaje("Curso Eliminado Correctamente.\nGracias.");
            jf_MantenimientoCursos.desactivarBotones();
            jf_MantenimientoCursos.limpiarCampos();
                break;
              
        case 2:
                metodosCursos.eliminarXML(jf_MantenimientoCursos.devolverSigla());
                jf_MantenimientoCursos.activarMensaje("Curso Eliminado Correctamente.\nGracias.");
                 jf_MantenimientoCursos.desactivarBotones();
                jf_MantenimientoCursos.limpiarCampos();
                break;
        
        case 3:
            metodosCursos.eliminarCursoArchivoPlano(jf_MantenimientoCursos.devolverSigla());
            jf_MantenimientoCursos.activarMensaje("Curso Eliminado Correctamente.\nGracias.");
            jf_MantenimientoCursos.desactivarBotones();
           jf_MantenimientoCursos.limpiarCampos();
           metodosCursos.actualizarArchivoPlano();
                break;    
                
        }
    }//FIN ELIMINAR
    
}//FIN DE LA CLASE
