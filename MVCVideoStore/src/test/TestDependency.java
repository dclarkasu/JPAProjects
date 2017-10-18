package test;

import data.ActorDAO;
import data.ActorDAOImpl;
import entities.Actor;

public class TestDependency {

	public static void main(String[] args) {
		ActorDAO dao = new ActorDAOImpl();
		
		Actor actor = new Actor();
		actor.setFirstName("Don");
		actor.setLastName("Julio");
		dao.create(actor);
		System.out.println(actor);

	}
}
