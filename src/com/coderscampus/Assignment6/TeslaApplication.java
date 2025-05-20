package com.coderscampus.Assignment6;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

public class TeslaApplication {
    public static void main(String[] args) {
        System.out.println("Assigment6");
        SalesService salesService = new SalesService();
        for (Models model : Models.values()) {
            List<TeslaSalesRecord> salesRecords = salesService.loadData(model);
            Map<Integer, Integer> yearlySales = salesService.collectYearlySales(salesRecords);
            System.out.println(model +" Yearly Sales Report" +
                                             "\n--------------------------");
            yearlySales.forEach((year, sales) -> System.out.println( year + " -> " + sales));
            System.out.println("The best month for  "  + model + " was : " + salesService.getBestMonth(salesRecords));
            System.out.println("The worst month for  " + model + " was : " + salesService.getWorstMonth(salesRecords) + "\n");
        }
            
    }
}
