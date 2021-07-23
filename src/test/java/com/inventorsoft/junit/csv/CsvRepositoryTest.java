package com.inventorsoft.junit.csv;

import com.inventorsoft.junit.csv.model.CsvData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CsvRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CsvRepository csvRepository;

    @Test
    public void findById_should_return_csv_data() {
        CsvData csvData = new CsvData();
        csvData.setFileName("file name");
        csvData.setContent("content");

        csvData = testEntityManager.persistAndFlush(csvData);

        testEntityManager.detach(csvData);

        Assert.assertEquals(csvRepository.findById(csvData.getId()).orElse(null), csvData);
    }
}
