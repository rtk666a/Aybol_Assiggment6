package com.coderscampus.Assigment6;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

public class TeslaApplication {
    public static void main(String[] args) {
        SalesService salesService = new SalesService();
        for (Models model : Models.values()) {
            List<TeslaSalesRecord> salesRecords = salesService.loadData(model);
            Map<Integer, Integer> yearlySales = salesService.collectYearlySales(salesRecords);
            System.out.println(model.name() +" Yearly Sales Report" +
                                             "\n--------------------------");
            yearlySales.forEach((year, sales) -> System.out.println( year + " -> " + sales));
            System.out.println("The best month for  "  + model.name() + " : " + salesService.getBestMonth(salesRecords));
            System.out.println("The worst month for  " + model.name() + " : " + salesService.getWorstMonth(salesRecords) + "\n");
        }
            
    }
}
