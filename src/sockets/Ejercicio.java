package sockets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ejercicio {
	
	final String SEPARADOR = "$";
	
	final int ID = 0;
	final int NOMBRE_EJERCICIO = 1;
	final int DESCRIPCION = 2;
	final int DIRECTORIO_GIF = 3;
	
	String id;
	String nombre;
	String descripcion;
	String directorioGIF;
	String resultado;
	String fecha;
	String tiempo;
	int repeticiones;
	boolean seleccionado;
	
	
	public Ejercicio(String id, String nombre, String descripcion, String directorioGIF){
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.directorioGIF = directorioGIF;
		this.resultado = "";
		this.fecha = fechaDelSistema();
		this.repeticiones = 5; 
		this.seleccionado = false;
	}
	
	public Ejercicio(String id, String resultado, String fecha, int repeticiones, boolean seleccionado, String tiempo){
		this.id = id;
		this.resultado = resultado;
		this.fecha = fecha;
		this.repeticiones = repeticiones; 
		this.seleccionado = seleccionado;
		this.cargarNombreDescripcionYGIF(id);
		this.tiempo = tiempo;
	}

	private void cargarNombreDescripcionYGIF(String id) {
		BufferedReader in = null;
		
		String nombreFichero = GestorFicheros.NOMBRE_FICH_EJERCICIOS;
		String separador = GestorFicheros.SEPARADOR_DOLAR;
		String lineaLeida;
		String[] valoresEjercicio;
		
		try{
			in = new BufferedReader(new FileReader(nombreFichero));
			
			while((lineaLeida = in.readLine()) != null){
				valoresEjercicio = lineaLeida.split(separador);
				
				if(valoresEjercicio[ID].equals(id)){
					this.nombre = valoresEjercicio[NOMBRE_EJERCICIO];
					this.descripcion = valoresEjercicio[DESCRIPCION];
					this.directorioGIF = valoresEjercicio[DIRECTORIO_GIF];
					break;
				}				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {}
			}
		}
				
	}

	private String fechaDelSistema() {
		String fecha;
		Calendar calendario = new GregorianCalendar();
        
        int a�o = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
       
        fecha = dia+"/"+(mes+1)+"/"+a�o;
        
		return fecha;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getDirectorioGIF() {
		return directorioGIF;
	}
	public void changeSelection() {
		this.seleccionado = !this.seleccionado;
	}
	
	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	
	public boolean isSeleccionado() {
		return seleccionado;
	}
	
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public Object getFieldAt(int columna) {
		switch (columna){
		case 0: return id;
		case 1: return nombre;
		case 2: return fecha;
		case 3: return new Integer(repeticiones);
		case 4: return resultado;
		default: return null;
		}
	}
	
	public String guardar(){
		String linea;
		
		linea  = id+SEPARADOR+resultado+SEPARADOR+fecha+SEPARADOR+
				 repeticiones+SEPARADOR+seleccionado+SEPARADOR+tiempo;
		
		return linea;
	}
}


