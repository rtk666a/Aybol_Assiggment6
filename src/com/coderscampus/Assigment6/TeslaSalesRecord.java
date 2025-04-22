package com.coderscampus.Assigment6;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TeslaSalesRecord {
    Models models;
    YearMonth date;
    int sales;

    public TeslaSalesRecord(Models models, String date, int sales) {
        this.models = models;
        this.date = YearMonth.parse(date, DateTimeFormatter.ofPattern("MMM-yy", Locale.US));
        this.sales = sales;
    }


    public Models getModels() {
        return models;
    }

    public void setModels(Models models) {
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
