package jva.dev.producservicev1.service;

import jva.dev.producservicev1.dto.ProductDTO;
import jva.dev.producservicev1.enums.APIError;
import jva.dev.producservicev1.exception.ApiException;
import jva.dev.producservicev1.model.Product;
import jva.dev.producservicev1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ConversionService conversionService;

    @Autowired
    public ProductService(ProductRepository productRepository, ConversionService conversionService) {
        this.productRepository = productRepository;
        this.conversionService = conversionService;
    }


    public List<ProductDTO> getProducts() {
        List<Product> products = productRepository.findAll();
        if(products.isEmpty()){
            throw new ApiException(APIError.EMPTY_PRODUCT_LIST);
        }

        return products.stream()
                .map(product -> conversionService.convert(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public ProductDTO getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ApiException(APIError.PRODUCT_NOT_FOUND);
        };
        return conversionService.convert(product.get(), ProductDTO.class);
    }

    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = conversionService.convert(productDTO, Product.class);
        Product savedProduct = productRepository.save(product);
        return conversionService.convert(savedProduct, ProductDTO.class) ;
    }

    public ProductDTO updateProduct(Long id,ProductDTO productDTO) {

        Product product = productRepository.findById(id).orElseThrow(() ->
                new ApiException(APIError.PRODUCT_NOT_FOUND));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());

        Product savedProduct = productRepository.save(product);
        return conversionService.convert(savedProduct, ProductDTO.class);
    }

    public void deleteProduct(Long id) {
        if(id == null){
            throw new ApiException(APIError.PRODUCT_NOT_FOUND);
        }
        productRepository.deleteById(id);
    }


}
