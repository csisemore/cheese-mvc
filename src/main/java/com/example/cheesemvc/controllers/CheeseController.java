package com.example.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
@RequestMapping("cheese")
public class CheeseController {

    static ArrayList<String> cheeses = new ArrayList<>();
    // Request path: cheese/
    @RequestMapping(value = "")

    public String index(Model model) {
        //moved above so it will wok in other methods
        //ArrayList<String> cheeses = new ArrayList<>();
        //Creating a list but not passing anything in.
        //cheeses.add("cheddar");
        //cheeses.add("parmesean");
        //cheeses.add("munster");
        // end test


        //not passing in list
        //model.addAttribute("cheeses",cheeses);
        //end test
        model.addAttribute("cheeses",cheeses);
        model.addAttribute("title","My Cheeses");
        return "cheese/index";

    }

    // Request path: cheese/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    //@RequestMapping(value = "add")
    public String displayAddCheeseForm(Model model) {

        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }
    // Request path: cheese/add
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName) {

        cheeses.add(cheeseName);

        // Redirect to cheese/
        return "redirect:";
    }


}
