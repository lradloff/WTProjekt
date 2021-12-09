package htw.berlin.webtech.WTProjekt.service;

import htw.berlin.webtech.WTProjekt.persistence.RechnungEntity;
import htw.berlin.webtech.WTProjekt.persistence.RechnungRepository;
import htw.berlin.webtech.WTProjekt.web.api.Rechnung;
import htw.berlin.webtech.WTProjekt.web.api.RechnungManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RechnungService {

    private final RechnungRepository rechnungRepository;

    public RechnungService(RechnungRepository rechnungRepository) {
        this.rechnungRepository = rechnungRepository;

    }

    public List<Rechnung> findAll() {
        List<RechnungEntity> rechnungen = rechnungRepository.findAll();
        return rechnungen.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Rechnung findById(Long id) {
        var rechnungEntity = rechnungRepository.findById(id);
        return rechnungEntity.map(this::transformEntity).orElse(null);
    }

    public Rechnung create(RechnungManipulationRequest request) {
        var rechnungEntity = new RechnungEntity(request.getRechnung(), request.getDatum());
        rechnungEntity =  rechnungRepository.save(rechnungEntity);
        return transformEntity(rechnungEntity);
    }

    public Rechnung update(Long id, RechnungManipulationRequest request) {
        var rechnungEntityOptional = rechnungRepository.findById(id);
        if (rechnungEntityOptional.isEmpty()) {
            return null;
        }

        var rechnungEntity = rechnungEntityOptional.get();
        rechnungEntity.setRechnung(request.getRechnung());
        rechnungEntity.setDatum(request.getDatum());
        rechnungEntity = rechnungRepository.save(rechnungEntity);

        return transformEntity(rechnungEntity);
    }

    public boolean deleteById(Long id) {
        if (!rechnungRepository.existsById(id)) {
            return false;
        }

        rechnungRepository.deleteById(id);
        return true;
    }

    private Rechnung transformEntity(RechnungEntity rechnungEntity) {
        return new Rechnung(
                rechnungEntity.getId(),
                rechnungEntity.getRechnung(),
                rechnungEntity.getDatum()
        );
    }

}
