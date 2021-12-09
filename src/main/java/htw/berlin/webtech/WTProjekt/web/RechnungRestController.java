package htw.berlin.webtech.WTProjekt.web;

//import htw.berlin.webtech.WTProjekt.RechnungService;
import htw.berlin.webtech.WTProjekt.service.RechnungService;
import htw.berlin.webtech.WTProjekt.web.api.Rechnung;
import htw.berlin.webtech.WTProjekt.web.api.RechnungManipulationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class RechnungRestController {

    private final RechnungService rechnungService;

    public RechnungRestController(RechnungService rechnungService) {
        this.rechnungService = rechnungService;
    }

    @GetMapping("/rechnungen")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Rechnung>> fetchRechnungen() {
        return ResponseEntity.ok(rechnungService.findAll());
    }

    @GetMapping(path = "/rechnungen/{id}")
    public ResponseEntity<Rechnung> fetchRechnungById(@PathVariable Long id) {
        var rechnung = rechnungService.findById(id);
        return rechnung != null? ResponseEntity.ok(rechnung) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/rechnungen")
    public ResponseEntity<Void> createRechnung(@RequestBody RechnungManipulationRequest request) throws URISyntaxException {
        var rechnung = rechnungService.create(request);
        URI uri = new URI("/rechnungen/" + rechnung.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/rechnungen/{id}")
    public ResponseEntity<Rechnung> updateRechnung(@PathVariable Long id, @RequestBody RechnungManipulationRequest request) {
        var rechnung = rechnungService.update(id, request);
        return rechnung != null? ResponseEntity.ok(rechnung) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/rechnungen/{id}")
    public ResponseEntity<Void> deleteRechnung(@PathVariable Long id) {
        boolean successful = rechnungService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}

/**
 * package htw.berlin.webtech.WTProjekt.web;
 *
 * import htw.berlin.webtech.WTProjekt.RechnungService;
 * import htw.berlin.webtech.WTProjekt.web.api.Rechnung;
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 *
 * @RestController
 * public class RechnungRestController {
 *
 *     @Autowired
 *     RechnungService service;
 *
 *     @PostMapping("/rechnungen")
 *     public Rechnung createRechnung(@RequestBody Rechnung rechnung) {return service.save(rechnung);}
 *
 *     @GetMapping("rechnungen/{id}")
 *     public Rechnung getRechnung(@PathVariable String id){
 *         Long rechnungId = Long.parseLong(id);
 *         return service.get(rechnungId);
 *     }
 *
 *
 * }
 */