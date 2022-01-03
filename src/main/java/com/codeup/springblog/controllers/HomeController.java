package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String welcomePage(){
        return "This is the landing page!";
    }

    @GetMapping("/home")
    public String welcome(){
        return "home";
    }

    @GetMapping("/profile/{username}")
    public String profile(@PathVariable String username, Model model){
        model.addAttribute("viewUsername", username);
        return "profile";
    }

    @GetMapping("/rolldice")
    public String diceRoll(){
        return "roll";
    }

    @PostMapping("/rolldice")
    public String guessRoll(@RequestParam(name = "n") String n, Model model){

        var minNumber = 0; // The minimum number you want
        var maxNumber = 6; // The maximum number you want
        int random = (int) Math.floor(Math.random() * (maxNumber + 1) + minNumber);
        boolean message = false;

        model.addAttribute("n", "Your number was: " + n);
        model.addAttribute("random", "The random number is: " + random);

        if (n.equals(Integer.toString(random))) {
            message = true;
        }
        model.addAttribute("message", "Your guess was: " + message);
        return "roll";
    }
}
