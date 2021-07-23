package com.inventorsoft.junit.csv;

import com.inventorsoft.junit.csv.model.CreateCsvDataRequest;
import com.inventorsoft.junit.csv.model.CsvData;
import com.inventorsoft.junit.csv.model.CsvDataDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CsvService {

    private CsvRepository csvRepository;

    public CsvService(CsvRepository csvRepository) {
        this.csvRepository = csvRepository;
    }

    public CsvDataDto getCsvData(Long id) {
        CsvData csvData = csvRepository.findById(id).orElseThrow(RuntimeException::new);
        return new CsvDataDto(csvData);
    }

    public CsvDataDto createCsvData(CreateCsvDataRequest dataRequest) {
        CsvData preSave = mapToCsvData(dataRequest);
        CsvData csvData = csvRepository.save(preSave);
        return new CsvDataDto(csvData);
    }

    private CsvData mapToCsvData(CreateCsvDataRequest csvDataRequest) {
        CsvData csvData = new CsvData();
        csvData.setContent(csvDataRequest.getContent());
        csvData.setFileName(csvDataRequest.getFileName());
        return csvData;
    }

}
