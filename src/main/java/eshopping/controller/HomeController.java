package eshopping.controller;

import eshopping.domain.Category;
import eshopping.domain.Product;
import eshopping.service.ICategoryService;
import eshopping.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/")
    public String home(Model model){
        List<Product> products = productService.getRecentProducts();
        List<Category> categories = categoryService.getCategoryList();
        model.addAttribute("products", products);
        //model.addAttribute("categories", categories);
        return "home";
    }

    @RequestMapping("/ad")
    public String adminhome(){
        return "adminhome";
    }

    @RequestMapping("/login")
    public String login(
            @RequestParam(value="error", required = false)
                    String error,
            @RequestParam(value="logout", required = false)
                    String logout,
            Model model){

        if(error != null){
            model.addAttribute("error", "Invalid username and password");
        }

        if (logout !=null){
            model.addAttribute("msg", "You have been logged out successfully");
        }

        return "login";
    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }
}
