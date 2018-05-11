package lv.shebaka.smartcookbook.servlets.mvc;

import lv.shebaka.smartcookbook.logic.addrecipe.AddRecipeService;
import lv.shebaka.smartcookbook.logic.adduser.AddUserService;
import lv.shebaka.smartcookbook.logic.adduser.AddUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class HelloWorldController implements MVCController {

    @Autowired
    private AddUserService addUserService;

    @Override
    public MVCModel processGet(HttpServletRequest request) {
        String userName = request.getParameter("name");
        String userPassword = request.getParameter("password");
        String userRepeatPassword = request.getParameter("UserRepeatPassword");

        addUserService.addUser(userName,userPassword,userRepeatPassword);
        return new MVCModel("/helloworld.jsp", "Hello MVC");
    }

    @Override
    public MVCModel processPost(HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }
}
