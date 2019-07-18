package ro.msg.learning.shop.dto;

import lombok.Data;
import ro.msg.learning.shop.entities.SimpleProduct;
import java.util.function.Consumer;

@Data
public class SimpleProductDTO {

    private Integer id;
    private Integer quantity;

    public SimpleProductDTO() {
    }

    public SimpleProductDTO(Integer id, Integer quantity) {
        super();
        this.id = id;
        this.quantity = quantity;
    }

    public static SimpleProductDTO simpleProductToDTO (SimpleProduct simpleProduct){
        SimpleProductDTO simpleProductDto = new SimpleProductDTO.SimpleProductBuilder()
                .with($ -> {
                    $.nestedId = simpleProduct.getId();
                    $.nestedQuantity = simpleProduct.getQuantity();
                })
                .createSimpleProduct();
        return simpleProductDto;
    }

    public static SimpleProduct dtoToProduct (SimpleProductDTO simpleProductDTO) {
        SimpleProduct simpleProduct = new SimpleProduct();
        simpleProduct.setId(simpleProductDTO.getId());
        simpleProduct.setQuantity(simpleProductDTO.getQuantity());
        return simpleProduct;
    }

    public static class SimpleProductBuilder {
        public Integer nestedId;
        public Integer nestedQuantity;

        public SimpleProductBuilder with(
                Consumer<SimpleProductBuilder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public SimpleProductDTO createSimpleProduct() {
            return new SimpleProductDTO(nestedId, nestedQuantity);
        }
    }

}