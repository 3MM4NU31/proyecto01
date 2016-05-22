/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Emmanuel
 */
public class MetodosUsuarios {
    ArrayList<Usuario> usuariosArray;
    ConexionBD conexionBD;
    Archivo archivo;
    ArchivosUsuarioXML archivosUsuarioXML;
    public MetodosUsuarios(ConexionBD conexionBD,Archivo archivo,ArchivosUsuarioXML archivosUsuarioXML){
        usuariosArray=new ArrayList<Usuario>();
        this.conexionBD=conexionBD;
        this.archivo=archivo;
        this.archivosUsuarioXML=archivosUsuarioXML;
    }
    
    /////////////////////////////////Metodos BD//////////////////////////////
    public void guardarUsuarioBD(String cedula,String nombre, String password){
        conexionBD.registrarUsuario(cedula, nombre, password);
    }
    
    public boolean corroborarLoginUsuarioBD(String ced, String password){
        return conexionBD.corroborarLoginUsuarios(ced, password);
    }
    public boolean existenciaUsuariosBD(){
       return conexionBD.corroborarExistenciaUsuarios();
    }
    
    public String[] obtenerDatosUsuarioBD(String ced){
        return conexionBD.corroborarExistenciaDeUsuarioPorCedula(ced);
    }
    public boolean corroborarExistenciaUsuarioBD(String ced){
       if(conexionBD.corroborarExistenciaDeUsuarioPorCedula(ced)[0]==null){
           return true;
       }else{
           return false;
       }
    }
    public void editarUsuarioBD(String cedula,String nombre, String password){
        conexionBD.actualizarUsuario(cedula, nombre, password);
    }
    public void eliminarUsuarioBD(String ced){
        conexionBD.eliminarUsuario(ced);
    }
    public boolean corroborarCantidadDeUsuariosBD(){
        return conexionBD.corroborarCantidadDeUsuarios();
    }
    //////////////////////////////Fin Metodos BD/////////////////////////////
    
    
    
    //Metodo de corroboración de existencia de Usuarios
    
    public int cantidadDeUsuariosArchivosPlanos(){
        return usuariosArray.size();
    }
    public boolean existeUsuario(int tipoGuardado){
        boolean existe=false;
        switch(tipoGuardado){
            case 1:
                existe=existenciaUsuariosBD();
                break;
                
            case 2:
                if(archivosUsuarioXML.corroborarExistenciaUsuariosXML()>0){
                  existe=true;
                }
                break;
                
            case 3:
                if(usuariosArray.size()>0){
                  existe=true;
                }
                break;
        }
        return existe;
    }
    
    
    
    
    ////////////////////////Metodos ArchivosPlanos/////////////////////////////////
public String[] consultarUsuariosArchivosPlanos(String cedula){
    String arregloDatos[]=new String[3];
    arregloDatos[2]="No Existe";
 for(int contador=0;contador<usuariosArray.size();contador++){
     if(usuariosArray.get(contador).getCedula().equals(cedula)){
         arregloDatos[0]=usuariosArray.get(contador).getNombre();
         arregloDatos[1]=usuariosArray.get(contador).getPassword();
         arregloDatos[2]="Existe";
             }   
         }
        return arregloDatos;
    }

public boolean corroborarExistenciaEstudianteArchivosPlanos(String cedula){
    boolean mensajero=false;
    for(int contador=0;contador<usuariosArray.size();contador++){
    if(usuariosArray.get(contador).getCedula().equals(cedula)){
        mensajero=true;
     } 
    }
    return mensajero;
}

public void agregarArchivosPlanos(String informacion[]){
    Usuario usuario=new Usuario(informacion[0],informacion[1],informacion[2]);
    usuariosArray.add(usuario);
    actualizarArchivoPlano();
}
//actualizarArchivoPlano
//Actualiza los deatos del archivo plano con los del array
public void actualizarArchivoPlano(){
    archivo.crearArchivoUsuarios();
    for(int contador=0;contador<usuariosArray.size();contador++){
    archivo.ingresarInformacionAlArchivoUsuarios(usuariosArray.get(contador));
  }
}
//////////////////////////////////Fin actualizarArchivoPlano/////////////////

//cargarArchivos
//Carga los archivos con los datos del archivo plano
public void cargarArchivos(){
   usuariosArray=archivo.devolverInformacionArchivoUsuario();
   System.out.println("Usuarios en el array");
}

//modificarEstudiante
//Modifica el estudiante en el archivo Plano
public void modificarUsuarioArchivoPlano(String[] datos){
    for(int contador=0;contador<usuariosArray.size();contador++){
        if(usuariosArray.get(contador).getCedula().equals(datos[0])){
            usuariosArray.get(contador).setNombre(datos[1]);
            usuariosArray.get(contador).setPassword(datos[2]);
        }
    }
 }
//////////////////////////////Fin modificarEstudianteArchivoPlano

//eliminar
//Elimina el estudiante del archivo Plano
public void eliminarArchivoPlano(String cedula){
    for(int contador=0;contador<usuariosArray.size();contador++){
        if(usuariosArray.get(contador).getCedula().equals(cedula)){
            usuariosArray.remove(contador);
             }
        }
   }

public boolean validarUsuarioArchivoPlano(String cedula,String password){
    boolean respuesta=false;
    for(int contador=0;contador<usuariosArray.size();contador++){
        if(usuariosArray.get(contador).getCedula().equals(cedula)){
            if(usuariosArray.get(contador).getPassword().equals(password)){
                respuesta=true;
            }else{
                respuesta=false;
                break;
            }
        }
    }  
    return respuesta;
}
//////////////////////////////Fin elimnar///////////////////////////////////////

////////////////////Fin Metodos ArchivosPlanos/////////////////////////////////
    


    ////////////////////////////METODOS XML////////////////////////////////////////

//////////////////////////GUARDAR XML//////////////////////////////////////////

public void agregarXML(String arregloInformacion[]){
   archivosUsuarioXML.guardarUsuarioEnXML(arregloInformacion);
}

public boolean corroborarExistenciaXML(String cedula){
    return archivosUsuarioXML.consultarInformacionUsuariosDelXml(cedula);
}

public String[] buscarXML(String cedula){
    String informacion[]=new String[3];
    if(archivosUsuarioXML.consultarInformacionUsuariosDelXml(cedula)){
        informacion[0]=archivosUsuarioXML.arregloInformacion[1];
        informacion[1]=archivosUsuarioXML.arregloInformacion[2];
    }else{
        informacion[0]="NO EXISTE";
    }
    return informacion;
}

public void editarXML(String[] info){
    archivosUsuarioXML.modificarInformacionUsuariosDelXml(info);
}

public void eliminarXML(String ced){
    archivosUsuarioXML.eliminarInformacionUsuariosDelXml(ced);
}

public boolean validarUsuarioXML(String ced,String password){
    String informacion[]=new String[3];
    boolean corroboracion=false;
    if(archivosUsuarioXML.consultarInformacionUsuariosDelXml(ced)){
        informacion[0]=archivosUsuarioXML.arregloInformacion[1];
        informacion[1]=archivosUsuarioXML.arregloInformacion[2];
        if(informacion[1].equals(password)){
            corroboracion=true;
        }
    }
    return corroboracion;
}

public boolean permisoBorradoXML(){
    if(archivosUsuarioXML.corroborarExistenciaUsuariosXML()>1){
          return true;
                }else{
           return false;
    }
}
///////////////////////FIN GUARDAR XML////////////////////////////////////////


/////////////////////////FIN METODOS XML///////////////////////////////////////
    
    
    
    
    
    
    
}
