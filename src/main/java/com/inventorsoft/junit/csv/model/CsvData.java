package com.inventorsoft.junit.csv.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "csv_data")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class CsvData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String fileName;

    private String content;

    public CsvData(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }
}
