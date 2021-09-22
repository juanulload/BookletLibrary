package cl.jgud.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.jgud.model.Libro;
import cl.jgud.model.LibroMapper;

@Repository
public class LibroDAOImpl implements LibroDAO {

	JdbcTemplate jdbcTemplate;
	DataSource dataSource;

	@Autowired
	public LibroDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public List<Libro> getAllLibros() {
		
		return jdbcTemplate.query("SELECT * FROM LIBRO", new LibroMapper());
	
	}

	@Override
	public Libro findByTitleAuth(String titulo, String autor) {
	
		return jdbcTemplate.queryForObject("SELECT * FROM LIBRO WHERE TITULO=? AND AUTOR=?", new LibroMapper(),
				new Object[] { titulo, autor });
	}

	@Override
	public int add(Libro libro) {
	
		return jdbcTemplate.update("INSERT INTO LIBRO VALUES (SQ_LIBROS.nextval, ?, ?, ?, ?, ?)", libro.getTitulo(),
				libro.getAutor(), libro.getAnio(), libro.getEditorial(), libro.getCopiasDisponibles());
	}
	
	

	@Override
	public int update(Libro libro) {
		
		return jdbcTemplate.update("UPDATE LIBRO SET TITULO=?, AUTOR=?, ANIO=?, EDITORIAL=?, COPIAS_DISPONIBLES=? WHERE ID=?", libro.getTitulo(),
				libro.getAutor(), libro.getAnio(), libro.getEditorial(), libro.getCopiasDisponibles(), libro.getIdLibro());
	}

	@Override
	public int delete(Libro libro) {
	
		return  jdbcTemplate.update("DELETE FROM LIBRO WHERE ID=?", libro.getIdLibro());
	
	}

	@Override
	public Libro findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM LIBRO WHERE ID=?", new LibroMapper(), new Object[] {id});
	}
	
	
}
