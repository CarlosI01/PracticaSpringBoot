package practica_spring_1.ista.Pract1.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import practica_spring_1.ista.Pract1.Model.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/app")
public class IndexController {
@Value("${texto.indexcontroller.index.titulo}")
    private String textIndex;
    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textPerfil;
    @Value("${texto.indexcontroller.listar.titulo}")
    private String textListar;


    //@RequestMapping(value = "/index", method = RequestMethod.GET)
    //@GetMapping(value = "index")

    @GetMapping({"/index","/", "/home"})
    public String Index(Model model){
        model.addAttribute("titulo",textIndex);
        return "index";
    }

   // Otra forma de hacer
    /*@GetMapping({"/index", "/" , "/home"})
    public String index(ModelMap model){
        model.addAttribute("titulo", "Hola Carlos como estas");
        return "index";
    }*/
    //Otra forma de hacer
    /*@GetMapping({"/index", "/", "/home"})
    public String Index(Map<String, Object> map){
        map.put("titulo", "Hola como estas Carlos Ibarra");
        return "index";
    }*/
    //Otra forma de hacer
    /*@GetMapping({"/index", "/", "/home"})
    public ModelAndView Index(ModelAndView mv){
        mv.addObject("titulo", "Hola como estas Carlos Ibarra");
        mv.setViewName("index");
        return mv;
    }*/
    @RequestMapping(value="/perfil", method = RequestMethod.GET)
            public String Perfil(Model model){
            Usuario user= new Usuario();
            user.setNombre("Carlos");
            user.setApellido("Ibarra");
            user.setGmail("carlosibarra2019");
            model.addAttribute("user",user);
            model.addAttribute("titulo", textPerfil + user.getNombre());
            return "perfil";
    }
    @GetMapping("/lista")
    public String Listar(Model model){
//        List<Usuario> usuarioList= new ArrayList<>();
//        usuarioList.add(new Usuario("Carlos", "Ibarra","carlosgamil.com"));
//        usuarioList.add(new Usuario("Juan", "Matinez","carlosgamil.com"));
//        usuarioList.add(new Usuario("Pedro", "Merira","carlosgamil.com"));
//        model.addAttribute("usuario", usuarioList );
        model.addAttribute("titulo", textListar );

        return "lista";
    }

    @ModelAttribute("usuario")
    public List<Usuario> ListaUsuarios(){
        List<Usuario> usuarioList= Arrays.asList(new Usuario("Carlos", "Ibarra","carlosgamil.com"),
                new Usuario("Juan", "Matinez","carlosgamil.com"), new Usuario("Pedro", "Merira","carlosgamil.com"));
        return usuarioList;
    }
}
