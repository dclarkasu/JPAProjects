package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import data.FilmDAO;
import entities.Film;

public class FilmController {
	@Autowired
	private FilmDAO dao;
	
	@RequestMapping(path = "GetFilm.do", method = RequestMethod.GET)
	  public String show(@RequestParam("id") Integer id, Model model) {
	    Film film = dao.show(id);
	    model.addAttribute("film", film);
	    return "film.jsp";
	  }
	
//	@RequestMapping()

}
