package htw.berlin.webtech.WTProjekt.testproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return service.save(product);
    }

   @GetMapping("/products/{id}")
   public Product getProduct(@PathVariable String id){
        Long productId = Long.parseLong(id);
        return service.get(productId);
   }
}
