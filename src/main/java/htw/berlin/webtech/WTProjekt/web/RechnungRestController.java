package htw.berlin.webtech.WTProjekt.web;

import htw.berlin.webtech.WTProjekt.RechnungService;
import htw.berlin.webtech.WTProjekt.web.api.Rechnung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class RechnungRestController {

    private List<Rechnung> rechnungen;

    public RechnungRestController(){
        rechnungen = new ArrayList<>();
        rechnungen.add(new Rechnung("1+1+1+1", LocalDate.now()));
        rechnungen.add(new Rechnung("2+2+2+2", LocalDate.now()));
    }

    @GetMapping("rechnungen/")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Rechnung>> fetchRechnungen() {
        return ResponseEntity.ok(rechnungen);
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