package barakat;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
//
//    @Autowired
//    UserDetailsService userDetailsService;

    @GetMapping({"/", "/about"})
    public ModelAndView index(Model model) {
        //SecurityContextHolder.getContext().getAuthentication().getName();
//        model.addAttribute("eventName", SecurityContextHolder.getContext().getAuthentication().getName());
        return new ModelAndView("public/index.html");
    }
}