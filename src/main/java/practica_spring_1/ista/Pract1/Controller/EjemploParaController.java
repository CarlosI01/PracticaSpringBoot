package practica_spring_1.ista.Pract1.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParaController {
    @GetMapping("/")
    public String index (){
        return "params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(name="texto", required = false, defaultValue = "Algun valor") String texto, Model model){
        model.addAttribute("resultado", "El parametro que envie es " + texto);
        return "params/ver";
    }

    @GetMapping("/mix-params")
    public String mix_param(@RequestParam(name="nombre") String nombre, @RequestParam(name="edad") Integer edad,  Model model){
        model.addAttribute("resultado" , "El nombre de esta persona es: "+ nombre + " Edad " + edad);
        return "params/ver";
    }

    @GetMapping("/mix-params-request")
    public String mix_param(HttpServletRequest request, Model model){
        String nombre= request.getParameter("nombre");
        Integer edad=null;
        try {
             edad= Integer.parseInt(request.getParameter("edad"));
        }catch (NumberFormatException e){
            edad=0;
        }
        model.addAttribute("resultado" , "El nombre de esta persona es: "+ nombre + " Edad " + edad);
        return "params/ver";
    }
}
