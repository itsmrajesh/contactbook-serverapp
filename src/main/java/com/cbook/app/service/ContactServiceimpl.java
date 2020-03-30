package com.cbook.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbook.app.dao.Dao;
import com.cbook.app.domain.Contact;

@Service
public class ContactServiceimpl implements ContactService {

	@Autowired
	private Dao dao;

	@Override
	public Contact addContact(Contact contact) {
		if (contact != null)
			return dao.addContact(contact);
		return null;
	}

	@Override
	public List<Contact> getAllContacts() {
		return dao.getAllContacts();
	}

	@Override
	public Contact getContactByNumber(String number) {
		if (number.length() > 9) {
			return dao.getContactByNumber(number);
		}
		return null;
	}

	@Override
	public Contact getContactByEmail(String email) {
		if (email.contains("@")) {
			return dao.getContactByEmail(email);
		}
		return null;
	}

	@Override
	public List<Contact> searchContact(String name) {
		if (name != null && name.length() > 1) {
			return dao.searchContact(name);
		}
		return null;
	}

	@Override
	public int clearContacts() {
		return dao.clearContacts();
	}

}
