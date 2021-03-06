package com.phoneBook.service;

import java.util.List;

import com.phoneBook.model.Phonebook;

public interface PhonebookService {
	Phonebook savePhonebook(Phonebook phonebook);
	
	List<Phonebook> getAllPhonebook();
	
	Phonebook getPhonebookById(long id);
	
	Phonebook updatePhonebook(Phonebook phonebook, long id);
	
	void deletePhonebook(long id);
}
