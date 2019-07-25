package ro.msg.learning.shop.dto;

import lombok.Data;
import ro.msg.learning.shop.entities.SimpleProduct;
import java.util.function.Consumer;

@Data
public class SimpleProductDTO {

    private Integer productId;
    private Integer quantity;

    public SimpleProductDTO(Integer productId, Integer quantity) {
        super();
        this.productId = productId;
        this.quantity = quantity;
    }

    public static SimpleProductDTO simpleProductToDTO (SimpleProduct simpleProduct){
        SimpleProductDTO simpleProductDto = new SimpleProductDTO.SimpleProductBuilder()
                .with($ -> {
                    $.nestedProductId = simpleProduct.getProductId();
                    $.nestedQuantity = simpleProduct.getQuantity();
                })
                .createSimpleProduct();
        return simpleProductDto;
    }

    public static SimpleProduct dtoToProduct (SimpleProductDTO simpleProductDTO) {
        SimpleProduct simpleProduct = new SimpleProduct();
        simpleProduct.setProductId(simpleProductDTO.getProductId());
        simpleProduct.setQuantity(simpleProductDTO.getQuantity());
        return simpleProduct;
    }

    public static class SimpleProductBuilder {
        public Integer nestedProductId;
        public Integer nestedQuantity;

        public SimpleProductBuilder with(
                Consumer<SimpleProductBuilder> builderFunction) {
            builderFunction.accept(this);
            return this;
        }

        public SimpleProductDTO createSimpleProduct() {
            return new SimpleProductDTO(nestedProductId, nestedQuantity);
        }
    }

}