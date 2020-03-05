package com.tts.Portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.Portfolio.model.Contact;
import com.tts.Portfolio.repository.ContactRepository;

@Controller
public class MainController {

	@Autowired
	ContactRepository contactRepository;
	
	@GetMapping(value = "/contact")
	public String contact(Contact contact) {
		return "contact";
	}
	
	@GetMapping(value="/resume") 
	public String resume() {
		return "resume";
	}
	
	@GetMapping(value = "/result")
	public String result() {
		return "result";
	}
	
	@PostMapping(value = "/contact")
	public String submit(Contact contact, Model model) {
		contactRepository.save(contact);
		model.addAttribute("name", contact.getName());
		model.addAttribute("email", contact.getEmail());
		model.addAttribute("message", contact.getMessage());
		return "result";
	}
}
