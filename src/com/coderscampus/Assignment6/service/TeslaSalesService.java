package com.coderscampus.Assignment6.service;

import com.coderscampus.Assignment6.domain.TeslaModel;
import com.coderscampus.Assignment6.domain.TeslaSales;

import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

public class TeslaSalesService {
    FileService fileService = new FileService();


    public void printReport(TeslaModel model) {
        List<TeslaSales> salesByModel = loadData(model);
        Map<Integer , Integer> yearlySealsByModel = collectYearlySales(salesByModel);
        System.out.println(model +" Yearly Sales Report" +
                "\n--------------------------");
        yearlySealsByModel.forEach((year, sales) -> System.out.println( year + " -> " + sales));
        System.out.println("The best month for  "  + model + " was : " + getBestMonth(salesByModel));
        System.out.println("The worst month for  " + model + " was : " + getWorstMonth(salesByModel) + "\n");
    }

    private List<TeslaSales> loadData(TeslaModel model) {
        return fileService.read(model.name())
                .stream()
                .map(line -> convertToTeslaSealsRecord(line, model))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private Optional<TeslaSales> convertToTeslaSealsRecord(String line, TeslaModel model) {
        try {
            String[] data = line.split(",");
            if (data.length != 2) {
                return Optional.empty();
            }

            return Optional.of(new TeslaSales(model, data[0], Integer.parseInt(data[1])));

        } catch (Exception e) {
            System.out.println("hey man! we have some convert exception here  !! : " + e.getMessage());
            return Optional.empty();
        }
    }

    private Map<Integer, Integer> collectYearlySales(List<TeslaSales> salesRecords) {
        return salesRecords.stream()
                .collect(Collectors.groupingBy(
                        record -> record.getDate().getYear(),
                        Collectors.summingInt(TeslaSales::getSales)
                ));
    }

    private YearMonth getBestMonth(List<TeslaSales> salesRecords) {
        return salesRecords.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(TeslaSales::getSales))
                .map(TeslaSales::getDate)
                .orElseThrow(() -> new IllegalStateException("No sales records available"));
    }

    private YearMonth getWorstMonth(List<TeslaSales> salesRecords) {
        return salesRecords.stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparingInt(TeslaSales::getSales))
                .map(TeslaSales::getDate)
                .orElseThrow(() -> new IllegalStateException("No sales records available"));
    }
}