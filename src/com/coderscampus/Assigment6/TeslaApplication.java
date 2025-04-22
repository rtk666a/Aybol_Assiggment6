package com.coderscampus.Assigment6;

import java.util.List;
import java.util.Map;

public class TeslaApplication {
    public static void main(String[] args) {
        SalesService salesService = new SalesService();
        for (Models model : Models.values()) {
            System.out.println("====== " + model.name() + " ======");
            List<TeslaSalesRecord> salesRecords = salesService.loadData(model);
            Map<Integer, Integer> yearlySales = salesService.collectYearlySales(salesRecords);
            System.out.println("Yearly Sales: " + yearlySales);
            try {
                int bestYear = salesService.getBestSalesYear(yearlySales);
                int worstYear = salesService.getWorstSalesYear(yearlySales);
                System.out.println("Best Sales Year: " + bestYear + "Sales : " + yearlySales.get(bestYear));
                System.out.println("Worst Sales Year: " + worstYear + "Sales : " + yearlySales.get(worstYear));
            } catch (IllegalStateException e) {
                System.out.println("no data available for seals");
            }

            System.out.println(); // For spacing between models
        }

    }
}