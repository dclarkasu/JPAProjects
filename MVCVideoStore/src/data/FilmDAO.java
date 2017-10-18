package data;

import java.util.List;

import entities.Film;

public interface FilmDAO {
	public Film show(int id);

	public List<Film> index();

	public Film update(int id, Film film);

	public boolean destroy(int id);

	public Film create(Film film);
}
