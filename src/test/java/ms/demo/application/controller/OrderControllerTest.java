package ms.demo.application.controller;

import ms.demo.application.vo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void should_get_orders_when_customer_query_orders_given_orders_available() throws Exception {
        ResponseEntity<Order> response = this.testRestTemplate.getForEntity("/orders", Order.class);

        assertThat(response.getStatusCode(), is(OK));
        Order order = response.getBody();
        assertThat(order.getId(), is(1));
    }
}
