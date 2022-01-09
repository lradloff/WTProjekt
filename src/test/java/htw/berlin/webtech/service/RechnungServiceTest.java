package htw.berlin.webtech.service;

import htw.berlin.webtech.WTProjekt.persistence.RechnungEntity;
import htw.berlin.webtech.WTProjekt.persistence.RechnungRepository;
import htw.berlin.webtech.WTProjekt.service.RechnungService;
import htw.berlin.webtech.WTProjekt.web.api.Rechnung;
import htw.berlin.webtech.WTProjekt.web.api.RechnungManipulationRequest;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
public class RechnungServiceTest implements WithAssertions {

    @Mock
    private RechnungRepository repository;

    @InjectMocks
    private RechnungService underTest;

    @Test
    @DisplayName("Should return true if delete was successful")
    void true_if_delete_successful() {

        Long givenId = 1L;
        doReturn(true).when(repository).existsById(givenId);

        boolean result = underTest.deleteById(givenId);

        verify(repository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Should return false if person to delete does not exist")
    void false_if_person_to_delete_does_not_exist() {

        Long givenId = 1L;
        doReturn(false).when(repository).existsById(givenId);

        boolean result = underTest.deleteById(givenId);

        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("should transform RechnungEntity to Rechnung")
    void transform_rechnung_entity_to_rechnung() {

        var rechnungEntity = Mockito.mock(RechnungEntity.class);
        doReturn(1L).when(rechnungEntity).getId();
        doReturn("1+1").when(rechnungEntity).getRechnung();
        doReturn("01.01.2022").when(rechnungEntity).getDatum();
        doReturn("2").when(rechnungEntity).getErgebnis();

        var result = underTest.transformEntity(rechnungEntity);

        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getRechnung()).isEqualTo("1+1");
        assertThat(result.getDatum()).isEqualTo("01.01.2022");
        assertThat(result.getErgebnis()).isEqualTo("2");
    }

    @Test
    @DisplayName("should transform List of RechnungEntity to List of Rechnung and return it when using findAll")
    void should_transform_and_return_list_of_calculations() {

        var rechnungen = List.of(
                new RechnungEntity("1+1", "03.01.2022", "2"),
                new RechnungEntity("3+3*4", "01.01.2022", "24")
        );

        doReturn(rechnungen).when(repository).findAll();

        var result = underTest.findAll();

        verify(repository).findAll();
        assertThat(result.get(0).getRechnung()).isEqualTo("1+1");
        assertThat(result.get(0).getDatum()).isEqualTo("03.01.2022");
        assertThat(result.get(0).getErgebnis()).isEqualTo("2");
        assertThat(result.get(1).getRechnung()).isEqualTo("3+3*4");
        assertThat(result.get(1).getDatum()).isEqualTo("01.01.2022");
        assertThat(result.get(1).getErgebnis()).isEqualTo("24");
    }
}
