package com.ckdemo.coronavirustracker;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaInfectionService {
    @Autowired
    GitHubService gitHubService;

    public List<InfectionStats> getInfectionStats(){
        List<InfectionStats> statsList = new ArrayList<>();
        StringReader in = new StringReader(gitHubService.getCovidInfectedData().block());
        Iterable<CSVRecord> records = null;
        try {
            records = CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .parse(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CSVRecord record : records) {
            InfectionStats stats = new InfectionStats();
            stats.setState(record.get("Province/State"));
            stats.setCountry(record.get("Country/Region"));
            stats.setInfectionCount(Integer.parseInt(record.get(record.size()-1)));
            statsList.add(stats);
        }
        return statsList;
    }
}
