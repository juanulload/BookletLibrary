package cl.jgud.service;

import cl.jgud.model.Libro;
import cl.jgud.vo.LibroVO;
 
public interface LibroService {
	
	public LibroVO getAllLibros();
	public LibroVO findByTitleAuth(String titulo, String autor);
	public LibroVO add(Libro libro);
	public LibroVO update(Libro libro);
	public LibroVO delete(Libro libro);
	public LibroVO findById(int idLibro);
}
