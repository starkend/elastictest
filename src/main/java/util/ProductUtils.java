package util;

import com.starkend.elastictest.dto.ProductDto;
import com.starkend.elastictest.model.Product;
import org.springframework.beans.BeanUtils;

public class ProductUtils {

    public static Product convertProductDtoToProduct(ProductDto dto) {
        Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        return product;
    }

    public static ProductDto convertProductToProductDto(Product product) {
        ProductDto dto = new ProductDto();
        BeanUtils.copyProperties(product, dto);
        return dto;
    }
}