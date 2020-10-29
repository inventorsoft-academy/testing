package com.inventorsoft.junit.csv;

import javax.persistence.*;

@Entity
@Table(name = "csv_data")
public class CsvData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String email;

}
