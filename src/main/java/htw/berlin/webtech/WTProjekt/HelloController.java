package htw.berlin.webtech.WTProjekt;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "Hello World!";
    }
}

/**
 @RestController
 public class HelloController {

 @GetMapping("/")
 public String index() {
 return "Hello World!";
 }
 }
 **/