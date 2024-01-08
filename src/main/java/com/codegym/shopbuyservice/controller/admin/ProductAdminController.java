package com.codegym.shopbuyservice.controller.admin;

import com.codegym.shopbuyservice.dto.payload.response.PagingProductResponse;
import com.codegym.shopbuyservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/")
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
}
