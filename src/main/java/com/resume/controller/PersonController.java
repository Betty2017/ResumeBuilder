package com.resume.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.resume.model.Education;
import com.resume.model.Person;
import com.resume.model.Photo;
import com.resume.service.IPersonService;

@Controller
public class PersonController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IPersonService personService;

	@GetMapping("/index")
	public String PersonForm(Model model) {
		model.addAttribute("person", new Person());
		return "personForm";
	}

	/*
	 * @RequestMapping(value = "/addEducation") public String saveEducation(Model
	 * model, Person person) { model.addAttribute("education", new Education());
	 * return "educationForm"; }
	 */

	@RequestMapping(value = "/display")
	public String showAll() {
		return "redirect:/showAll";
	}

	/*
	 * @RequestMapping(value="/savePer", method = RequestMethod.POST) public
	 * ModelAndView savePerson(@RequestParam("imageFile") MultipartFile
	 * imageFile,Person person ) { ModelAndView modelAndView = new ModelAndView();
	 * 
	 * try { personService.savePerson(person);
	 * 
	 * } catch (Exception e) { log.error("unable to save specimen" , e);
	 * e.printStackTrace(); modelAndView.setViewName("error"); return modelAndView;
	 * }
	 * 
	 * Photo photo = new Photo(); photo.setFile(imageFile.getOriginalFilename());
	 * photo.setPath("/photo/"); photo.setPerson(person);
	 * modelAndView.setViewName("success");
	 * 
	 * 
	 * try { personService.saveImage(imageFile, photo); } catch (Exception e) { //
	 * TODO Auto-generated catch block e.printStackTrace();
	 * log.error("Unable to ",e); modelAndView.setViewName("error"); }
	 * modelAndView.addObject("photo", photo); modelAndView.addObject("person",
	 * person); return modelAndView;
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	@RequestMapping(value = "/savePerson", method = RequestMethod.POST)
	public String savePer(@RequestParam("imageFile") MultipartFile imageFile, @ModelAttribute("person") Person person,
			RedirectAttributes redirectAttributes) {

		try {
			personService.savePerson(person);

		} catch (Exception e) {
			log.error("unable to save specimen", e);
			e.printStackTrace();
			return "error";
		}
		String returnValue = "success";
		Photo photo = new Photo();
		photo.setFile(imageFile.getOriginalFilename());
		photo.setPath("/photo/");
		photo.setPerson(person);

		try {
			personService.saveImage(imageFile, photo);
			redirectAttributes.addFlashAttribute("person", person);
		} catch (Exception e) {
			// TODO Auto-generated catch block e.printStackTrace();
			log.error("Unable to ", e);
			returnValue = "error";
		}
		return "redirect:/addEducation";

	}

	/*
	 * @PostMapping("/uploadImage") public String
	 * uploadImage(@RequestParam("imageFile") MultipartFile imageFile) { String
	 * returnValue = "personForm"; Photo photo = new Photo();
	 * photo.setFile(imageFile.getOriginalFilename()); photo.setPath("/photo/"); try
	 * { personService.saveImage(imageFile, photo); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); log.error("Unable to ",e);
	 * returnValue = "error"; } return returnValue;
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(value = "/addEducation", method = RequestMethod.POST) public
	 * String saveEducation(Person person, Education education) {
	 * 
	 * try { personService.savePerson(person);
	 * 
	 * } catch (Exception e) { log.error("unable to save specimen", e);
	 * e.printStackTrace(); return "error"; } String returnValue = "success";
	 * 
	 * Photo photo = new Photo(); photo.setFile(imageFile.getOriginalFilename());
	 * photo.setPath("/photo/"); photo.setPerson(person);
	 * 
	 * try { personService.saveImage(imageFile, photo); } catch (Exception e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); log.error("Unable to ",
	 * e); returnValue = "error"; }
	 * 
	 * return "redirect:/addEducation";
	 * 
	 * 
	 * }
	 */

	@RequestMapping(value = "/displayAll")
	public ModelAndView displayAll() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			Iterable<Person> allPersons = personService.fetchAll();
			modelAndView.setViewName("showAll");
			modelAndView.addObject("allPersons", allPersons);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Unable to retrive", e);
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/search")
	public String search() {
		return ("search");
	}

	@RequestMapping(value = "/searchPerson")
	public String searchPersons(
			@RequestParam(value = "searchTerm", required = false, defaultValue = "") String searchTerm) {
		String sTerm = searchTerm + "";
		List<Person> fetchPersons = personService.fetchPersons(searchTerm);
		return "personForm";
	}

	@RequestMapping(value = "/searchPersonAll")
	public String searchPerson(@RequestParam Map<String, String> requestParams) {
		int param = requestParams.size();
		requestParams.get("searchTerm");
		return "personForm";
	}

	/*
	 * @PostMapping("/addPerson") public String
	 * savePersonForm(@ModelAttribute("person") @Valid Person person, Model model,
	 * RedirectAttributes redirectAttributes, BindingResult result) { if
	 * (result.hasErrors()) { return "personForm"; } personRepo.save(person);
	 * 
	 * Person tempPerson = personRepo.findByPersonId(person.getPersonId());
	 * 
	 * // Long personId=tempPerson.getPersonId();
	 * 
	 * model.addAttribute("personId", tempPerson.getPersonId());
	 * model.addAttribute("person", person);
	 * System.out.println(tempPerson.getPersonId());
	 * redirectAttributes.addFlashAttribute("person", person);
	 * 
	 * return "redirect:/addEducation"; }
	 */

	/*
	 * @RequestMapping("/showAll") public String showAll(Model model) {
	 * model.addAttribute("persons", personRepo.findAll()); return "showAll"; }
	 * 
	 * @RequestMapping("/showOne/{personId}") public String
	 * showOne(@PathVariable("personId") long personId, Model model) {
	 * model.addAttribute("person", personRepo.findOne(personId)); return "showOne";
	 * }
	 * 
	 * @RequestMapping("/deleteOne/{personId}") public String
	 * deleteOne(@PathVariable("personId") long personId) {
	 * personRepo.delete(personId); return "redirect:/showAll"; }
	 */

}
