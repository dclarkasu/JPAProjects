package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.FilmDAO;
import entities.Film;

@RestController
public class FilmController {
	
	@Autowired
	private FilmDAO dao;
	
	@RequestMapping(path="films", method=RequestMethod.GET)
	public List<Film> index() {
		return dao.findAll();
	}
}
