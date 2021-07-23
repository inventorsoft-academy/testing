package com.inventorsoft.junit.csv.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CsvDataDto {
    private String content;
    private String fileName;

    public CsvDataDto(CsvData csvData) {
        this.content = csvData.getContent();
        this.fileName = csvData.getFileName() + "hello";
    }
}
