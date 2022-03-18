package crm_web_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class CustomerAPIConsumer {

    @Autowired
    RestTemplate restTemplate;

    public String postCustomer(NewCustomer customer){

        String id = restTemplate.postForObject(
                "http://localhost:8080/customer", customer, String.class);

        return id;
    }
}
