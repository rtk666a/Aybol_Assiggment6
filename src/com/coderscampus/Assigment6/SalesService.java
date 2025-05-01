package com.coderscampus.Assigment6;

import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

public class SalesService {
    FileService fileService = new FileService();
    public List<TeslaSalesRecord> loadData(Models model){
        return fileService.read(model.name())
                          .stream()
                          .map(line -> convertToTeslaSealsRecord(line , model))
                          .filter(Optional::isPresent)
                          .map(Optional::get)
                          .collect(Collectors.toList());
    }

    private Optional<TeslaSalesRecord> convertToTeslaSealsRecord(String line , Models model) {
        try {
            String[] data = line.split(",");
            if(data.length < 2 ){
                return Optional.empty();
            }

            return Optional.of(new TeslaSalesRecord(model , data[0] , Integer.parseInt(data[1])));

        }catch (Exception exception){
            System.out.println("hey man! we have some convert exception here  !! : " + exception.getMessage());
            return Optional.empty();
        }
    }

    public Map<Integer , Integer> collectYearlySales(List<TeslaSalesRecord> salesRecords){
        return salesRecords.stream()
                           .collect(Collectors.groupingBy(
                                   record -> record.getDate().getYear(),
                                   Collectors.summingInt(TeslaSalesRecord::getSales)
                           ));
    }

    public YearMonth getBestMonth(List<TeslaSalesRecord> salesRecords) {
        return salesRecords.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(TeslaSalesRecord::getSales))
                .map(TeslaSalesRecord::getDate)
                .orElseThrow(() -> new IllegalStateException("No sales records available"));
    }

    public YearMonth getWorstMonth(List<TeslaSalesRecord> salesRecords) {
        return salesRecords.stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparingInt(TeslaSalesRecord::getSales))
                .map(TeslaSalesRecord::getDate)
                .orElseThrow(() -> new IllegalStateException("No sales records available"));
    }
}