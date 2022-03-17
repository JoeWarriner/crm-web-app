package crm_web_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class NewCustomerController {


    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/customer/new")
    public String newCustomerForm(Model model){
        model.addAttribute("newcustomer", new NewCustomer());
        return "newcustomer";
    }

    @PostMapping("/customer/new")
    public String greetingSubmit(@ModelAttribute NewCustomer customer, Model model){

        String mystring = restTemplate.postForObject(
                    "http://localhost:8080/customer", customer, String.class);

        model.addAttribute("customerid", mystring);

        return "result";
    }



}
