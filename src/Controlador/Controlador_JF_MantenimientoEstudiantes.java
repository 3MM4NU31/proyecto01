/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MetodosEstudiantes;
import Vista.JF_MantenimientoEstudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Emmanuel
 */
public class Controlador_JF_MantenimientoEstudiantes implements ActionListener {
    private String[] datosEstudianteProvisional;
    MetodosEstudiantes metodos;
    JF_MantenimientoEstudiantes jf_MantenimientoEstudiantes;
    int tipoGuardado;
     public Controlador_JF_MantenimientoEstudiantes(JF_MantenimientoEstudiantes jf_MantenimientoEstudiantes,MetodosEstudiantes metodosEstudiantes, int tipoGuardado){
         this.tipoGuardado=tipoGuardado;
         this.jf_MantenimientoEstudiantes=jf_MantenimientoEstudiantes;
         this.metodos=metodosEstudiantes;
         datosEstudianteProvisional=new String[2];
     }
    
     public void buscar(){
         if(jf_MantenimientoEstudiantes.devolverCedula().equalsIgnoreCase("")){
             jf_MantenimientoEstudiantes.activarMensaje("Esriba el numero de cédula.\nGracias.");
         }else{
             
         switch(tipoGuardado){
            case 1:
         datosEstudianteProvisional=metodos.consultarEstudianteBD(jf_MantenimientoEstudiantes.devolverCedula());
           if(datosEstudianteProvisional[0]!=null){
           jf_MantenimientoEstudiantes.mostrarInformacion(datosEstudianteProvisional);
           jf_MantenimientoEstudiantes.desactivarCasillaCedula();
           
           }else{
               jf_MantenimientoEstudiantes.activarMensaje("El Estudiante no existe.\nGracias.");
           }
                break;
                
            case 2:
                String[] arregloAUX=metodos.buscarXML(jf_MantenimientoEstudiantes.devolverCedula());
                if(arregloAUX[0].equalsIgnoreCase("NO EXISTE")){
                    jf_MantenimientoEstudiantes.activarMensaje("El Estudiante no existe.\nGracias.");
                }else{
                    jf_MantenimientoEstudiantes.mostrarInformacion(arregloAUX);
                     jf_MantenimientoEstudiantes.desactivarCasillaCedula();
                }
                break;
                
            case 3:
                
           
           if(metodos.corroborarExistenciaEstudianteArchivosPlanos(jf_MantenimientoEstudiantes.devolverCedula())){
           datosEstudianteProvisional=metodos.consultarEstudianteArray(jf_MantenimientoEstudiantes.devolverCedula());
           jf_MantenimientoEstudiantes.mostrarInformacion(datosEstudianteProvisional);
           jf_MantenimientoEstudiantes.desactivarCasillaCedula();
           
           }else{
               jf_MantenimientoEstudiantes.activarMensaje("El Estudiante no existe.\nGracias.");
           }
                break;
        }
         
         }
     }
     ////////////////////////////////FIN BUSCAR///////////////////////////////////////////////
     
     /////////////////////////////////AGREGAR////////////////////////////////////////////
     public void agregar(){
         if(jf_MantenimientoEstudiantes.devolverCedula().equalsIgnoreCase("")){
             jf_MantenimientoEstudiantes.activarMensaje("Esriba el numero de cédula.\nGracias.");
         }
                
         if(jf_MantenimientoEstudiantes.devolverNombre().equalsIgnoreCase("")){
                jf_MantenimientoEstudiantes.activarMensaje("Esriba un nombre.\nGracias.");
           }
         if(jf_MantenimientoEstudiantes.devolverDireccion().equalsIgnoreCase("")){
            jf_MantenimientoEstudiantes.activarMensaje("Esriba una dirección.\nGracias.");
         
       }else{
         
        
         switch(tipoGuardado){
            case 1:
              if(metodos.corroborarExistenciaEstudianteBD(jf_MantenimientoEstudiantes.devolverCedula())){
                jf_MantenimientoEstudiantes.activarMensaje("Ya existe un Estudiante Agregado con la cédula "+jf_MantenimientoEstudiantes.devolverCedula());
            }else{
               jf_MantenimientoEstudiantes.activarMensaje("Estudiante Agregado Correctamente.\nGracias.");
               metodos.agregarBD(jf_MantenimientoEstudiantes.devolverInformacion());
               jf_MantenimientoEstudiantes.limpiarCampos();
              }   
                break;
                
            case 2:
                if(metodos.corroborarExistenciaXML(jf_MantenimientoEstudiantes.devolverCedula())){
                   jf_MantenimientoEstudiantes.activarMensaje("Ya existe un Estudiante Agregado con la cédula "+jf_MantenimientoEstudiantes.devolverCedula()); 
                }else{
                    jf_MantenimientoEstudiantes.activarMensaje("Estudiante Agregado Correctamente.\nGracias.");
                    metodos.agregarXML(jf_MantenimientoEstudiantes.devolverInformacion());
                    jf_MantenimientoEstudiantes.limpiarCampos();
                }
                break;
                
            case 3:
                
             if(metodos.corroborarExistenciaEstudianteArchivosPlanos(jf_MantenimientoEstudiantes.devolverCedula())){
                jf_MantenimientoEstudiantes.activarMensaje("Ya existe un Estudiante Agregado con la cédula "+jf_MantenimientoEstudiantes.devolverCedula());
            }else{
               jf_MantenimientoEstudiantes.activarMensaje("Estudiante Agregado Correctamente.\nGracias.");
               metodos.agregarArchivosPlanos(jf_MantenimientoEstudiantes.devolverInformacion());
               metodos.actualizarArchivoPlano();
               jf_MantenimientoEstudiantes.limpiarCampos();
              }   

                break;
        }//FIN DEL SWITCH
         }//FIN DE LAS CORROBORACIONES
         
        
     }
     public void editar(){
             
         if(jf_MantenimientoEstudiantes.devolverNombre().equalsIgnoreCase("")){
                jf_MantenimientoEstudiantes.activarMensaje("Esriba un nombre.\nGracias.");
           }
         if(jf_MantenimientoEstudiantes.devolverDireccion().equalsIgnoreCase("")){
            jf_MantenimientoEstudiantes.activarMensaje("Esriba una dirección.\nGracias.");
         
       }else{
             
             
         switch(tipoGuardado){
            case 1:
                metodos.modificarEstudiante(jf_MantenimientoEstudiantes.devolverInformacion());
           jf_MantenimientoEstudiantes.activarMensaje("Estudiante Editado Correctamente.\nGracias.");
           jf_MantenimientoEstudiantes.limpiarCampos();
            metodos.actualizarArchivoPlano();
                break;
                
            case 2:
                metodos.editarXML(jf_MantenimientoEstudiantes.devolverInformacion());
                jf_MantenimientoEstudiantes.activarMensaje("Estudiante Editado Correctamente.\nGracias.");
                jf_MantenimientoEstudiantes.limpiarCampos();
                break;
                
            case 3:
           metodos.modificarEstudianteArchivoPlano(jf_MantenimientoEstudiantes.devolverInformacion());
           jf_MantenimientoEstudiantes.activarMensaje("Estudiante Editado Correctamente.\nGracias.");
           jf_MantenimientoEstudiantes.limpiarCampos();
           metodos.actualizarArchivoPlano();
                break;
        }
       }
     }
     public void eliminar(){
         switch(tipoGuardado){
            case 1:
                metodos.eliminar(jf_MantenimientoEstudiantes.devolverCedula());
           jf_MantenimientoEstudiantes.activarMensaje("Estudiante Eliminado Correctamente.\nGracias.");
           jf_MantenimientoEstudiantes.limpiarCampos();
           
                break;
                
            case 2:
                metodos.eliminarXML(jf_MantenimientoEstudiantes.devolverCedula());
                jf_MantenimientoEstudiantes.activarMensaje("Estudiante Eliminado Correctamente.\nGracias.");
                jf_MantenimientoEstudiantes.limpiarCampos();
                break;
                
            case 3:
                metodos.eliminarArchivoPlano(jf_MantenimientoEstudiantes.devolverCedula());
           jf_MantenimientoEstudiantes.activarMensaje("Estudiante Eliminado Correctamente.\nGracias.");
           jf_MantenimientoEstudiantes.limpiarCampos();
           metodos.actualizarArchivoPlano();
                break;
        }
         
         
     }
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("Buscar")){
           buscar();
 
       }
        if(e.getActionCommand().equals("Guardar")){
            agregar();
    }
         if(e.getActionCommand().equals("Editar")){
           editar();
       }
          if(e.getActionCommand().equals("Eliminar")){
           eliminar();
       }
    }
}
