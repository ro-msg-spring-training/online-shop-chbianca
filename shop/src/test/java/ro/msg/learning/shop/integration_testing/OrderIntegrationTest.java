package ro.msg.learning.shop.integration_testing;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ro.msg.learning.shop.auxiliar_entities.Address;
import ro.msg.learning.shop.auxiliar_entities.SimpleProduct;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.SimpleOrderDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties"
)
public class OrderIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createOrder() throws Exception {
        Address a1 = new Address("Romania", "Cluj", "Cluj", "George Baritiu");

        List<SimpleProduct> simpleProducts = new ArrayList<>();
        SimpleProduct sp1 = new SimpleProduct(1, 3);
        SimpleProduct sp2 = new SimpleProduct(2, 3);
        simpleProducts.add(sp1);
        simpleProducts.add(sp2);

        SimpleOrderDTO simpleOrderDTO = new SimpleOrderDTO(null, a1, simpleProducts);
        OrderDTO orderDTO = new OrderDTO(2, null, null, null, a1);

        this.mockMvc.perform(post("http://localhost:8080/order/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(asJsonString(simpleOrderDTO))))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(orderDTO.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.shippedFrom").value(orderDTO.getShippedFrom()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.customer").value(orderDTO.getCustomer()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.createdAt").value(orderDTO.getCreatedAt()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").value(orderDTO.getAddress()));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}


