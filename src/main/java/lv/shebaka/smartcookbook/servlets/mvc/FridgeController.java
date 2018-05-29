package lv.shebaka.smartcookbook.servlets.mvc;


import lv.shebaka.smartcookbook.data.FridgeRepository;
import lv.shebaka.smartcookbook.data.ProductRepository;
import lv.shebaka.smartcookbook.domain.Product;
import lv.shebaka.smartcookbook.domain.User;
import lv.shebaka.smartcookbook.logic.addUserFridgeItems.AddToFridgeRequest;
import lv.shebaka.smartcookbook.logic.addUserFridgeItems.AddToFridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FridgeController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private FridgeRepository fridgeRepository;
    @Autowired
    private AddToFridgeService addToFridgeService;

    @RequestMapping(value = "/fridge", method = RequestMethod.GET)
    public ModelAndView getFridge(HttpServletRequest request){

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        List<Product> productList = productRepository.getAllProducts();

        return new  ModelAndView("fridge", "fridgeModel" , productList);
    }

    @RequestMapping(value = "/getfridge", method = RequestMethod.POST)
    public ModelAndView showFridgeItem(@SessionAttribute("userModel") User user, HttpServletRequest request){

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//get Combo box values as String
        String[] numbers = request.getParameterValues("products");
//make String values as Product list
        List<Product> products = new ArrayList<>();
        for(String value : numbers){
            Product product = productRepository.getProductsByName(value).get();
            products.add(product);
        }

        fridgeRepository.clearUserFridge(user);

        for (Product product : products) {
            addToFridgeService.addToFridge(new AddToFridgeRequest(user, product));
        }






        return new ModelAndView("recipes", "testModel", products);


    }

}
