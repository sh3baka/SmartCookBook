package lv.shebaka.smartcookbook.servlets.mvc;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
//@Component
public class WelcomeScreenController implements MVCController {

    @Override
    public MVCModel processGet(HttpServletRequest request) {
        return new MVCModel("/welcomescreen.jsp", "");
    }

    @Override
    public MVCModel processPost(HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }
}
