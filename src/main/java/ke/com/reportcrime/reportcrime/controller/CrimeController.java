package ke.com.reportcrime.reportcrime.controller;



import ke.com.reportcrime.reportcrime.service.CrimeService;
import ke.com.reportcrime.reportcrime.service.IncidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CrimeController {
@Autowired
private CrimeService crimeService;
@Autowired
private IncidenceService incidenceService;

    @RequestMapping("/")
    public String home(Model model)
    {
        model.addAttribute("crime", crimeService.allCrimes());
        model.addAttribute("incidence",incidenceService.getAllincidence());
        return "index";
    }

}
