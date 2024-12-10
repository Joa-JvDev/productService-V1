package jva.dev.producservicev1.mapper;

import jva.dev.producservicev1.dto.ProductDTO;
import jva.dev.producservicev1.model.Product;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring") 
public interface ProductMapper extends Converter<Product, ProductDTO> {

    @Override
    ProductDTO convert(Product product);
}
