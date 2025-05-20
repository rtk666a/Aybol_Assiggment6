package com.coderscampus.Assignment6.domain;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TeslaSales {
    private TeslaModel models;
    private YearMonth date;
    private int sales;

    public TeslaSales(TeslaModel models, String date, int sales) {
        this.models = models;
        this.date = YearMonth.parse(date, DateTimeFormatter.ofPattern("MMM-yy", Locale.US));
        this.sales = sales;
    }


    public TeslaModel getModels() {
        return models;
    }

    public void setModels(TeslaModel models) {
        this.models = models;
    }

    public YearMonth getDate() {
        return date;
    }

    public void setDate(YearMonth date) {
        this.date = date;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "TeslaSalesRecord{" +
                "models=" + models +
                ", date=" + date +
                ", sales=" + sales +
                '}';
    }
}
