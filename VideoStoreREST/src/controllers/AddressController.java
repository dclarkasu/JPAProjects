package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.AddressDAO;
import entities.Address;

@RestController
public class AddressController {
	
	@Autowired
	private AddressDAO dao;
	
	@RequestMapping(path="ping", method=RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path="addresses", method=RequestMethod.GET)
	public List<Address> index() {
		return dao.getAll();
	}
	
	@RequestMapping(path="addresses/{id}", method=RequestMethod.GET)
	public Address show(@PathVariable int id) {
		return dao.getById(id);
	}
	
	@RequestMapping(path="addresses", method=RequestMethod.POST)
	public Address create(@RequestBody String addressJSON) {
		return dao.create(addressJSON);
	}

}
