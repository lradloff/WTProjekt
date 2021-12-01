package htw.berlin.webtech.WTProjekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RechnungService {

    @Autowired
    RechnungRepository repo;

    public Rechnung save(Rechnung rechnung) { return repo.save(rechnung); }

    public Rechnung get(Long id) { return repo.findById(id).orElseThrow(RuntimeException::new); }

}
