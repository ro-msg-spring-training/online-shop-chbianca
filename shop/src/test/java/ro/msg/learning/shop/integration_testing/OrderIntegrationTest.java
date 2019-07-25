package ro.msg.learning.shop.integration_testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import ro.msg.learning.shop.services.OrderService;


@RunWith(SpringRunner.class)
@DataJpaTest
@WebAppConfiguration
public class OrderIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private OrderService orderServiceMock;

    @Test
    public void createOrder() {
        // given

    }
}
