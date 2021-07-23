package com.inventorsoft.junit.csv;

import com.inventorsoft.junit.csv.model.CreateCsvDataRequest;
import com.inventorsoft.junit.csv.model.CsvDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/csv-data")
@RequiredArgsConstructor
public class CsvController {

    private final CsvService service;

    @GetMapping(path = "/{id}")
    public CsvDataDto getCsvData(@PathVariable Long id) {
        return service.getCsvData(id);
    }

    @PostMapping
    public CsvDataDto createCsvData(@RequestBody CreateCsvDataRequest request) {
        return service.createCsvData(request);
    }

}
