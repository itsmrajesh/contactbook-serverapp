package com.cbook.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbook.app.domain.Contact;
import com.cbook.app.service.ContactService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("api/capp/")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@PostMapping("/add")
	public Contact addContact(@RequestBody Contact contact) {
		return contactService.addContact(contact);
	}

	@GetMapping("/viewall")
	public List<Contact> getAllContacts() {
		return contactService.getAllContacts();
	}

	@GetMapping("/search/{name}")
	@ApiOperation(value = "Finds contacts with given name", notes = "Provide name to get contacts with similar name from DB", response = Contact.class)
	public List<Contact> search(@PathVariable String name) {
		return contactService.searchContact(name);
	}

	@GetMapping("/searchbynumber/{number}")
	public Contact searchByNumber(
			@ApiParam(value = "provide number to search number", required = true) @PathVariable String number) {
		return contactService.getContactByNumber(number);
	}

	@DeleteMapping("/clearall")
	public int deleteAllContacts() {
		return contactService.deleteAllContacts();
	}

	@PutMapping("/update/{number}")
	public Contact updateContact(@RequestBody Contact contact, @PathVariable String number) {
		return contactService.updateContact(contact, number);
	}

}
