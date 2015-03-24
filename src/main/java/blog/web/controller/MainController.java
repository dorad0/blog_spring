package blog.web.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by user on 17.01.2015.
 */
@Controller
public class MainController {


    @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public ModelAndView defaultPage() {
        ModelAndView model = new ModelAndView();
//        model.addObject("title", "Spring Security + Hibernate Example");
//        model.addObject("message", "This is default page!");
        model.setViewName("redirect:/article/");
        return model;
    }

//    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
//    public ModelAndView adminPage() {
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "Spring Security + Hibernate Example");
//        model.addObject("message", "This page is for ROLE_ADMIN only!");
//        model.setViewName("admin");
//        return model;
//    }

//    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
//    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
//                              @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {
//
//        ModelAndView model = new ModelAndView();
//        if (error != null) {
//            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
//        }
//        System.out.println("LOGIN!!!!!!!!!!");
//        if (logout != null) {
//            model.addObject("logout", "You've been logged out successfully.");
//            HttpSession session = request.getSession(false);
//            if(session != null) {
//                session.invalidate();
//                System.out.println("exit");
//            }
//        }
//        model.setViewName("login");
//
//        return model;
//
//    }

    @Secured(value = "ROLE_ANONYMOUS")
    @RequestMapping(value = {"/login", "/login/","login"}, method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout,
                              HttpServletRequest request, HttpSession session) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }

        if (logout != null) {
            model.addObject("logout", "You've been logged out successfully.");
//            if(session != null) {
////                session.invalidate();
////                System.out.println("exit");
//            }
        }
        model.setViewName("login");
        return model;
    }

//    @RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})
//    public String login(HttpSession session, Model model) {
//            model.addAttribute("logout", "You've been logged out successfully.");
////            HttpSession session = request.getSession(false);
//            if(session != null) {
//                session.invalidate();
//                System.out.println("exit");
//            }
//        return "login";
//    }

    // customize the error message
    private String getErrorMessage(HttpServletRequest request, String key) {

        Exception exception = (Exception) request.getSession().getAttribute(key);

        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }

        return error;
    }

    // for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        // check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);

            model.addObject("username", userDetail.getUsername());

        }

        model.setViewName("403");
        return model;

    }
}
