package com.inventorsoft.junit.csv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCsvDataRequest {

    private String fileName;

    private String content;

}
