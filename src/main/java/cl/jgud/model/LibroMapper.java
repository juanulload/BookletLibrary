package cl.jgud.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LibroMapper implements RowMapper<Libro> {

	@Override
	public Libro mapRow(ResultSet rs, int i) throws SQLException {

		Libro libro = new Libro();
		libro.setIdLibro(rs.getInt("ID"));
		libro.setTitulo(rs.getString("TITULO"));
		libro.setAnio(rs.getInt("ANIO"));
		libro.setAutor(rs.getString("AUTOR"));
		libro.setEditorial(rs.getString("EDITORIAL"));
		libro.setCopiasDisponibles(rs.getInt("COPIAS_DISPONIBLES"));

		return libro;
	}

}
