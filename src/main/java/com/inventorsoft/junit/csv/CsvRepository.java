package com.inventorsoft.junit.csv;

import com.inventorsoft.junit.csv.model.CsvData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CsvRepository extends CrudRepository<CsvData, Long> {
}
