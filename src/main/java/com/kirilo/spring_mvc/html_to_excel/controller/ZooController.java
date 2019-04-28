package com.kirilo.spring_mvc.html_to_excel.controller;

import com.kirilo.spring_mvc.html_to_excel.service.AnimalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ZooController {
    protected AnimalService animalService = new AnimalService();

    @RequestMapping(value = "/AnimalList", method = RequestMethod.GET)
    public String getAnimals(Model model) {
        List animalList = animalService.getAnimalList();
        model.addAttribute("animalList", animalList);
        return "AnimalList";
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public ModelAndView getExcel() {
        List animalList = animalService.getAnimalList();
        return new ModelAndView("AnimalListExcel", "animalList", animalList);
    }

    @RequestMapping("/")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi(@RequestParam("name") String name, Model model) {
        String message = "Hi " + name + "!";
        model.addAttribute("message", message);
        return "hi";
    }
}
