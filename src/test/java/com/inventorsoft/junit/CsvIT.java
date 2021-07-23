package com.inventorsoft.junit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventorsoft.junit.csv.CsvRepository;
import com.inventorsoft.junit.csv.CsvService;
import com.inventorsoft.junit.csv.model.CreateCsvDataRequest;
import com.inventorsoft.junit.csv.model.CsvData;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = AppMain.class)
@AutoConfigureMockMvc
public class CsvIT {

    @Autowired
    MockMvc mockMvc;

    @SpyBean
    CsvService csvService;

    @Autowired
    CsvRepository csvRepository;

    @Captor
    ArgumentCaptor<CreateCsvDataRequest> csvDataRequestArgumentCaptor;

    @AfterEach
    public void dbCleanUp() throws Exception {
        csvRepository.deleteAll();
    }


    @Test
    public void testGetCsvData() throws Exception {
        CsvData save = csvRepository.save(new CsvData("Testing Controller", "test-email@gmail.com"));
        ResultActions testing_controller = mockMvc.perform(get("/api/csv-data/" + save.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", Matchers.equalTo("test-email@gmail.com")))
                .andExpect(jsonPath("$.fileName", Matchers.equalTo("Testing Controllerhello")));
//        MockHttpServletResponse response = testing_controller.andReturn().getResponse();
    }

    @Test
    public void testCreateCsvData() throws Exception {
        CreateCsvDataRequest csvDataRequest = new CreateCsvDataRequest("test-email@gmail.com", "Testing Repository");
        ResultActions testing_controller = mockMvc.perform(post("/api/csv-data")
                .content(new ObjectMapper().writeValueAsString(csvDataRequest)).header("Content-Type", "application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", Matchers.equalTo(csvDataRequest.getContent())))
                .andExpect(jsonPath("$.fileName", Matchers.equalTo(csvDataRequest.getFileName() + "hello")));

        Mockito.verify(csvService).createCsvData(csvDataRequestArgumentCaptor.capture());

        Assert.assertEquals(csvDataRequest.getContent(), csvDataRequestArgumentCaptor.getValue().getContent());
        Assert.assertNotNull(csvDataRequest.getFileName(), csvDataRequestArgumentCaptor.getValue().getFileName());
//        MockHttpServletResponse response = testing_controller.andReturn().getResponse();
    }
}
