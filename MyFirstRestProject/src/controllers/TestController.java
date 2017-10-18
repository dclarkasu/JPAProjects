package controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(path="ping", method=RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	//@PathVariable is useful for embedding information into the url.
	//Specifically, id's
	@RequestMapping(path="hello/{name}")
	public String hello(@PathVariable String name) {
		return "Hello " + name;
	}
}
