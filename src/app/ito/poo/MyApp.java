package app.ito.poo;
import clases.ito.poo.Composicion;
import clases.ito.poo.Composiciones;
import excepciones.clases.ito.poo.AgregarInterpretesException;
import excepciones.clases.ito.poo.ComposicionException;
import excepciones.clases.ito.poo.EliminaException;
import excepciones.clases.ito.poo.ExcepcionAgregarInterpretes;

public class MyApp {

	public static void main(String[] args) throws ComposicionException, EliminaException, AgregarInterpretesException, ExcepcionAgregarInterpretes {
		Aplicacion.emm();
	}

}