package de.stockexchange.stocks.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
    @GetMapping(path = "/")
    public ModelAndView showHelloWorld(){ //package aus Spring --> gibt hier erstmal nur View zurück
        return new ModelAndView("helloworld");//return viewname --> name der Klasse
    }
}
