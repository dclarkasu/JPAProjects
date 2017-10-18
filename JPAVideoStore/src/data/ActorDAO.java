package data;

import entities.Actor;
import entities.Film;

public interface ActorDAO {
	public Actor create(Actor actor);
	public Actor update(int id, Actor actor);
	public boolean destroy(int id);
	public Actor createActorAndFilm(Actor actor, Film film);
}
