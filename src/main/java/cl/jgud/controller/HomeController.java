package cl.jgud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.jgud.model.Libro;
import cl.jgud.service.LibroService;
import cl.jgud.vo.LibroVO;

@Controller
public class HomeController {

	@Autowired
	LibroService libroService;
	
	@GetMapping({"/", "/home"})
	public String home(ModelMap modelMap) {
		
		LibroVO libroVO = libroService.getAllLibros();
		modelMap.addAttribute("libroVO", libroVO);
		return "index";
	}
	
	@PostMapping ("/addLibro")
	public ModelAndView addLibro(ModelMap modelMap, @ModelAttribute("libro") Libro libro) {
		
		LibroVO libroVO = libroService.add(libro);
		modelMap.addAttribute("librosVO", libroVO);
		return  new ModelAndView("redirect:/");
	}
	
	@GetMapping("/deleteLibro")
	public ModelAndView deleteLibro(ModelMap modelMap, @RequestParam String idLibro) {
		Libro libroAEliminar = new Libro();
		libroAEliminar.setIdLibro(Integer.parseInt(idLibro));
		libroService.delete(libroAEliminar);
		return new ModelAndView("redirect:/"); //redirige al home
	}
	
	
	@PostMapping("/findByTitleAuth")
	public String findByTitleAndAuthor(ModelMap modelMap, @RequestParam String titulo, String autor) {
		LibroVO libroVO = libroService.findByTitleAuth(titulo, autor);
		modelMap.addAttribute("libroVO", libroVO);
		return "index";
		
	}
	
	@GetMapping("/findById")
	public String findById(ModelMap modelMap, @RequestParam String idLibro) {
		LibroVO libroVO = libroService.findById(Integer.parseInt(idLibro));
		modelMap.addAttribute("libroVO", libroVO.getLibros().get(0));
		return "edit";
	}
	
	@PostMapping("/editLibro")
	public ModelAndView editLibro(ModelMap modelMap, @ModelAttribute("libro") Libro libro) {
		
		LibroVO libroVO = libroService.update(libro);
		modelMap.addAttribute("LibroVO", libroVO);
		return new ModelAndView("redirect:/");
	
	}
	
}
