/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Archivo;
import Modelo.ConexionBD;
import Modelo.MetodosUsuarios;
import Vista.JF_MantenimientoUsuarios;
import Vista.JF_MenuPrincipal;
import Vista.JF_Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Emmanuel
 */
public class ControladorUsuarios implements ActionListener {
    private int tipoGuardado;
    ConexionBD conexionBD;
    JF_Usuario jf_Usuario;
    JF_MantenimientoUsuarios jf_MantenimientoUsuarios;
    JF_MenuPrincipal jf_Principal;
    MetodosUsuarios metodosUsuarios;
    Archivo archivo;
    public ControladorUsuarios(int tipoGuardado,ConexionBD conexionBD,JF_MenuPrincipal jf_Principal, MetodosUsuarios metodosUsuarios,Archivo archivo){
        this.tipoGuardado=tipoGuardado;
//        this.conexionBD=conexionBD;
        this.archivo=archivo;
        this.jf_Principal=jf_Principal;
        this.metodosUsuarios=metodosUsuarios;
        metodosUsuarios.cargarArchivos();
    }
    public void setVentaUsuario(JF_Usuario jf_Usuario){
        this.jf_Usuario=jf_Usuario;
    }
    public void setVentaMantenimientoUsuario(JF_MantenimientoUsuarios jf_MantenimientoUsuarios){
        this.jf_MantenimientoUsuarios=jf_MantenimientoUsuarios;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Aceptar")){
            aceptar();
        }
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
    
      //////////////////////////////////////////ACEPTAR /////////////////////////////////
    public void aceptar(){
        switch(tipoGuardado){
            case 1:
                if(metodosUsuarios.corroborarLoginUsuarioBD(jf_Usuario.getCedula(), jf_Usuario.getPassword())){
                    jf_Usuario.setVisible(false);
                    jf_Principal.setVisible(true);
                }else{
                    jf_Usuario.loginIncorrecto();
                }
                break;
                
            case 2:
                if(metodosUsuarios.validarUsuarioXML(jf_Usuario.getCedula(), jf_Usuario.getPassword())){
                    jf_Usuario.setVisible(false);
                    jf_Principal.setVisible(true);
                }else{
                    jf_Usuario.loginIncorrecto();
                }
                break;
                
            case 3:
                if(metodosUsuarios.validarUsuarioArchivoPlano(jf_Usuario.getCedula(), jf_Usuario.getPassword())){
                    jf_Usuario.setVisible(false);
                    jf_Principal.setVisible(true);
                }else{
                    jf_Usuario.loginIncorrecto();
                }
                break;
        }
    }//FIN ACEPTAR
    
      //////////////////////////////////////////BUSCAR /////////////////////////////////
    public void buscar(){
        String[] datos;
        if(jf_MantenimientoUsuarios.getCedula().equals("")){
            jf_MantenimientoUsuarios.activarMensaje("Digite una Cédula.\nGracias.");
           
        }else{
        switch(tipoGuardado){
            case 1:
                 datos=metodosUsuarios.obtenerDatosUsuarioBD(jf_MantenimientoUsuarios.getCedula());
                 if(datos[0]==null){
                     jf_MantenimientoUsuarios.activarMensaje("El Usuario No Existe.\nGracias.");
                     jf_MantenimientoUsuarios.limpiar();
                 }else{
                 jf_MantenimientoUsuarios.setNombre(datos[0]);
                 jf_MantenimientoUsuarios.desactivarCedula();
                 jf_MantenimientoUsuarios.activarBotones();
                 }
                 
                
                break;
                
            case 2:
                datos=metodosUsuarios.buscarXML(jf_MantenimientoUsuarios.getCedula());
                if(datos[0].equals("NO EXISTE")){
                    jf_MantenimientoUsuarios.activarMensaje("El Usuario No Existe.\nGracias.");
                     jf_MantenimientoUsuarios.limpiar();
                }else{
                    jf_MantenimientoUsuarios.setNombre(datos[0]);
                 jf_MantenimientoUsuarios.desactivarCedula();
                 jf_MantenimientoUsuarios.activarBotones();
                }
                break;
                
            case 3:
                datos=metodosUsuarios.consultarUsuariosArchivosPlanos(jf_MantenimientoUsuarios.getCedula());
                if(datos[0]==null){
                    jf_MantenimientoUsuarios.activarMensaje("El Usuario No Existe.\nGracias.");
                }else{
                     jf_MantenimientoUsuarios.setNombre(datos[0]);
                     jf_MantenimientoUsuarios.desactivarCedula();
                     jf_MantenimientoUsuarios.activarBotones();
                     
                }
                break;
          }
        } 
    }//FIN BUSCAR
    
    //////////////////////////////////////////GUARDAR/////////////////////////////////
    public void guardar(){
        String[] aux=new String[3];
        if(jf_MantenimientoUsuarios.getCedula().equals("")){
            jf_MantenimientoUsuarios.activarMensaje("Digite Una Cédula.\nGracias.");
        }
        if(jf_MantenimientoUsuarios.getNombre().equals("")){
            jf_MantenimientoUsuarios.activarMensaje("Digite Un Nombre.\nGracias.");
        }
        if(jf_MantenimientoUsuarios.getPassword().equals("")){
            jf_MantenimientoUsuarios.activarMensaje("Digite Un Password.\nGracias.");
        }else{
            switch(tipoGuardado){
            case 1:
                if(metodosUsuarios.existenciaUsuariosBD()){
                    if(metodosUsuarios.corroborarExistenciaUsuarioBD(jf_MantenimientoUsuarios.getCedula())){
                    metodosUsuarios.guardarUsuarioBD(jf_MantenimientoUsuarios.getCedula(),jf_MantenimientoUsuarios.getNombre(), jf_MantenimientoUsuarios.getPassword());
                    jf_MantenimientoUsuarios.limpiar();
                    jf_MantenimientoUsuarios.activarMensaje("Usuario GuardadO.\nGracias.");
                    }else{
                        jf_MantenimientoUsuarios.activarMensaje("Ya existe un usuario asociado a la cedula:"+jf_MantenimientoUsuarios.getCedula()+".\nGracias.");
                        jf_MantenimientoUsuarios.limpiar();
                        jf_MantenimientoUsuarios.setCedula("");
                        jf_MantenimientoUsuarios.desactivarBotones();
                        jf_MantenimientoUsuarios.activarCedula();
                    }
                }else{
                    if(metodosUsuarios.corroborarExistenciaUsuarioBD(jf_MantenimientoUsuarios.getCedula())){
                    metodosUsuarios.guardarUsuarioBD(jf_MantenimientoUsuarios.getCedula(),jf_MantenimientoUsuarios.getNombre(), jf_MantenimientoUsuarios.getPassword());
                    jf_MantenimientoUsuarios.limpiar();
                    jf_MantenimientoUsuarios.activarMensaje("Usuario Guardado.\nGracias.");
                    jf_MantenimientoUsuarios.setVisible(false);
                    jf_Principal.setVisible(true);
                    
                    
                  }else{
                        jf_MantenimientoUsuarios.activarMensaje("Ya existe un usuario asociado a la cedula:"+jf_MantenimientoUsuarios.getCedula()+".\nGracias.");
                        jf_MantenimientoUsuarios.setCedula("");
                        jf_MantenimientoUsuarios.limpiar();
                        jf_MantenimientoUsuarios.desactivarBotones();
                    }
                }
                
                
                break;
                
            case 2:
                if(metodosUsuarios.corroborarExistenciaXML(jf_MantenimientoUsuarios.getCedula())){
                    jf_MantenimientoUsuarios.activarMensaje("Ya existe un usuario asociado a la cedula:"+jf_MantenimientoUsuarios.getCedula()+".\nGracias.");
                        jf_MantenimientoUsuarios.setCedula("");
                        jf_MantenimientoUsuarios.limpiar();
                        jf_MantenimientoUsuarios.desactivarBotones();
                }else{
                    
                    aux[0]=jf_MantenimientoUsuarios.getCedula();
                    aux[1]=jf_MantenimientoUsuarios.getNombre();
                    aux[2]=jf_MantenimientoUsuarios.getPassword();
                    metodosUsuarios.agregarXML(aux);
                    jf_MantenimientoUsuarios.limpiar();
                    jf_MantenimientoUsuarios.activarMensaje("Usuario Guardado.\nGracias.");
                    jf_MantenimientoUsuarios.setVisible(false);
                    jf_MantenimientoUsuarios.limpiar();
                    jf_MantenimientoUsuarios.desactivarBotones();
                    jf_Principal.setVisible(true);
                }
                break;
                
            case 3:
               if(metodosUsuarios.cantidadDeUsuariosArchivosPlanos()==0){
                aux[0]=jf_MantenimientoUsuarios.getCedula();
                aux[1]=jf_MantenimientoUsuarios.getNombre();
                aux[2]=jf_MantenimientoUsuarios.getPassword();
                metodosUsuarios.agregarArchivosPlanos(aux);
                metodosUsuarios.actualizarArchivoPlano();
                jf_MantenimientoUsuarios.setVisible(false);
                jf_Principal.setVisible(true);
                }else{
                   if(metodosUsuarios.corroborarExistenciaEstudianteArchivosPlanos(jf_MantenimientoUsuarios.getCedula())){
                       jf_MantenimientoUsuarios.activarMensaje("Ya existe un usuario asociado a la cedula:"+jf_MantenimientoUsuarios.getCedula()+".\nGracias.");
                   }else{
                       aux[0]=jf_MantenimientoUsuarios.getCedula();
                aux[1]=jf_MantenimientoUsuarios.getNombre();
                aux[2]=jf_MantenimientoUsuarios.getPassword();
                metodosUsuarios.agregarArchivosPlanos(aux);
                metodosUsuarios.actualizarArchivoPlano();
                jf_MantenimientoUsuarios.activarMensaje("Usuario Guardado.\nGracias.");
                jf_MantenimientoUsuarios.limpiar();
                   }
                
                }
                
                
                break;
            }//FIN SWITCH
         }//FIN ELSE CONDICIONALES
        
    }//FIN METODO GUARDAR
    
      //////////////////////////////////////////EDITAR/////////////////////////////////
    public void editar(){
         String[] aux=new String[3];
        if(jf_MantenimientoUsuarios.getNombre().equals("")){
            jf_MantenimientoUsuarios.activarMensaje("Digite Un Nombre.\nGracias.");
        }
        if(jf_MantenimientoUsuarios.getPassword().equals("")){
            jf_MantenimientoUsuarios.activarMensaje("Digite Un Password.\nGracias.");
        }else{
    switch(tipoGuardado){
            case 1:
                metodosUsuarios.editarUsuarioBD(jf_MantenimientoUsuarios.getCedula(),jf_MantenimientoUsuarios.getNombre(),jf_MantenimientoUsuarios.getPassword());
                jf_MantenimientoUsuarios.limpiar();
                jf_MantenimientoUsuarios.activarMensaje("Usuario Editado Correctamente.\nGracias.");
                jf_MantenimientoUsuarios.activarCedula();
                break;
                
            case 2:
                   
                    aux[0]=jf_MantenimientoUsuarios.getCedula();
                    aux[1]=jf_MantenimientoUsuarios.getNombre();
                    aux[2]=jf_MantenimientoUsuarios.getPassword();
                    metodosUsuarios.editarXML(aux);
                    jf_MantenimientoUsuarios.limpiar();
                    jf_MantenimientoUsuarios.activarMensaje("Usuario Editado Correctamente.\nGracias.");
                    jf_MantenimientoUsuarios.activarCedula();
                break;
                
            case 3:
                aux[0]=jf_MantenimientoUsuarios.getCedula();
                aux[1]=jf_MantenimientoUsuarios.getNombre();
                aux[2]=jf_MantenimientoUsuarios.getPassword();
                metodosUsuarios.modificarUsuarioArchivoPlano(aux);
                metodosUsuarios.actualizarArchivoPlano();
                jf_MantenimientoUsuarios.limpiar();
                jf_MantenimientoUsuarios.activarMensaje("Usuario Editado Correctamente.\nGracias.");
                jf_MantenimientoUsuarios.activarCedula();
                break;
        }
    }
        
    }//FIN EDITAR
    
      ////////////////////////////////////////// ELIMINAR/////////////////////////////////
    
    public void eliminar(){
        switch(tipoGuardado){
            case 1:
               if(metodosUsuarios.corroborarCantidadDeUsuariosBD()){
                 metodosUsuarios.eliminarUsuarioBD(jf_MantenimientoUsuarios.getCedula());
                   jf_MantenimientoUsuarios.activarMensaje("Usuario Eliminado Correctamente.\nGracias.");
                   jf_MantenimientoUsuarios.limpiar();
                   jf_MantenimientoUsuarios.desactivarBotones();
                   jf_MantenimientoUsuarios.activarCedula();
            }else{
                 jf_MantenimientoUsuarios.activarMensaje("Imposible Eliminar.\nSolo hay un Usuario en existencia.\nGracias.");
                 jf_MantenimientoUsuarios.desactivarBotones();
                 jf_MantenimientoUsuarios.activarCedula();
                 jf_MantenimientoUsuarios.limpiar();
               }
                break;
                
            case 2:
                if(metodosUsuarios.permisoBorradoXML()){
                    metodosUsuarios.eliminarXML(jf_MantenimientoUsuarios.getCedula());
                    jf_MantenimientoUsuarios.activarMensaje("Usuario Eliminado Correctamente.\nGracias.");
                   jf_MantenimientoUsuarios.limpiar();
                   jf_MantenimientoUsuarios.desactivarBotones();
                   jf_MantenimientoUsuarios.activarCedula();
                }else{
                 jf_MantenimientoUsuarios.activarMensaje("Imposible Eliminar.\nSolo hay un Usuario en existencia.\nGracias.");
                 jf_MantenimientoUsuarios.desactivarBotones();
                 jf_MantenimientoUsuarios.activarCedula();
                 jf_MantenimientoUsuarios.limpiar();
                }
                
                break;
                
            case 3:
                if(metodosUsuarios.cantidadDeUsuariosArchivosPlanos()>1){
                    metodosUsuarios.eliminarArchivoPlano(jf_MantenimientoUsuarios.getCedula());
                    metodosUsuarios.actualizarArchivoPlano();
                    jf_MantenimientoUsuarios.activarMensaje("Usuario Eliminado Correctamente.\nGracias.");
                   jf_MantenimientoUsuarios.limpiar();
                   jf_MantenimientoUsuarios.desactivarBotones();
                   jf_MantenimientoUsuarios.activarCedula();
                }else{
                     jf_MantenimientoUsuarios.activarMensaje("Imposible Eliminar.\nSolo hay un Usuario en existencia.\nGracias.");
                 jf_MantenimientoUsuarios.desactivarBotones();
                 jf_MantenimientoUsuarios.activarCedula();
                 jf_MantenimientoUsuarios.limpiar();
                    
                }
                break;
        }
    }//FIN ELIMINAR
    
      //////////////////////////////////////////FIN DE LA CLASE/////////////////////////////////
    
}
