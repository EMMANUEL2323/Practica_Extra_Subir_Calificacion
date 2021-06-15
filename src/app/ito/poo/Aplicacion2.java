package app.ito.poo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import clases.ito.poo.*;
import excepciones.clases.ito.poo.*;

public class Aplicacion2 {

	static EscritorArchivoTXT informacion;//n
	static LectorArchivoTXT informacion2;//n
	static RandomAccessFile informacion3;
	static ArrayList<Composicion> composicion= new ArrayList<Composicion>();//n
	static Composicion cp;
	static Composiciones c;
	static Scanner lector= new Scanner (System.in);
	
	 static Composicion capturaComposicion(){
		    Composicion cp= new Composicion();
		   
		    try {
		    System.out.print("Ingresa la duracion de la cancion:");
		    cp.setDuracion(lector.nextFloat());lector.nextLine();
		    }catch(DuracionException f){
		    System.err.println(f.getMessage());
		    }
		    try {
			System.out.print("Ingresa el titulo de la cancion:");
			cp.setTitulo(lector.toString());lector.nextLine();
			}catch(TituloException f){
			System.err.println(f.getMessage());
			}
		    try {
			System.out.print("Proporciona los interpretes:");
			cp.setInterpretes(lector.nextLine());
		    }catch(InterpretesException f){
			    System.err.println(f.getMessage());
		    }
		    try {
				System.out.print("Proporciona el genero musical:");
				cp.setGenero(lector.nextLine());
			    }catch(GeneroException f){
				    System.err.println(f.getMessage());
			    }
			System.out.print("Proporciona la fecha de registro: aaaa-mm-dd");
			String fecha=lector.nextLine();
			cp.setFechaderegistro(LocalDate.parse(fecha));
			System.out.print("Proporciona la fecha de estreno: aaaa-mm-dd");
			String fecha1=lector.nextLine();
			cp.setFechadeestreno(LocalDate.parse(fecha1));
			return cp;
		}
	 
	 static void agregarComposicion() throws ComposicionException{
		 Composicion cancion;
		 cancion=capturaComposicion();
		 if(c.addItem(cancion))
			 System.out.println("Se agrego la composicion con exito !!");
	     else
		    throw new ComposicionException("Error: La composicion no se agrego debido a que hay otra que contiene los mismos datos");
	}

	  static Composicion alazar(String alazar) throws ExcepcionAgregarInterpretes, AgregarInterpretesException{
		  Composicion con=null; int i=0;
		    for (;i <c.getSize();i++) {
		      con = c.getItem(i);
		      System.out.println(c.getItem(i)+" Es la composicion a "+alazar);
		      String respuesta=lector.nextLine();
		      if(respuesta.equalsIgnoreCase("Si"))
		    	 break;
		      con=null;
		    }
			return con;
		
	 }
	  
	  static void agregarInterpretes() throws ExcepcionAgregarInterpretes, AgregarInterpretesException{
		  if(!c.isFree()) {
		  Composicion count=alazar("Registrando");
		  if(count!=null) { 
			  try {
			  System.out.println("Ingresa los nombres de los nuevos interpretes");
			  count.agregarInterpretes(lector.toString());
			  }catch(AgregarInterpretesException e){
			      System.err.println(e.getMessage());
			  }
		 }else 
			System.out.println("Error");
	}else	  
		System.out.println("No existen composiciones");
	} 
	
	   static void eliminaInterpretes() throws EliminaException, ExcepcionQuitarInterpretes, ExcepcionAgregarInterpretes, AgregarInterpretesException {
	   if(!c.isFree()) {
			  Composicion cmp=alazar("Eliminando");
			  if(cmp!=null) { 
				  try {
				  System.out.println("Ingresa los nombres de los interpretes para iliminarlos");
				  cmp.quitarInterpretes(lector.toString());
				  }catch(QuitarInterpretesException e){
				      System.err.println(e.getMessage());
				  }
			  }else 
				System.out.println("Error");
		}else	  
			System.out.println("No existen composiciones");
		} 
	   
	   static void elimina() throws EliminaException, ExcepcionAgregarInterpretes, AgregarInterpretesException{
		   if(!c.isFree()) {
				  Composicion cion=alazar("Eliminando composicion");
				  if(cion.getInterpretes().equalsIgnoreCase(null)|| cion.getInterpretes().equalsIgnoreCase("")) {
				  if(cion!=null) { 
					  c.delete(cion);
					  System.out.println("Se ha eliminado con exito");
				  }	else 
					  System.out.println("Error");
				  }else
					  throw new EliminaException("Solo se pueden eliminar composiciones sin interpretes");
			}else	  
				  System.out.println("No existe ninguna composicion");
	}
	    static void listado(){
			if(!c.isFree()) {
				System.out.println("Imprimiendo composiciones...");
				for(int i=0;i<c.getSize();i++)
					System.out.println(c.getItem(i));
			}	
			else
				System.out.println("No existen composiciones ");
	   }
	 
	  static void inicializa() {
		c=new Composiciones();
	}
	  
	  static void grabaregistro() throws FileNotFoundException {
		  if(!c.isFree()) {
			  informacion = new EscritorArchivoTXT("Composiciones.txt");
			  for(int i=0;i<c.getSize();i++) {
				  informacion.writeString(c.getItem(i).getTitulo());
				  informacion.writeFloat(c.getItem(i).getDuracion());
				  System.out.println("Nombre de la composicion"+c.getItem(i).getTitulo());
				  informacion.writeString(c.getItem(i).getInterpretes());
				  informacion.writeString(c.getItem(i).getGenero());
				  informacion.writeString(c.getItem(i).getFechaderegistro().toString());
				  if(c.getItem(i).getFechadeestreno()==null)
					  informacion.writeStringLn("Sin fecha de estreno");
				  else
				  informacion.writeStringLn(c.getItem(i).getFechadeestreno().toString());
			  }
			  informacion.close();
		  }
	  }
	  
	  static void grabaregistroDat() throws IOException {
		  if(!c.isFree()) {
			  informacion3 = new RandomAccessFile("Composiciones.dat","rw");
			  for(int i=0;i<c.getSize();i++) {
				  informacion3.writeUTF(c.getItem(i).getTitulo());
				  informacion3.writeFloat(c.getItem(i).getDuracion());
				  System.out.println("Nombre de la composicion"+c.getItem(i).getTitulo());
				  informacion3.writeUTF(c.getItem(i).getInterpretes());
				  informacion3.writeUTF(c.getItem(i).getFechaderegistro().toString());
				  if(c.getItem(i).getFechadeestreno()==null)
					  informacion3.writeUTF("Sin fecha de estreno \n");
				  else
				  informacion3.writeUTF(c.getItem(i).getFechadeestreno().toString()+"\n");
			  }
			}
	  }
	  
	  static void abrirArchivo() throws FileNotFoundException{
			informacion2= new LectorArchivoTXT("Composiciones.txt");
		}
	  
	  static void menuoperac() throws ComposicionException, EliminaException, AgregarInterpretesException, ExcepcionAgregarInterpretes, ExcepcionQuitarInterpretes, IOException{
		  inicializa();
		  int opcio;
		   boolean bandera=true;
		  while(true) {	  
			  System.out.println(" 1.-Agregar composicion "); 
			  System.out.println(" 2.-Lista de las composiciones ");  
			  System.out.println(" 3.-Agregar interpretes ");  
			  System.out.println(" 4.-Retirar o quitar interpretes");  
			  System.out.println(" 5.-Eliminar composicion ");    
			  System.out.println(" 6.-salir");
			  opcio=lector.nextInt();
			  switch(opcio){
			  	case 1:agregarComposicion();break;
			  	case 2:listado();break;
			  	case 3:agregarInterpretes();break;
			    case 4:eliminaInterpretes();break;
			  	case 5:elimina();break;
				case 6:grabaregistro();grabaregistroDat();bandera=false;break;
			  }
	      }
	   }
	  
	  static void run() throws ComposicionException, EliminaException, AgregarInterpretesException, ExcepcionAgregarInterpretes, ExcepcionQuitarInterpretes, IOException {
		  menuoperac();
	  }
}
