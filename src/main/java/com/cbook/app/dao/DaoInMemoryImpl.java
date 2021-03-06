package com.cbook.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cbook.app.domain.Contact;

@Component
public class DaoInMemoryImpl implements Dao {

	private List<Contact> contacts = new ArrayList<>();

	@Override
	public Contact addContact(Contact contact) {
		contacts.add(contact);
		return contact;
	}

	@Override
	public List<Contact> getAllContacts() {
		return contacts;
	}

	@Override
	public Contact getContactByNumber(String number) {
		for (Contact contact : contacts) {
			if (contact.getNumber().equalsIgnoreCase(number)) {
				return contact;
			}
		}
		return null;
	}

	@Override
	public Contact getContactByEmail(String email) {
		for (Contact contact : contacts) {
			if (contact.getEmail().equalsIgnoreCase(email)) {
				return contact;
			}
		}
		return null;
	}

	@Override
	public List<Contact> searchContact(String name) {
		List<Contact> searchList = new ArrayList<>();
		for (Contact contact : contacts) {
			if (contact.getName().equalsIgnoreCase(name)) {
				searchList.add(contact);
			}
		}
		return searchList;
	}

	@Override
	public int deleteAllContacts() {
		int size = contacts.size();
		contacts.clear();
		return size;
	}

	@Override
	public Contact updateContact(Contact contact, String number) {
		Contact contactObj = getContactByNumber(number);
		if (contactObj != null) {
			if (contact.getEmail() != null)
				contactObj.setEmail(contact.getEmail());
			if (contact.getName() != null)
				contactObj.setName(contact.getName());
			if (contact.getNumber() != null)
				contactObj.setNumber(contact.getNumber());
		}
		return contactObj;
	}

}
