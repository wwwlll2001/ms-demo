package ms.demo.application.controller;

import com.netflix.spectator.api.Counter;
import com.netflix.spectator.api.Registry;
import ms.demo.application.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

@RestController
public class OrderController {

    @Autowired
    Registry registry;

    @RequestMapping("/orders")
    public Order order() {
        Counter counter = registry.counter("counterName", "tagKey1", "tagValue1");
        counter.increment(); // increment when an event occurs
        //counter.increment(10); // increment by a discrete amount
        System.out.println("======== ACCESSED=====" + counter.count());
        return new Order(1, 1, new BigDecimal(1.00), new Date(), 0);
    }
}
