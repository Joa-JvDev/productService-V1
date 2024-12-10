package jva.dev.producservicev1.mapper;

import jva.dev.producservicev1.dto.ProductDTO;
import jva.dev.producservicev1.model.Product;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductListMapper extends Converter<List<Product>, List<ProductDTO>> {

    @Override
    List<ProductDTO> convert(List<Product> source);

}
