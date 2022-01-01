package htw.berlin.webtech.service;

import htw.berlin.webtech.WTProjekt.persistence.RechnungEntity;
import htw.berlin.webtech.WTProjekt.persistence.RechnungRepository;
import htw.berlin.webtech.WTProjekt.service.RechnungService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
}
