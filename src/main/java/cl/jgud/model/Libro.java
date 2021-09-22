package cl.jgud.model;

import org.springframework.stereotype.Component;

@Component("libro")
public class Libro {
	private Integer idLibro;
	private String titulo;
	private String autor;
	private Integer anio;
	private String editorial;
	private Integer copiasDisponibles;
	
	
	public Libro() {
		super();
	}


	public Libro(Integer idLibro, String titulo, String autor, Integer anio, String editorial,
			Integer copiasDisponibles) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.anio = anio;
		this.editorial = editorial;
		this.copiasDisponibles = copiasDisponibles;
	}


	public Integer getIdLibro() {
		return idLibro;
	}


	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public Integer getAnio() {
		return anio;
	}


	public void setAnio(Integer anio) {
		this.anio = anio;
	}


	public String getEditorial() {
		return editorial;
	}


	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}


	public Integer getCopiasDisponibles() {
		return copiasDisponibles;
	}


	public void setCopiasDisponibles(Integer copiasDisponibles) {
		this.copiasDisponibles = copiasDisponibles;
	}


	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", autor=" + autor + ", anio=" + anio
				+ ", editorial=" + editorial + ", copiasDisponibles=" + copiasDisponibles + "]";
	}
	
	
	
}




