package com.inventorsoft.junit.csv;

import com.inventorsoft.junit.csv.model.CsvDataDto;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CsvController.class)
public class CsvControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CsvService csvService;

    @MockBean
    private CsvRepository csvRepository;

    @Test
    public void testGet() throws Exception {
        when(csvService.getCsvData(anyLong())).thenReturn(mockedCsvData());

        mockMvc.perform(get("/api/csv-data/123456"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", Matchers.equalTo("test-email@gmail.com")))
                .andExpect(jsonPath("$.fileName", Matchers.equalTo("Testing Controller")));

    }

    private CsvDataDto mockedCsvData() {
        CsvDataDto csvDataDto = new CsvDataDto();
        csvDataDto.setContent("test-email@gmail.com");
        csvDataDto.setFileName("Testing Controller");
        return csvDataDto;
    }

}
