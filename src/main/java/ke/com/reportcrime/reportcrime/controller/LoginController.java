package ke.com.reportcrime.reportcrime.controller;

import ke.com.reportcrime.reportcrime.model.Crime;
import ke.com.reportcrime.reportcrime.model.Incidence;
import ke.com.reportcrime.reportcrime.repository.CrimeRepository;
import ke.com.reportcrime.reportcrime.repository.IncidenceRepository;
import org.slf4j.LoggerFactory;
import ke.com.reportcrime.reportcrime.model.User;
import ke.com.reportcrime.reportcrime.repository.UserRepository;
import ke.com.reportcrime.reportcrime.service.UserDetailsService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;




@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserDetailsService userService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    private CrimeRepository crimeRepository;
    @Autowired
    private IncidenceRepository incidenceRepository;

   /** @RequestMapping(value={"","/home"}, method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
**/
    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }



    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    /**
     *
     * @param user
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("login");

        }
        return modelAndView;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getFirstname() + " " + user.getLastname() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }


    /**
     *
     * @return
     */


    @RequestMapping(value="/reportcrime", method = RequestMethod.GET)
    public ModelAndView saveCrime(){
        ModelAndView modelAndView = new ModelAndView();
        Crime crime = new Crime();
        modelAndView.addObject("crime", crime);
        modelAndView.setViewName("reportcrime");
        return modelAndView;
    }

    /**
     *
     * @param crime
     * @return
     */

    @RequestMapping(value = "/reportcrime", method = RequestMethod.POST)
    public ModelAndView createNewCrime(@Valid Crime crime) {
       ModelAndView modelAndView= new ModelAndView();
            crimeRepository.save(crime);
            modelAndView.addObject("successMessage", "Report succefully made!");
            modelAndView.addObject("crime", new Crime());
            modelAndView.setViewName("/userhome");

        return modelAndView;
    }


    /**
     *
     * @return
     */
    @RequestMapping(value="/reportincidence", method = RequestMethod.GET)
    public ModelAndView saveIncidence(){
        ModelAndView modelAndView = new ModelAndView();
        Incidence incidence= new Incidence();
        modelAndView.addObject("incidence", incidence);
        modelAndView.setViewName("reportincidence");
        return modelAndView;
    }

    /**
     *
     * @param incidence
     * @return
     */
    @RequestMapping(value = "/reportincidence", method = RequestMethod.POST)
    public ModelAndView createNewIncidence(@Valid Incidence incidence) {
        ModelAndView modelAndView= new ModelAndView();
        incidenceRepository.save(incidence);
        modelAndView.addObject("successMessage", "Incidence Report succefully made!");
        modelAndView.addObject("incidence", new Incidence());
        modelAndView.setViewName("/userhome");

        return modelAndView;
    }











}
