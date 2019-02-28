
package com.resume.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.resume.model.Education;
import com.resume.model.Person;
import com.resume.repository.EducationRepository;
import com.resume.repository.PersonRepository;

@Controller
public class EducationController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EducationRepository educationRepo;

	@Autowired
	PersonRepository personRepo;

	@GetMapping("/addEducation")
	public String educationForm(@ModelAttribute("person") @Valid Person person, Model model) {
		log.info("User gets in Get add educatin ");
		model.addAttribute("personId", person.getPersonId());
		model.addAttribute("education", new Education());
		model.addAttribute("person", person);

		//personRepo.findByPersonId(person.getPersonId());
		log.info("User out of  add educatin get method ");
		return "educationForm";
	}

	@RequestMapping(path = "/addEducation", method = RequestMethod.POST)
	public String saveEdu(@ModelAttribute("person") @Valid Education edu,Person person, BindingResult bindingResult,
			Long personId, Model model, RedirectAttributes redirectAttributes) {
		log.info("User gets in add education post method " , "e");
		Person pers = personRepo.findByPersonId(personId);
		edu.setPerson(pers);
		edu.setPersonId(personId);
		if (bindingResult.hasErrors()) {
			model.addAttribute("personId", personId);
			return "educationForm";
		}

		log.info("User gets in Post add educatin ");
		

		/*List<Education> eduList = new ArrayList<Education>();

		edu.setPersonId(personId);
		eduList.add(edu);
		model.addAttribute("eduList", eduList);
		model.addAttribute("personId", personId);*/

		educationRepo.save(edu);
		redirectAttributes.addFlashAttribute("person", pers);
		return "redirect:/showAllEducation";
	}

	@GetMapping("/addAnotherEducation/{personId}")
	public String addEducation(@PathVariable Long personId, Model model) {
		
		log.info("add another eduactjion method start");

		model.addAttribute("personId", personId);
		model.addAttribute("education", new Education());

		return "educationForm";

	}

	@RequestMapping("/showAllEducation")
	public String showEducation(Model model, Person pers) {
		model.addAttribute("educations", educationRepo.findAll());
		return "showEducation";

	}
	
	

	/*
	 * @RequestMapping("/showEducation/{educationId}") public String
	 * showOne(@PathVariable("educationId") long eduId, Model model) {
	 * model.addAttribute("education", educationRepo.findOne(educationId)); return
	 * "showEducation"; }
	 */
}
