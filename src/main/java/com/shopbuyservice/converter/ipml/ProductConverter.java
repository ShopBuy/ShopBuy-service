package com.shopbuyservice.converter.ipml;

import com.shopbuyservice.converter.IProductConvect;
import com.shopbuyservice.dto.ProductDto;
import com.shopbuyservice.entity.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductConverter implements IProductConvect {


    @Override
    public ProductDto convertToDTO(Product product) {
        ProductDto productDto =new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    @Override
    public List<ProductDto> convertToListDTO(List<Product> products) {
        List<ProductDto> listdto =new ArrayList<>();
        for (Product product : products
        ) {
            listdto.add(convertToDTO(product));
        }
        return listdto;
    }
}
