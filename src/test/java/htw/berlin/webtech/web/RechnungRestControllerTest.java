package htw.berlin.webtech.web;

import htw.berlin.webtech.WTProjekt.config.WebConfig;
import htw.berlin.webtech.WTProjekt.service.RechnungService;
import htw.berlin.webtech.WTProjekt.web.RechnungRestController;
import htw.berlin.webtech.WTProjekt.web.api.Rechnung;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RechnungRestController.class)
@Import(RechnungRestController.class)
@ContextConfiguration(classes = {WebConfig.class})
public class RechnungRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RechnungService rechnungService;

    @Test
    @DisplayName("should return found calculations from RechnungService")
    void return_found_calculation_from_rechnung_service() throws Exception {

        var rechnungen = List.of(
                new Rechnung(1L, "1+1", "01.01.2022", "2"),
                new Rechnung(2L, "10*3+5", "03.12.2021", "35")
        );
        doReturn(rechnungen).when(rechnungService).findAll();

        mockMvc.perform(get("/rechnungen"))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].rechnung").value("1+1"))
                .andExpect(jsonPath("$[0].datum").value("01.01.2022"))
                .andExpect(jsonPath("$[0].ergebnis").value("2"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].rechnung").value("10*3+5"))
                .andExpect(jsonPath("$[1].datum").value("03.12.2021"))
                .andExpect(jsonPath("$[1].ergebnis").value("35"));
    }

    @Test
    @DisplayName("should return 404 if calculation is not found")
    void return_404_if_calulation_not_found() throws Exception {

        doReturn(null).when(rechnungService).findById(anyLong());

        mockMvc.perform(get("/rechnungen/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and location header when creating a calculation")
    void return_201_status_and_location_header_when_creating_calculation() throws Exception {

        String rechnungJson = "{\"rechnung\": \"2-2\", \"datum\": \"02.01.2022\", \"ergebnis\": 0}";
        var rechnung = new Rechnung(1L, null, null, null);
        doReturn(rechnung).when(rechnungService).create(any());

        mockMvc.perform(
                        post("/rechnungen")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(rechnungJson)
                )
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/rechnungen/" + rechnung.getId()))));
    }

    @Test
    @DisplayName("should return the correct calculation when using put request")
    void return_correct_calculation_when_putting() throws Exception {

        var rechnung = new Rechnung(1L, "3*3", "04.01.2022", "9");
        String rechnungJson = "{\"id\": \"1\", \"rechnung\": \"3*3\", \"datum\": \"04.01.2022\", \"ergebnis\": 9}";

        doReturn(rechnung).when(rechnungService).update(anyLong(), any());

        mockMvc.perform(
                        put("/rechnungen/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(rechnungJson)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.rechnung").value("3*3"))
                .andExpect(jsonPath("$.datum").value("04.01.2022"))
                .andExpect(jsonPath("$.ergebnis").value("9"));
    }

    @Test
    @DisplayName("should return 404 if the existing calculation is not found when using put request")
    void return_404_if_calculation_not_found_when_putting() throws Exception {

        String rechnungJson = "{\"id\": \"1\", \"rechnung\": \"3*3\", \"datum\": \"04.01.2022\", \"ergebnis\": 9}";

        doReturn(null).when(rechnungService).update(anyLong(), any());

        mockMvc.perform(
                        put("/rechnungen/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(rechnungJson)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 200 if delete was successful")
    void dalete_test() throws Exception {

        doReturn(true).when(rechnungService).deleteById(anyLong());

        mockMvc.perform(delete("/rechnungen/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("should return 404 if calculation to delete was not found")
    void return_404_if_calculation_to_dalete_not_found() throws Exception {

        doReturn(false).when(rechnungService).deleteById(anyLong());

        mockMvc.perform(delete("/rechnungen/1"))
                .andExpect(status().isNotFound());
    }

}