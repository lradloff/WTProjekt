package htw.berlin.webtech.WTProjekt;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface RechnungRepository extends CrudRepository<Rechnung, Long> {
}
