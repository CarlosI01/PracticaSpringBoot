package practica_spring_1.ista.Pract1.ControllerRutas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemplosVariablesRutasController {
    @GetMapping("/")
    public String Index(Model model){
        model.addAttribute("titulo", "Enviar URL");
        return "variables/index";
    }

    @GetMapping("/string/{texto}")
    public String Variables (@PathVariable String texto, Model model){
        model.addAttribute("titulo", "Recibir parametro de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado de la ruta es: "+ texto);
        return "variables/ver";

    }

    @GetMapping("/string/{texto}/{numero}")
    public String Variables (@PathVariable String texto, @PathVariable Integer numero, Model model){
        model.addAttribute("titulo", "Recibir parametro de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado de la ruta es: "+ texto+
                " Y el numero enviado es: "+numero);
        return "variables/ver";

    }
}
