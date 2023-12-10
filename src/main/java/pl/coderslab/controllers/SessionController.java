package pl.coderslab.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@SessionAttributes("loginStart")
public class SessionController {

    @GetMapping("/loginStart")
    @ResponseBody
    public String loginStart(Model model, HttpSession session) {
        LocalDateTime loginStartDate = (LocalDateTime) session.getAttribute("loginStart");
        if (loginStartDate == null) {
            model.addAttribute("loginStart", LocalDateTime.now());
            return "Ustawiono wartość";
        }
        return loginStartDate.format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
