package com.phoneBook.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phoneBook.model.Phonebook;
import com.phoneBook.service.PhonebookService;

@RestController
@RequestMapping("/api/Phonebook")
public class PhoneBookController {
	
	private PhonebookService phonebookService;

	public PhoneBookController(PhonebookService phonebookService) {
		super();
		this.phonebookService = phonebookService;
	}
	
	// build create employee REST API
	@PostMapping()
	public ResponseEntity<Phonebook> saveEmployee(@RequestBody Phonebook phonebook){
		return new ResponseEntity<Phonebook>(phonebookService.savePhonebook(phonebook), HttpStatus.CREATED);
	}
	
	// build get all employees REST API
	@GetMapping
	public List<Phonebook> getAllPhonebook(){
		return phonebookService.getAllPhonebook();
	}
	
	// build get employee by id REST API
	// http://localhost:8080/api/employees/1
	@GetMapping("{id}")
	public ResponseEntity<Phonebook> getPhonebookById(@PathVariable("id") long phonebookId){
		return new ResponseEntity<Phonebook>(phonebookService.getPhonebookById(phonebookId), HttpStatus.OK);
	}
	
	// build update employee REST API
	// http://localhost:8080/api/employees/1
	@PutMapping("{id}")
	public ResponseEntity<Phonebook> updateEmployee(@PathVariable("id") long id
												  ,@RequestBody Phonebook phonebook){
		return new ResponseEntity<Phonebook>(phonebookService.updatePhonebook(phonebook, id), HttpStatus.OK);
	}
	
	// build delete employee REST API
	// http://localhost:8080/api/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		
		// delete employee from DB
		phonebookService.deletePhonebook(id);
		
		return new ResponseEntity<String>("Phone Book record  deleted successfully!.", HttpStatus.OK);
	}
	
}