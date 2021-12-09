package htw.berlin.webtech.WTProjekt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RechnungRepository extends JpaRepository<RechnungEntity, Long> {
}
