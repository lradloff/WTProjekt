package htw.berlin.webtech.WTProjekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RechnungController {

    @Autowired
    RechnungService service;

    @PostMapping("/rechnungen")
    public Rechnung createRechnung(@RequestBody Rechnung rechnung) {return service.save(rechnung);}

    @GetMapping("rechnungen/{id}")
    public Rechnung getRechnung(@PathVariable String id){
        Long rechnungId = Long.parseLong(id);
        return service.get(rechnungId);
    }
}
