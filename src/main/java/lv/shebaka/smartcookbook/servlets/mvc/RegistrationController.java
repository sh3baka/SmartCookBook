package lv.shebaka.smartcookbook.servlets.mvc;

import lv.shebaka.smartcookbook.logic.userregistration.UserRegistrationRequest;
import lv.shebaka.smartcookbook.logic.userregistration.UserRegistrationResponse;
import lv.shebaka.smartcookbook.logic.userregistration.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class RegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @RequestMapping(value = "/registration" , method = RequestMethod.GET)
    public ModelAndView processGet(HttpServletRequest request) {
        return new ModelAndView("registration");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView processPost(HttpServletRequest request) {

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String userName = request.getParameter("login");
        String userPassword = request.getParameter("password");

        UserRegistrationResponse response = userRegistrationService.register(new UserRegistrationRequest(userName, userPassword));

        if (response.isSuccess()) {

            return new ModelAndView("welcomescreen", "model", response.getUserId());

        }

        return new ModelAndView("welcomescreen", "model", response.getErrors());


    }
}
