package htw.berlin.webtech.WTProjekt;

import htw.berlin.webtech.WTProjekt.web.api.Rechnung;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface RechnungRepository extends CrudRepository<Rechnung, Long> {
}
