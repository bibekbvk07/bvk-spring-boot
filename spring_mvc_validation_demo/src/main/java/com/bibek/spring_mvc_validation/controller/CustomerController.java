package com.bibek.spring_mvc_validation.controller;

import com.bibek.spring_mvc_validation.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    /*
@InitBinder will pre-process all web requests coming into our Controller
StringTrimmerEditor is a class defined in Spring API, it basically removes whitespace-leading and trailing
 */
    // add an init binder...to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true); // value true means trim to null
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    // need a controller to showCustomerForm
    @GetMapping("/")
    public String showCustomerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult theBindingResult){

        System.out.println("Binding Result: "+ theBindingResult.toString());
        System.out.println("\n\n");

        if (theBindingResult.hasErrors()){
            return "customer-form";
        }else {
            return "customer-confirmation";
        }
    }

}
