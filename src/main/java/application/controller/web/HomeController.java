package application.controller.web;

import application.data.service.CategoryService;
import application.data.service.ProductService;
import application.model.viewModel.common.ProductVM;
import application.model.viewModel.home.HomeLandingVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @GetMapping(value = "")
    public String home(Model model,
                       @Valid @ModelAttribute("productname")ProductVM productName,
                       @RequestParam(name = "categoryId", required = false) Integer categoryId,
                       @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                       @RequestParam(name = "size", required = false, defaultValue = "12") Integer size,
                       @RequestParam(name = "sortByPrice", required = false) String sort,
                       HttpServletResponse response,
                       HttpServletRequest request,
                       final Principal principal){

        /**
         * check cookie to create cart guid
         */

        this.checkCookie(response,request,principal);


        HomeLandingVM vm = new HomeLandingVM();

        return "home";
    }

    private void checkCookie(HttpServletResponse response, HttpServletRequest request, Principal principal) {
    }

}
