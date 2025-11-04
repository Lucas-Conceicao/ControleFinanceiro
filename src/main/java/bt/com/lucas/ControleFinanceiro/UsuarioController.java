package bt.com.lucas.ControleFinanceiro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/pagina1")
    public String pagina1() {
        return "pagina1";
    }

    @GetMapping("/pagina2")
    public String pagina2() {   
        return "pagina2";
    }

    @GetMapping("/pagina3")
    public String pagina3() {   
        return "pagina3";
    }   

    @GetMapping("/calc")
    public String calc(Model model) { 
        model.addAttribute("calc", new Calc(0, 0));  
        return "calc";
    }

    @PostMapping("/calc")
    public String calcular(@ModelAttribute("calc") Calc calc, Model model){   
        double res = calc.getNum1() + calc.getNum2();
        model.addAttribute("calc", calc);
        model.addAttribute("res", res);
        return "calc";
    }
}
