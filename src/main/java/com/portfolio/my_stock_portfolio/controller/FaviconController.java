package com.portfolio.my_stock_portfolio.controller; // Adjust the package based on your structure

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class FaviconController {

    @GetMapping("/favicon.ico")
    public void returnNoFavicon() {
        // Empty method to handle the favicon request and return nothing
    }
}
