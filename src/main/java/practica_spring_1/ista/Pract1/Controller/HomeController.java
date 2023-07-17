package practica_spring_1.ista.Pract1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "forward:/app/";
    }
//    public String home(){
////        return "redirect:/app/";
//        return "redirect:https://www.google.com";
//    }
}
