/*
 * package com.resume.controller;
 * 
 * import java.util.ArrayList;
 * 
 * import javax.validation.Valid;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.validation.BindingResult; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod;
 * 
 * import com.resume.model.Experiance; import
 * com.resume.repository.ExperiancRepository;
 * 
 * @Controller public class ExperianceController {
 * 
 * 
 * @Autowired ExperiancRepository expRepo;
 * 
 * 
 * 
 * @RequestMapping(value ="/addExperiance" , method = RequestMethod.GET) public
 * String addExperiance(@Valid Experiance experiance, Model model) {
 * 
 * model.addAttribute("experiance" , experiance); return "experianceForm"; }
 * 
 * @RequestMapping(value ="/addExperiance" , method = RequestMethod.POST) public
 * String saveExperiance(@Valid Experiance experiance, BindingResult
 * bindingResult,Long personId, Model model) {
 * 
 * if(bindingResult.hasErrors()){ model.addAttribute("personId", personId);
 * return "experianceForm"; }
 * 
 * ArrayList<Experiance> experianceList = new ArrayList<Experiance>();
 * experianceList.add(experiance); model.addAttribute("experianceList",
 * experianceList); model.addAttribute("personId", personId);
 * 
 * //expRepo.save(experiance);
 * 
 * System.out.println(personId); return "redirect:/showEducation"; }
 * 
 * }
 */