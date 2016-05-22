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
public class MetodosCursos {//Inicio de la Clase
     ArrayList <Cursos> arrayCursos;
     ConexionBD conexionBD;
     Archivo archivo;
     ArchivosCursosXML archivosCursosXML;
     //Constructor
     public MetodosCursos(ConexionBD conexionBD,Archivo archivo,ArchivosCursosXML archivosCursosXML){
         arrayCursos=new ArrayList <Cursos>();
         this.conexionBD=conexionBD;
         this.archivo=archivo;
         this.archivosCursosXML=archivosCursosXML;
     }
     //Fin del Constructor
     
     ///////////////////////////////////Metodos BD////////////////////////////////////
     public ArrayList<Cursos> getListaCursosMatriculablesBD(){
         return conexionBD.getCursosParaMatricula();
     }
     public Cursos getCursoSeleccionadoBD(String nombre){
         String datosCurso[]=new String[3];
        datosCurso=conexionBD.consultarCursoPorNombre(nombre);
        Cursos cursoAuxiliar=new Cursos(datosCurso[0],datosCurso[1],datosCurso[2]);
        System.out.print(datosCurso[0]+datosCurso[1]+datosCurso[2]);
        return cursoAuxiliar;
     }
     
     
     ////////////////////////////////Fin Metodos BD///////////////////////////////////
     
     
     //getCurso
     //Devuelce los datos del curso seleccionado en el comboBox
     public Cursos getCursoArray(String nombre){
         Cursos cursoAEnviar=new Cursos("","","0");
         for(int contador=0;contador<arrayCursos.size();contador++){
             if(arrayCursos.get(contador).getNombre().equalsIgnoreCase(nombre)){
                 cursoAEnviar=arrayCursos.get(contador);
                 
             }
         }  
         return cursoAEnviar;
     }
     
     ////////////////////////////FIN getCurso///////////////////////////////////////
     
     
     //enviarArrayCursos
     //Retorna el array de Cursos completo
     public ArrayList<Cursos> enviarArrayCursos(){
        return arrayCursos;
    }
     //////////////////////////////////////Fin enviarArrayCursos//////////////////////////
     
     //corroborarExistenciaCurso
     //Corrobora la existencia del curso por su sigla
     public boolean corroborarExistenciaCurso(String siglas){
         boolean mensaje=false;
             if(conexionBD.consultarCursoPorSigla(siglas)[0]!=null){
                mensaje=true;
             }
         
         return mensaje;
     }
     ///////////////////////////////////////Fin corroborarExistenciaCurso///////////////////
     
    
     
      //consultarCurso
     //Devuelve la Informacion de un curso
     //El metodo es utilizado cuando un estudiante tiene una matricula cosolidada y
     //se necesita extraer la informacion de los cursos basados en las siglas de los cursos matriculados
     public String[] consultarCursoBD(String sigla){
         return conexionBD.consultarCursoPorSigla(sigla);
     }
     ////////////////////////////////Fin consultarCurso///////////////////////
     
      //agregar
     //Agrega un curso en el array
     public void agregar(Cursos cursos){
//         arrayCursos.add(cursos);
         conexionBD.registrarCurso(cursos.getSiglas(),cursos.getNombre() ,cursos.getCreditos());
     }
     /////////////////////////////////////Fin agregar////////////////////////////////////////
     
     //modificarCurso
     //Modifica el curso
     public void modificarCurso(String sigla,String nombre,String creditos){
         conexionBD.actualizarCurso(sigla, nombre, Integer.parseInt(creditos));
         
     }
    ////////////////////////////////////////Fin modificarCurso/////////////////////////////////
     
     //eliminarCurso
     //elimina el curso
     public void eliminarCurso(String sigla){
        conexionBD.eliminarCurso(sigla);
     }
   ///////////////////////////////////////Fin eliminarCurso////////////////////////////////////

     
     ////////////////////////////Metodos Archivos Planos////////////////////////////////////
     //corroborarExistenciaCurso
     //Corrobora la existencia del curso por su sigla
     public boolean corroborarExistenciaCursoArchivoPlano(String siglas){
         boolean mensaje=false;
         for(int contador=0;contador<arrayCursos.size();contador++){
             if(arrayCursos.get(contador).getSiglas().equalsIgnoreCase(siglas)){
                mensaje=true;
                 break;
             }
         }
         return mensaje;
     }
     ///////////////////////////////////////Fin corroborarExistenciaCurso///////////////////
     
     //consultarCurso
     //Devuelve la Informacion de un curso
     //El metodo es utilizado cuando un estudiante tiene una matricula cosolidada y
     //se necesita extraer la informacion de los cursos basados en las siglas de los cursos matriculados
     public String[] consultarCursoArchivoPlano(String sigla){
         String curso[]=new String[3];
         curso[0]="No Existe";
         for(int contador=0;contador<arrayCursos.size();contador++){
             if(arrayCursos.get(contador).getSiglas().equalsIgnoreCase(sigla)){
                 curso[0]=arrayCursos.get(contador).getSiglas();
                 curso[1]=arrayCursos.get(contador).getNombre();
                 curso[2]=""+arrayCursos.get(contador).getCreditos();
                 break;
             }
         }
         return curso;
     }
     ////////////////////////////////Fin consultarCurso///////////////////////
     
     //agregar
     //Agrega un curso en el array
     
     public void agregarArchivoPlano(Cursos cursos){
         arrayCursos.add(cursos);
         archivo.crearArchivoCurso();
         actualizarArchivoPlano();
     }
     /////////////////////////////////////Fin agregar////////////////////////////////////////
     
     //actualizarArchivoPlano
     //actualiza el archivo que continene los datos de curso
     //cada vez que se agrega, modifica o elimina un curso.
     public void actualizarArchivoPlano(){
         for(int contador=0;contador<arrayCursos.size();contador++){
         archivo.ingresarInformacionAlArchivoCurso(arrayCursos.get(contador));
        }
     }
     /////////////////////////////////////Fin actualizarArchivoPlano/////////////////////////
     
     //cargarArchivo
     //Carga los datos desde el archivo plano al array
     public void cargarArchivos(){
         arrayCursos=archivo.devolverInformacionArchivoCursos();
     }
     /////////////////////////////////////Fin cargarArchivo///////////////////////////////////
     
     //modificarCurso
     //Modifica el curso
     public void modificarCursoArchivoPlano(String sigla,String nombre,String creditos){
         for(int contador=0;contador<arrayCursos.size();contador++){
             if(arrayCursos.get(contador).getSiglas().equalsIgnoreCase(sigla)){
                 arrayCursos.get(contador).setSiglas(sigla);
                 arrayCursos.get(contador).setNombre(nombre);
                 arrayCursos.get(contador).setCreditos(creditos);
                 break;
             }
         }
         
     }
    ////////////////////////////////////////Fin modificarCurso/////////////////////////////////
     
     //eliminarCurso
     //elimina el curso
     public void eliminarCursoArchivoPlano(String sigla){
         for(int contador=0;contador<arrayCursos.size();contador++){
             if(arrayCursos.get(contador).getSiglas().equalsIgnoreCase(sigla)){
                 arrayCursos.remove(contador);
                 break;
             }
        }
     }
   ///////////////////////////////////////Fin eliminarCurso////////////////////////////////////
     
     ////////////////////////Fin Metodos Archivos Planos///////////////////////////////////

     
     //////////////////////////////////METODOS XML////////////////////////////////
     
     public void agregarCursosXML(String arregloInformacion[]){
   archivosCursosXML.guardarCursosEnXML(arregloInformacion);
}

public boolean corroborarExistenciaXML(String sigla){
    return archivosCursosXML.consultarInformacionCursosDelXml(sigla);
}

public String[] buscarXML(String sigla){
    String informacion[]=new String[3];
    if(archivosCursosXML.consultarInformacionCursosDelXml(sigla)){
        informacion[0]=archivosCursosXML.arregloInformacion[0];
        informacion[1]=archivosCursosXML.arregloInformacion[1];
        informacion[2]=archivosCursosXML.arregloInformacion[2];
    }else{
        informacion[0]="NO EXISTE";
    }
    return informacion;
}

public void editarXML(String[] info){
    archivosCursosXML.modificarInformacionCursosDelXml(info);
}

public void eliminarXML(String sigla){
    archivosCursosXML.eliminarInformacionCursosDelXml(sigla);
}
     

public Cursos getCursoSelecionadoXML(String nombre){
    String[] datos=archivosCursosXML.consultarInformacionCursosDelXmlPorNombre(nombre);
    Cursos curso=new Cursos(datos[0],datos[1],datos[2]);
    return curso;
}
     ////////////////////////////////FIN METODOS XML//////////////////////////////
}//****************************************Fin de la clase *********
