package cl.jgud.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.jgud.dao.LibroDAO;
import cl.jgud.model.Libro;
import cl.jgud.vo.LibroVO;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	LibroDAO dao;

	LibroVO respuestaVO;

	@Override
	public LibroVO getAllLibros() {

		respuestaVO = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "101");
		try {
			respuestaVO.setLibros(new ArrayList<>(dao.getAllLibros()));
			respuestaVO.setMensaje(String.format("Se han encontrado %d libro", respuestaVO.getLibros().size()));

		} catch (Exception e) {
			System.err.print(e);
		}
		return respuestaVO;
	}

	@Override
	public LibroVO findByTitleAuth(String titulo, String autor) {

		respuestaVO = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "102");

		try {
			Libro libro = dao.findByTitleAuth(titulo, autor);
			respuestaVO.getLibros().add(libro);
			respuestaVO.setMensaje(String.format("Se ha encontrado %d libros", null != libro ? 1 : 0)); // OPERADOR
			respuestaVO.setCodigo("0");																						// TERNARIO
		} catch (Exception e) {
			System.err.print(e);
		}

		return respuestaVO;
	}

	@Override
	public LibroVO add(Libro libro) {

		respuestaVO = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "103");

		try {
			int registrosActualizados = dao.add(libro);
			respuestaVO.setMensaje(registrosActualizados == 1 ? "Se ha creado el libro correctamente"
					: "No se ha podido crear el usuario");
			respuestaVO.setCodigo("0");
		} catch (Exception e) {
			System.err.print(e);
		}

		return respuestaVO;
	}

	@Override
	public LibroVO update(Libro libro) {
		respuestaVO = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "104");

		try {
			int registrosActualizados = dao.update(libro);
			respuestaVO.setMensaje(String.format("Se han actualizado correctamente %d libros", registrosActualizados));
			respuestaVO.setCodigo("0");
		} catch (Exception e) {
			System.err.print(e);
		}

		return respuestaVO;
	}

	@Override
	public LibroVO delete(Libro libro) {
		respuestaVO = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "105");

		try {
			int registrosActualizados = dao.delete(libro);
			respuestaVO.setMensaje(String.format("Se ha eliminado correctamente %d libros", registrosActualizados));
			respuestaVO.setCodigo("0");
		} catch (Exception e) {
			System.err.print(e);
		}

		return respuestaVO;
	}

	@Override
	public LibroVO findById(int idLibro) {
		respuestaVO = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "106");

		try {
			Libro libro = dao.findById(idLibro);
			respuestaVO.getLibros().add(libro);
			respuestaVO.setMensaje(String.format("Se han encontrado %d libros", null != libro ? 1 : 0));
			respuestaVO.setCodigo("0");
		} catch (Exception e) {
			System.err.print(e);
		}

		return respuestaVO;
	}
	
	
}















