package eu.babywatcher.got.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.babywatcher.got.aop.LogExecution;
import eu.babywatcher.got.dto.House;
import eu.babywatcher.got.dto.Person;
import eu.babywatcher.got.service.HouseService;
import eu.babywatcher.got.service.PersonService;
import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping(path = "/houses", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HouseController {

	@Autowired
	private HouseService houseService;

	@Autowired
	private PersonService personService;

	@LogExecution
	@GetMapping
	public List<House> getAll() {
		return houseService.listAll();
	}
	
	@LogExecution
	@GetMapping(path = "/{id}")
	public House getOne(@PathVariable("id") Long id) {
		return  houseService.findById(id);
	}

	@LogExecution
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public House postNew(@RequestBody(required = true) House house) {
		return houseService.addNew(house);
	}

	@LogExecution
	@GetMapping(path = "/{id}/members")
	public List<Person> getHouseMembers(@PathVariable("id") Long houseId) {
		return personService.listByHouseId(houseId);
	}

}