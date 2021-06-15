package clases.ito.poo;

import java.io.Serializable;
import java.time.LocalDate;

import excepciones.clases.ito.poo.AgregarInterpretesException;
import excepciones.clases.ito.poo.DuracionException;
import excepciones.clases.ito.poo.ExcepcionAgregarInterpretes;
import excepciones.clases.ito.poo.ExcepcionQuitarInterpretes;
import excepciones.clases.ito.poo.GeneroException;
import excepciones.clases.ito.poo.InterpretesException;
import excepciones.clases.ito.poo.QuitarInterpretesException;
import excepciones.clases.ito.poo.TituloException;


public class Composicion implements Serializable, Comparable<Composicion> { 

	
	public String titulo = "";
	public float duracion = 0F;
	public String interpretes = "";
	public String genero = "";
	public LocalDate fechaderegistro = null;
	public LocalDate fechadeestreno = null;
	//private Object interprete;
	
	
	public Composicion() {
		// Start of user code constructor for Composicion)
		super();
		// End of user code
	}
	public Composicion(String titulo, float duracion, String interpretes, String genero, LocalDate fechaderegistro,
			LocalDate fechadeestreno) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.interpretes = interpretes;
		this.genero = genero;
		this.fechaderegistro = fechaderegistro;
		this.fechadeestreno = fechadeestreno;
	}
	
	public String interpretes(String musico) {
		// Start of user code for method interpretes
		String interpretes = "";
		return interpretes;
		// End of user code
	}
	public boolean agregarInterpretes(String Interpretes) throws ExcepcionAgregarInterpretes,AgregarInterpretesException{
		boolean agregar = false;
		if (Interpretes!= null&&!Interpretes.equalsIgnoreCase("")) {
			this.interpretes=Interpretes;
				agregar = true;
		}else
			throw new ExcepcionAgregarInterpretes("Error: la cantidad debe ser de $100 en $100 y maximo hasta $6000 de retiro");
			agregar=false;
		return agregar;
	}
	
	public boolean quitarInterpretes(String Interpretes) throws ExcepcionQuitarInterpretes,QuitarInterpretesException{
		boolean quitar= false;
		if (Interpretes.equalsIgnoreCase(this.interpretes)) {
			this.interpretes=null;
				quitar = true;
		}else
		throw new QuitarInterpretesException("La cantidad a depositar debe ser entre $500 y $25000");
			quitar=false;
		return quitar;
	}
	
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String newTitulo)  throws TituloException{
		this.titulo = newTitulo;
	}

	public float getDuracion() {
		return this.duracion;
	}

	public void setDuracion(float duracion) throws DuracionException {
	    this.duracion = duracion;
		
	}
	public String getInterpretes() {
		return this.interpretes;
	}

	public void setInterpretes(String Interpretes) throws InterpretesException {
		this.interpretes = Interpretes;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String Genero) throws GeneroException {
		this.genero = Genero;
	}

	public LocalDate getFechaderegistro() {
		return this.fechaderegistro;
	}

	public void setFechaderegistro(java.time.LocalDate newFechaderegistro) {
		this.fechaderegistro = newFechaderegistro;
	}

	public LocalDate getFechadeestreno() {
		return this.fechadeestreno;
	}

	public void setFechadeestreno(java.time.LocalDate newFechadeestreno) {
		this.fechadeestreno = newFechadeestreno;
	}
	
	
	@Override
	public String toString() {
		return "Composicion [titulo=" + titulo + ", duracion=" + duracion + ", interpretes=" + interpretes + ", genero="
				+ genero + ", fechaderegistro=" + fechaderegistro + ", fechadeestreno=" + fechadeestreno + "]";
	}
	public int compareTo(Composicion e) {
		int compare=0;
		if(this.titulo.equals(e.getTitulo()))
		compare=-1;
		else if(!this.titulo.equalsIgnoreCase(e.getTitulo()));
			compare=1;
		return compare;
	}
}
