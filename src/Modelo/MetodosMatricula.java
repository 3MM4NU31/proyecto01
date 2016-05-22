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
public class MetodosMatricula {//Inicio de la clase
    ArrayList<Matricula> matriculas;
    MetodosEstudiantes metodosEstudiantes;
    MetodosCursos metodosCursos;
    ConexionBD conexionBD;
    Archivo archivo;
    ArchivosEstudianteXML archivosEstudianteXML;
    ArchivosCursosXML archivosCursosXML;
    ArchivosMatriculaXML archivosMatriculaXML;
    ///////////////////////Constructor///////////////////////////////////////
    public MetodosMatricula(MetodosEstudiantes metodosEstudiantes, MetodosCursos metodosCursos, ConexionBD conexionBD,Archivo archivo,ArchivosEstudianteXML archivosEstudianteXML, ArchivosCursosXML archivosCursosXML, ArchivosMatriculaXML archivosMatriculaXML){
        matriculas=new ArrayList<Matricula>();
        this.metodosEstudiantes=metodosEstudiantes;
        this.metodosCursos=metodosCursos;
        this.conexionBD=conexionBD;
        this.archivo=archivo;
        this.archivosCursosXML=archivosCursosXML;
        this.archivosEstudianteXML=archivosEstudianteXML;
        this.archivosMatriculaXML=archivosMatriculaXML;
    }
    /////////////////////Fin del Constructor/////////////////////////////////
    
    ///////////////////Metodos Base Datos///////////////////////////////
    public void guardarMatriculaBD(Matricula matriculaObjeto){
        conexionBD.registrarMatricula(matriculaObjeto.getCodigoMatricula(), matriculaObjeto.getCedulaEstudiante());
        for(int contador=0;contador<matriculaObjeto.getSiglasCursos().size();contador++){
        conexionBD.registrarCursosMatriculados(matriculaObjeto.getCodigoMatricula(),matriculaObjeto.getSiglasCursos().get(contador));
        }
    }
    
    public String corroborarExistenciaMatriculaBD(String cedula){
        return conexionBD.corroborarExistenciaDeMatriculaPorCedula(cedula);
         
        
    }
    public String[][] getDatosDeMatricula(String codMatricula){
        ArrayList<String> datos=conexionBD.obtenerDatosDeMatriculaPorCodigo(codMatricula);
        System.out.println("CANTIDAD DE CURSOS MATRICULADOS ="+datos.size());
        String[][] cursos=new String[datos.size()][3];
       for(int contador=0;contador<datos.size();contador++){
          for(int i=0;i<3;i++){
           cursos[contador][i]=conexionBD.consultarCursoPorSigla(datos.get(contador))[i];
        } 
       }
        
        
        return cursos;
    }
    
    public void eliminarMatriculaBD(String ced){
       conexionBD.eliminarMatricula(conexionBD.corroborarExistenciaDeMatriculaPorCedula(ced));
    }
    
    public boolean NuevaMatriculaBD(String cedula){
        return metodosEstudiantes.corroborarExistenciaEstudianteBD(cedula);
            
      }
    
    public boolean corroborarCedulaExistenteBD(String cedula){
        return metodosEstudiantes.corroborarExistenciaEstudianteBD(cedula);
        
    }
    
    ////////////////Fin Metodos BD//////////////////////////////////////
    public void guardarMatriculaArray(Matricula matricula){
        matriculas.add(matricula);
    }
    
    public void eliminarMatriculaArray(String cedula){
        for(int contador=0;contador<matriculas.size();contador++){
            if(matriculas.get(contador).getCedulaEstudiante().equalsIgnoreCase(cedula)){
               matriculas.remove(contador);
               break;
            }
        }
    }
    
    public String getCodigoMatricula(String cedula){
        String codigoEnviar="";
        for(int contador=0;contador<matriculas.size();contador++){
            if(matriculas.get(contador).getCedulaEstudiante().equalsIgnoreCase(cedula)){
                codigoEnviar=matriculas.get(contador).getCodigoMatricula();
            }
        }
        return codigoEnviar;
    }
    public String[][] getCursosMatriculadosArchivosPlanos(String ced){
        String[][] matrizCursos=new String[1][1];
        for(int contador=0;contador<matriculas.size();contador++){
            if(matriculas.get(contador).getCedulaEstudiante().equalsIgnoreCase(ced)){
                matrizCursos=new String[matriculas.get(contador).arrayCursos.size()][3];
                for(int contador2=0;contador2<matriculas.get(contador).arrayCursos.size();contador2++){
                           matrizCursos[contador2][0]=metodosCursos.consultarCursoArchivoPlano(matriculas.get(contador).arrayCursos.get(contador2))[0];
                           matrizCursos[contador2][1]=metodosCursos.consultarCursoArchivoPlano(matriculas.get(contador).arrayCursos.get(contador2))[1];
                           matrizCursos[contador2][2]=metodosCursos.consultarCursoArchivoPlano(matriculas.get(contador).arrayCursos.get(contador2))[2];
                           
                }
                break;
            }
        }
        return matrizCursos;
    }
    
    
    public ArrayList<String> getSiglasCursos(String cedula){
      ArrayList<String> siglasAEnviar=new ArrayList<String>();
        for(int contador=0;contador<matriculas.size();contador++){
            if(matriculas.get(contador).getCedulaEstudiante().equalsIgnoreCase(cedula)){
              siglasAEnviar= matriculas.get(contador).getSiglasCursos();
            }
        }
        return siglasAEnviar;
    }
    public String getCodigo(){
       return "CM."+(int)Math.floor(Math.random()*(1-150)+150);
    }
    
    
    ///////////////////////////////METODOS ARCHIVOS PLANOS///////////////////////
    
    public void guardarMatriculaArchivoPlano(Matricula matricula){
        matriculas.add(matricula);
       
    }
    
    public void actualizarArchivoPlano(){
        archivo.crearArchivoMatricula();
        for(int contador=0;contador<matriculas.size();contador++){
        archivo.ingresarInformacionAlArchivoMatricula(matriculas.get(contador));
        }
    }
    
    public boolean corroborarExistenciaMatriculaArchivosPlanos(String cedula){
        boolean existe=false;
        for(int contador=0;contador<matriculas.size();contador++){
            if(matriculas.get(contador).getCedulaEstudiante().equalsIgnoreCase(cedula)){
                existe=true;
            }
        }
        return existe;
        
    }
    
    public boolean corroborarCedulaExistenteArchivosPlanos(String cedula){
        return metodosEstudiantes.corroborarExistenciaEstudianteArchivosPlanos(cedula);
        
    }
    public void cargarMatriculasArchivosPlanos(){
        matriculas=archivo.devolverInformacionArchivoMatricula();
    }
    
    /////////////////////////////FIN METODOS ARCHIVOS PLANOS/////////////////////
    
    
    //////////////////////////METODOS XML////////////////////////////////
    
    public void matricularXML(Matricula matricula){
        String[] informacion=new String[2];
        informacion[0]=matricula.getCodigoMatricula();
        informacion[1]=matricula.getCedulaEstudiante();
        String[] cursos=new String[matricula.getSiglasCursos().size()];
        for(int i=0;i<matricula.getSiglasCursos().size();i++){
            cursos[i]=matricula.getSiglasCursos().get(i);
        }
        archivosMatriculaXML.guardarMatriculasEnXML(informacion, cursos);
        
    }
    
    public boolean corroborarExistenciaMatriculaXML(String ced){
        return archivosMatriculaXML.consultarInformacionMatriculasDelXml(ced);
    }
    
    public ArrayList<Cursos> siglasCurso(){
        return this.archivosCursosXML.obtenerSiglasCursos();
    }
    
    /////////////////////////FIN METODOS XML////////////////////////////
}//*************************************Fin de la clase************************//
