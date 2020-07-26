package sockets;

public class Sesion {
	
	final static String SEPARADOR_DATOS_SESION = "#";
	
	String fecha;
	String id;
	String tiempo;
	int nEjercicios;
	
	public Sesion(Sesion sesion) {
		fecha = sesion.getFecha();
		id = sesion.getId();
		tiempo = sesion.getTiempo();
		nEjercicios = sesion.getnEjercicios();
	}

	public Sesion(String fecha, String id, String tiempo) {
		this.fecha = fecha;
		this.id = id;
		this.tiempo = tiempo;
		//ejercicios = new ArrayList<>();
	}
	
	public String getFecha() {
		return fecha;
	}

	public String getId() {
		return id;
	}

	public String getTiempo() {
		return tiempo;
	}

	public int getnEjercicios() {
		return nEjercicios;
	}

	@Override
	public String toString() {
		return fecha + "#" + id + "#" + tiempo + "#" + nEjercicios;
	}
	
	
}
