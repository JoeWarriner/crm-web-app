package crm_web_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {


    @Autowired
    CustomerAPIConsumer apiConsumer;

    @GetMapping("/customer/new")
    public String newCustomerForm(Model model){
        model.addAttribute("newcustomer", new NewCustomer());
        return "newcustomer";
    }

    @PostMapping("/customer/new")
    public ModelAndView customerSubmit(@ModelAttribute NewCustomer customer, Model model){
        String id = apiConsumer.postCustomer(customer);
        return new ModelAndView(String.format("redirect:/customer?id=%s",id));
    }

    @GetMapping("/customer")
    public String displayCustomer(@RequestParam String id, Model model){
        Customer customer = apiConsumer.getCustomer(id);
        System.out.println(customer.getId());
        model.addAttribute("customer", customer);
        return "customerpage";
    }




}
