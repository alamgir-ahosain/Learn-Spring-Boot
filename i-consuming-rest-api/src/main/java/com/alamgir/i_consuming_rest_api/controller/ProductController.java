package com.alamgir.i_consuming_rest_api.controller;

import org.springframework.web.bind.annotation.RestController;
import com.alamgir.i_consuming_rest_api.dto.ProductDto;
import com.alamgir.i_consuming_rest_api.dto.another.ProductDto2;
import com.alamgir.i_consuming_rest_api.request.ProductRequest;
import com.alamgir.i_consuming_rest_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<ProductDto[]> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable int id, @RequestBody ProductRequest productRequest) {
        return productService.updateProduct(id, productRequest);
    }




    // _______________________  Another Example  ______________

    @GetMapping("/product2/{id}")
    public ResponseEntity<ProductDto2> getProduct2(@PathVariable int id) {
        return productService.getProduct2(id);
    }

      @PutMapping("/product2/{id}")
    public ResponseEntity<ProductDto2> updateProduct(@PathVariable int id, @RequestBody  ProductDto2 productsDto) {
        return productService.updateProduct2(id, productsDto);
    }


}
