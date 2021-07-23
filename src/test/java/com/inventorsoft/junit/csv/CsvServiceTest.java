package com.inventorsoft.junit.csv;

import com.inventorsoft.junit.csv.model.CreateCsvDataRequest;
import com.inventorsoft.junit.csv.model.CsvData;
import com.inventorsoft.junit.csv.model.CsvDataDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CsvServiceTest {

    @Mock
    private CsvRepository repository;

    @InjectMocks
    private CsvService service;

    @Test
    public void create_csv_data_test() {
        CsvData mockedRepositoryResponse = mockedCsvDataDto();
        when(repository.save(any())).thenReturn(mockedRepositoryResponse);

        CreateCsvDataRequest dataRequest = new CreateCsvDataRequest("test-email@gmail.com", "Testing Repository");

        CsvDataDto csvData = service.createCsvData(dataRequest);

        assertNotNull(csvData);
        assertEquals(mockedRepositoryResponse.getFileName() + "hello", csvData.getFileName());
        verify(repository, times(1)).save(any());
    }

    public static CsvData mockedCsvDataDto() {
        CsvData csvDataDto = new CsvData();
        csvDataDto.setContent("content");
        csvDataDto.setFileName("fileName");
        return csvDataDto;
    }
}
