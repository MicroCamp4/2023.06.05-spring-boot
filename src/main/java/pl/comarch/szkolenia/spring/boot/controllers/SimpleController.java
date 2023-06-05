package pl.comarch.szkolenia.spring.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.comarch.szkolenia.spring.boot.model.view.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
//@RequestMapping(path = "/user")
public class SimpleController {

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    //@GetMapping(path = "/test")
    //@PostMapping(path = "/test")
    public String test() {
        System.out.println("cos dziala !!!");
        return "index";
    }

    @RequestMapping(path = "/test2", method = RequestMethod.GET)
    public String test2() {
        System.out.println("test2");
        return "test";
    }

    @RequestMapping(path = "/test3", method = RequestMethod.GET)
    public String test3(@RequestParam("name") String n,
                        @RequestParam String surname,
                        @RequestParam int age) {
        System.out.println(n);
        System.out.println(surname);
        System.out.println(age);
        return "test";
    }

    @RequestMapping(path = "/test4/{n}/{surname}/{age}", method = RequestMethod.GET)
    public String test4(@PathVariable("n") String name,
                        @PathVariable String surname,
                        @PathVariable int age) {
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);
        return "test";
    }

    @RequestMapping(path = "/form", method = RequestMethod.GET)
    public String form() {
        return "form";
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String form(@RequestParam String name,
                       @RequestParam String surname,
                       @RequestParam int age) {
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);
        return "test";
    }

    @RequestMapping(path = "/imiona", method = RequestMethod.GET)
    public String imiona(Model model) {
        String name = "Karol";
        model.addAttribute("name", name);
        List<String> names = new ArrayList<>();
        names.add("Janusz");
        names.add("Zbyszek");
        names.add("Wiesiek");
        names.add("Bogdan");
        names.add("Przemek");
        model.addAttribute("imiona", names);
        model.addAttribute("random",
                names.get(new Random().nextInt(5)));
        return "names";
    }

    @RequestMapping(path = "/form2", method = RequestMethod.GET)
    public String form2(Model model) {
        User user = new User();
        model.addAttribute("object", user);
        System.out.println(user);
        return "form2";
    }

    @RequestMapping(path = "/form2", method = RequestMethod.POST)
    public String form2(@ModelAttribute User user) {
        System.out.println(user);
        return "test";
    }
}
