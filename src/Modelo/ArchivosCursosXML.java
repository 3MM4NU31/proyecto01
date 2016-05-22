/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
/**
 *
 * @author Emmanuel
 */
public class ArchivosCursosXML {
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    DOMImplementation implementation;
    Document document;
    ArrayList titulos;
    ArrayList valores;
    Element raiz,principal;
    String arregloInformacion[];
    Source source;
    Result result;
    Result console;
    Transformer transformer;
    
    public ArchivosCursosXML(){
    arregloInformacion=new String[3];
    if(cargarCursosXML())
        {
          System.out.println("Ya existe un archivo XML Es creado, ya fue cargado y puede proceder a utilizarlo");
        }
        else
        {
            crearCursosXML();
            System.out.println("No existía un archivo XML Es creado, ya fue creado y puede proceder a utilizarlo");
        }
    
  }//////FIN CONTRUCTOR
    
    public void crearCursosXML() //Método nuevo en pruebas
    {
        factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);
            document.setXmlVersion("1.0");
            source = new DOMSource(document);
            result = new StreamResult(new java.io.File("cursos.xml"));
 
            console = new StreamResult(System.out);
 
            transformer = TransformerFactory.newInstance().newTransformer();
 
            transformer.transform(source, result);
            transformer.transform(source, console);
 
        } catch (Exception e) {
            System.err.println("Error al crear el archivo XML: " + e);
        }
    }
    public boolean cargarCursosXML() //Método nuevo en pruebas
    {
        boolean cargo=false;
        try {
        
            File fXmlFile = new File("cursos.xml");
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            document = builder.parse(fXmlFile);
            document.getDocumentElement().normalize();
            cargo=true;
            
            NodeList nList = document.getElementsByTagName("cursos");
            Node nNode = nList.item(0);
            raiz = (Element) nNode;
                
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo XML"+e);
        }
        return cargo;
    } 
    public void guardarCursosEnXML(String arregloInformacion[])//Método nuevo en pruebas
    {
        try{
            
            raiz = document.createElement("cursos");
            principal = document.createElement("cursos");
            document.getDocumentElement().appendChild(raiz);
            
            Element valor1 = document.createElement("sigla");
            Text text = document.createTextNode(arregloInformacion[0]);
            Element valor2 = document.createElement("nombre");
            Text text2 = document.createTextNode(arregloInformacion[1]);
            Element valor3 = document.createElement("creditos");
            Text text3 = document.createTextNode(arregloInformacion[2]);
            
            raiz.appendChild(valor1);
            valor1.appendChild(text);
            raiz.appendChild(valor2);
            valor2.appendChild(text2);
            raiz.appendChild(valor3);
            valor3.appendChild(text3);
            
            source = new DOMSource(document);
            result = new StreamResult(new java.io.File("cursos.xml"));
            console = new StreamResult(System.out);
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            transformer.transform(source, console);
            
            }
        catch (Exception e) 
        {
            System.err.println("Error al guardar: " + e);
        }
    }
    
    public boolean consultarInformacionCursosDelXml(String sigla)
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("cursos");
         Node tag=null,datoContenido=null;

         boolean itemEncontrado=false,tituloCedula=false;
         int contador=0;

         for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
         {   
             Node item = listaDeItems.item(contadorItems);
             NodeList datosItem = item.getChildNodes();
             for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
             {           
                 tag = datosItem.item(contadorTags); 
                 datoContenido = tag.getFirstChild();

                 if(tag.getNodeName().equals("sigla") && datoContenido.getNodeValue().equals(""+sigla) )
                 {
                    itemEncontrado=true;     
                 }
                 if(itemEncontrado && contador<3)
                 {
                    arregloInformacion[contador]=datoContenido.getNodeValue();
                    contador++;
                 }
             }

         }
         return itemEncontrado;
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacion;
    }
    public void modificarInformacionCursosDelXml(String informacion[])
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("cursos");
         Node tag=null,datoContenido=null;
         String arregloInformacion[]=new String[3];
         boolean itemEncontrado=false,tituloCedula=false;
         int contador=0;
         try
         {
            for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
            {   
                Node item = listaDeItems.item(contadorItems);
                NodeList datosItem = item.getChildNodes();
                for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
                {   
                    tag = datosItem.item(contadorTags); 
                    datoContenido = tag.getFirstChild();
                    if(tag.getNodeName().equals("sigla") && datoContenido.getNodeValue().equals(""+informacion[0]) )
                    {   
                       itemEncontrado=true;     
                    }
                    if(itemEncontrado && contador<3)
                    {
                        datoContenido.setNodeValue(informacion[contador]);                    
                        contador++;
                    }
                }
            }
           source = new DOMSource(document);
           result = new StreamResult(new java.io.File("cursos.xml"));
           console = new StreamResult(System.out);
           transformer = TransformerFactory.newInstance().newTransformer();
           transformer.transform(source, result);
           transformer.transform(source, console);
        }
        catch (Exception e) 
        {
            System.err.println("Error al modificar: " + e);
        }
    }
    public void eliminarInformacionCursosDelXml(String sigla)
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("cursos");
         Node tag=null,datoContenido=null;
         String arregloInformacion[]=new String[3];
         boolean itemEncontrado=false,tituloCedula=false;

         try{
            for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
            {   
                Node item = listaDeItems.item(contadorItems);
                NodeList datosItem = item.getChildNodes();
                for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
                {
                    tag = datosItem.item(contadorTags); 
                    datoContenido = tag.getFirstChild();
                    if(tag.getNodeName().equals("sigla") && datoContenido.getNodeValue().equals(""+sigla) )
                    {
                       itemEncontrado=true;
                       raiz.removeChild(item);
                       source = new DOMSource(document);
                       result = new StreamResult(new java.io.File("cursos.xml"));
                       console = new StreamResult(System.out);
                       transformer = TransformerFactory.newInstance().newTransformer();
                       transformer.transform(source, result);
                       transformer.transform(source, console);
                    } 
                }
            }
         }
        catch (Exception e) 
        {
            System.err.println("Error al eliminar: " + e);
        }
    }
    
    
   public  ArrayList<Cursos> obtenerSiglasCursos(){ 
       ArrayList<Cursos> auxCur=new ArrayList<Cursos>();
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("cursos");
         Node tag=null,datoContenido=null;

         boolean itemEncontrado=false,tituloCedula=false;
         int contador=0;

         for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
         {   
             Node item = listaDeItems.item(contadorItems);
             NodeList datosItem = item.getChildNodes();
             for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
             {           
                 tag = datosItem.item(contadorTags); 
                 datoContenido = tag.getFirstChild();
                 
                 
                 
                    arregloInformacion[contadorTags]=datoContenido.getNodeValue();
                 if(arregloInformacion[2]!=null){
                     Cursos curso=new Cursos(arregloInformacion[0],arregloInformacion[1],arregloInformacion[2]);
                     auxCur.add(curso);
                     arregloInformacion[2]=null;
                     contador=0;
                 }
             }

         }
         return auxCur;
   }
   
   
   public String[] consultarInformacionCursosDelXmlPorNombre(String nombre)
    { 
        String[] datos=new String[3];
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("cursos");
         Node tag=null,datoContenido=null;

         boolean itemEncontrado=false,tituloCedula=false;
         int contador=0;

         for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
         {   
             Node item = listaDeItems.item(contadorItems);
             NodeList datosItem = item.getChildNodes();
             for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
             {           
                 tag = datosItem.item(contadorTags); 
                 datoContenido = tag.getFirstChild();
                 if(tag.getNodeName().equals("nombre") && datoContenido.getNodeValue().equals(""+nombre) )
                 {
                     tag = datosItem.item(contadorTags-1);
                     datoContenido = tag.getFirstChild();
                    datos[0]=datoContenido.getNodeValue();
                    
                    tag = datosItem.item(contadorTags);
                     datoContenido = tag.getFirstChild();
                    datos[1]=datoContenido.getNodeValue();
                    
                    tag = datosItem.item(contadorTags+1);
                     datoContenido = tag.getFirstChild();
                    datos[2]=datoContenido.getNodeValue();  
                     
                     
                 }
             }

         }
         return datos;
    }
   
}///////////////////////////////FIN DE LA CLASE//////////////////////////////////
