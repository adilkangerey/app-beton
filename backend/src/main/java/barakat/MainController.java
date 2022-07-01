package barakat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class MainController {
    @GetMapping({"/hello", "/about"})
    public String index(Model model) {
        model.addAttribute("eventName", "FIFA 2018");
        return "public/index";
    }
}