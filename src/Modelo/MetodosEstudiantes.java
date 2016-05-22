/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Emmanuel
 */
public class MetodosEstudiantes {//Inicio Clase
    ArrayList <Estudiante> arrayEstudiantes;
    ConexionBD conexionBD;
     Archivo archivo;
     ArchivosEstudianteXML archivosEstudianteXML;
    ////////////////////////Constructor/////////////////////////////////////
    public MetodosEstudiantes(ConexionBD conexionBD,Archivo archivo,ArchivosEstudianteXML archivosEstudianteXML){
        arrayEstudiantes=new ArrayList <Estudiante>();
        this.conexionBD=conexionBD;
        this.archivo=archivo;
        this.archivosEstudianteXML=archivosEstudianteXML;
    }
    ///////////////////////////////////Fin Constructor/////////////////////
    
    //agregar
    //Agrega el estudiante al array
public void agregarBD(String informacion[]){
    Estudiante temporal=new Estudiante(informacion[0],informacion[1],informacion[2]);
//    arrayEstudiantes.add(temporal);
     conexionBD.registrarEstudiante(informacion[0],informacion[1],informacion[2]);
}
///////////////////////////////////////Fin agregar/////////////////////////

//corroborarExistencia
//Corrobora la existencia del estudiante
public boolean corroborarExistenciaEstudianteBD(String cedula){
    boolean mensajero=false;
   if(conexionBD.consultarEstudiante(cedula)[0]!=null){
       mensajero=true;
   }
    return mensajero;
}
//////////////////////////////Fin corroborarExistencia///////////////////////

//consultarEstudiante
//Envia los datos del estudiante en un arreglo String
public String[] consultarEstudianteBD(String cedula){
       return conexionBD.consultarEstudiante(cedula);
    }
//////////////////////////////Fin consultarEstudante/////////////////////////////

//modificarEstudiante
//Modifica el estudiante
public void modificarEstudiante(String[] datos){
        conexionBD.actualizarEstudiante(datos[0], datos[1], datos[2]);
 }
//////////////////////////////Fin modificarEstudiante

//eliminar
//Elimina el estudiante
public void eliminar(String cedula){
    conexionBD.eliminarEstudiante(cedula);
   }
//////////////////////////////Fin elimnar///////////////////////////////////////


////////////////////////Metodos ArchivosPlanos/////////////////////////////////
public String[] consultarEstudianteArray(String cedula){
    String arregloDatos[]=new String[3];
    arregloDatos[2]="No Existe";
 for(int contador=0;contador<arrayEstudiantes.size();contador++){
     if(arrayEstudiantes.get(contador).getCedula().equals(cedula)){
         arregloDatos[0]=arrayEstudiantes.get(contador).getNombre();
         arregloDatos[1]=arrayEstudiantes.get(contador).getDireccion();
         arregloDatos[2]="Existe";
             }   
         }
        return arregloDatos;
    }

public boolean corroborarExistenciaEstudianteArchivosPlanos(String cedula){
    boolean mensajero=false;
    for(int contador=0;contador<arrayEstudiantes.size();contador++){
        System.out.println("CED ESTUDIANTE DEL ARRAY="+arrayEstudiantes.get(contador).getCedula());
    if(arrayEstudiantes.get(contador).getCedula().equals(cedula)){
        mensajero=true;
        
     } 
    }
    return mensajero;
}

public void agregarArchivosPlanos(String informacion[]){
    Estudiante temporal=new Estudiante(informacion[0],informacion[1],informacion[2]);
    arrayEstudiantes.add(temporal);
}
//actualizarArchivoPlano
//Actualiza los deatos del archivo plano con los del array
public void actualizarArchivoPlano(){
    archivo.crearArchivoEstudiante();
    for(int contador=0;contador<arrayEstudiantes.size();contador++){
    archivo.ingresarInformacionAlArchivoEstudiante(arrayEstudiantes.get(contador));
  }
}
//////////////////////////////////Fin actualizarArchivoPlano/////////////////

//cargarArchivos
//Carga los archivos con los datos del archivo plano
public void cargarArchivos(){
   arrayEstudiantes=archivo.devolverInformacionArchivoEstudiante();
   System.out.println("Estudiantes en el array");
}

//modificarEstudiante
//Modifica el estudiante en el archivo Plano
public void modificarEstudianteArchivoPlano(String[] datos){
    for(int contador=0;contador<arrayEstudiantes.size();contador++){
        if(arrayEstudiantes.get(contador).getCedula().equals(datos[0])){
            arrayEstudiantes.get(contador).setNombre(datos[1]);
            arrayEstudiantes.get(contador).setDireccion(datos[2]);
        }
    }
 }
//////////////////////////////Fin modificarEstudianteArchivoPlano

//eliminar
//Elimina el estudiante del archivo Plano
public void eliminarArchivoPlano(String cedula){
    for(int contador=0;contador<arrayEstudiantes.size();contador++){
        if(arrayEstudiantes.get(contador).getCedula().equals(cedula)){
            arrayEstudiantes.remove(contador);
             }
        }
   }
//////////////////////////////Fin elimnar///////////////////////////////////////

////////////////////Fin Metodos ArchivosPlanos/////////////////////////////////

////////////////////////////METODOS XML////////////////////////////////////////

//////////////////////////GUARDAR XML//////////////////////////////////////////

public void agregarXML(String arregloInformacion[]){
   archivosEstudianteXML.guardarEstudiantesEnXML(arregloInformacion);
}

public boolean corroborarExistenciaXML(String cedula){
    return archivosEstudianteXML.consultarInformacionEstudianteDelXml(cedula);
}

public String[] buscarXML(String cedula){
    String informacion[]=new String[3];
    if(archivosEstudianteXML.consultarInformacionEstudianteDelXml(cedula)){
        informacion[0]=archivosEstudianteXML.arregloInformacion[1];
        informacion[1]=archivosEstudianteXML.arregloInformacion[2];
    }else{
        informacion[0]="NO EXISTE";
    }
    return informacion;
}

public void editarXML(String[] info){
    archivosEstudianteXML.modificarInformacionEstudianteDelXml(info);
}

public void eliminarXML(String ced){
    archivosEstudianteXML.eliminarInformacionEstudianteDelXml(ced);
}
///////////////////////FIN GUARDAR XML////////////////////////////////////////


/////////////////////////FIN METODOS XML///////////////////////////////////////

}//**********************************Fin de la clase*************************//
