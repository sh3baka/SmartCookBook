package lv.shebaka.smartcookbook.servlets.mvc;

import lv.shebaka.smartcookbook.domain.User;
import lv.shebaka.smartcookbook.logic.Error;
import lv.shebaka.smartcookbook.logic.addrecipe.AddRecipeService;
import lv.shebaka.smartcookbook.logic.adduser.AddUserService;
import lv.shebaka.smartcookbook.logic.adduser.AddUserServiceImpl;
import lv.shebaka.smartcookbook.logic.loginuser.UserLoginRequest;
import lv.shebaka.smartcookbook.logic.loginuser.UserLoginResponse;
import lv.shebaka.smartcookbook.logic.loginuser.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@SessionAttributes("userModel")
public class LoginController {

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public String processGet(HttpServletRequest request) {

        return "welcomescreen";
    }

    @RequestMapping(value = "/validate" ,method = RequestMethod.POST)
    public ModelAndView processPost(HttpServletRequest request) {

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String userName = request.getParameter("login");
        String userPassword = request.getParameter("password");

        UserLoginResponse response = userLoginService.logIn(new UserLoginRequest(userName, userPassword));

        if (response.isSuccess()) {
            User user = response.getUser();
            return new ModelAndView("login","userModel", user);
        } else {

            List<Error> list = response.getErrors();
            return new ModelAndView("errorpage", "errorModel", list);
        }


//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("userObject", );
//        modelAndView.addObject("welcome");
//
//        return modelAndView;

    }
}
