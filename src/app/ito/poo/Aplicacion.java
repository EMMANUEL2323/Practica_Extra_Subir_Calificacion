package app.ito.poo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Scanner;
import clases.ito.poo.Composicion;
import clases.ito.poo.Composiciones;
import excepciones.clases.ito.poo.AgregarInterpretesException;
import excepciones.clases.ito.poo.ComposicionException;
import excepciones.clases.ito.poo.DuracionException;
import excepciones.clases.ito.poo.EliminaException;
import excepciones.clases.ito.poo.ExcepcionAgregarInterpretes;
import excepciones.clases.ito.poo.ExcepcionQuitarInterpretes;
import excepciones.clases.ito.poo.GeneroException;
import excepciones.clases.ito.poo.TituloException;
import excepciones.clases.ito.poo.InterpretesException;
import excepciones.clases.ito.poo.QuitarInterpretesException;



public class Aplicacion {
	static Composiciones c;
	static Scanner lector= new Scanner (System.in);

	 static Composicion capturaComposicion(){
	    Composicion cp= new Composicion();
	   
	    try {
	    System.out.print("Ingresa la duracion de la cancion:");
	    cp.setDuracion(lector.nextFloat());lector.nextLine();
	    }catch(DuracionException f){
	    System.err.println(f.getMessage());
	    }try {
		System.out.print("Ingresa el titulo de la cancion:");
		cp.setTitulo(lector.toString());lector.nextLine();
		}catch(TituloException f){
		System.err.println(f.getMessage());
		}try {
		System.out.print("Proporciona los interpretes:");
		cp.setInterpretes(lector.nextLine());
	    }catch(InterpretesException f){
		System.err.println(f.getMessage());
	    }try {
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
		/* }else 
			System.out.println("Error");*/
	}else	  
		System.out.println("No existen composiciones");}
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
			/*  }else 
				System.out.println("Error");*/
		}else	  
			System.out.println("No existen composiciones");}
		} 
	  
	    static void elimina() throws EliminaException, ExcepcionAgregarInterpretes, AgregarInterpretesException{
		   if(!c.isFree()) {
				  Composicion cion=alazar("Eliminando composicion");
				  if(cion.getInterpretes().equalsIgnoreCase(null)|| cion.getInterpretes().equalsIgnoreCase("")) {
				  if(cion!=null) { 
					  c.delete(cion);
					  System.out.println("Se ha eliminado con exito");
				/*  }	else 
					  System.out.println("Error");*/
				  }else
					  throw new EliminaException("Solo se pueden eliminar composiciones sin interpretes");
			}else	  
				  System.out.println("No existe ninguna composicion");}
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

	   static void menuoperac() throws ComposicionException, EliminaException, AgregarInterpretesException, ExcepcionAgregarInterpretes, ExcepcionQuitarInterpretes{
		  int opcio;
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
		     }
			  if(opcio==6) break;
	      }
	   }
	         
	   static void emm() throws ComposicionException, EliminaException, AgregarInterpretesException, ExcepcionAgregarInterpretes{{
		inicializa();
	  }
	   

}}
