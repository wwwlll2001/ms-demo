package ms.demo.application.controller;

import ms.demo.application.vo.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Enumeration;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/users")
    public User user(HttpServletRequest request) {

        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
        }


        ServiceInstance serviceInstance = client.getInstances("BBBBBB").get(0);
        String url = serviceInstance.getUri() + "/users";

        return new RestTemplate().getForObject(url, User.class);
    }
}
