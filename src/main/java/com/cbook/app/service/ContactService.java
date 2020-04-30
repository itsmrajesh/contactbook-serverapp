package com.cbook.app.service;

import java.util.List;

import com.cbook.app.domain.Contact;

public interface ContactService {
	
	Contact addContact(Contact contact);

	List<Contact> getAllContacts();

	Contact getContactByNumber(String number);

	Contact getContactByEmail(String email);

	List<Contact> searchContact(String name);

	int deleteAllContacts();
	
	Contact updateContact(Contact contact, String number);

}
