package com.codegym.shopbuyservice.controller.admin;


import com.codegym.shopbuyservice.dto.ProductDetailDto;
import com.codegym.shopbuyservice.dto.ProductDto;
import com.codegym.shopbuyservice.dto.payload.request.NewProductRequest;
import com.codegym.shopbuyservice.dto.payload.response.PagingProductResponse;
import com.codegym.shopbuyservice.dto.payload.response.ProductDetailResponseDto;
import com.codegym.shopbuyservice.dto.payload.response.ProductResponseDto;
import com.codegym.shopbuyservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(value = "*", maxAge = 3600)
public class ProductAdminController {
    @Autowired
    private IProductService iProductService;

    @GetMapping({"/all"})
    public ResponseEntity<?>findAllProducts( @RequestParam(defaultValue = "0") int pageNumber,
                                             @RequestParam(defaultValue = "7") int pageSize){
        PagingProductResponse response = iProductService.findAll(pageNumber, pageSize);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody NewProductRequest newProductRequest) {
        try {
            ProductResponseDto response = iProductService.create(newProductRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductDetailResponseDto> getProductId(@PathVariable Long productId) {
        ProductDetailResponseDto response = new ProductDetailResponseDto();
        try {
            ProductDetailDto productDetailDto = iProductService.detailProduct(productId);
            response.setData(productDetailDto);
            response.setStatusCode(200);
            response.setMessage("The product was found successfully.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setStatusCode(404);
            response.setMessage("Product does not exist.");
            return ResponseEntity.status(404).body(response);
        }
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody NewProductRequest productDto) {
        try {
            ProductResponseDto response = iProductService.updateProduct(id, productDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        try {
            iProductService.deleteProduct(id);
            return ResponseEntity.ok().body("Product deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
