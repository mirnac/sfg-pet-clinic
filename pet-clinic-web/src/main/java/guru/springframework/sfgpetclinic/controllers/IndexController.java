package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping({"/", "", "index", "index.html"})
    public String index(Model model) {
        model.addAttribute("hello", "HOLA MUNDO!");
        return "index";
    }

    @RequestMapping("/oups")
    public String oups(){
        return "notImplemented";
    }
}
