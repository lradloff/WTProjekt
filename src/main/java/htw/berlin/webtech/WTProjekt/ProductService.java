package htw.berlin.webtech.WTProjekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public Product save(Product product){
        return repo.save(product);
    }

    public Product get(Long id) {
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }
}
