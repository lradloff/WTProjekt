package htw.berlin.webtech.service;

import htw.berlin.webtech.WTProjekt.persistence.RechnungRepository;
import htw.berlin.webtech.WTProjekt.service.RechnungService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
}
