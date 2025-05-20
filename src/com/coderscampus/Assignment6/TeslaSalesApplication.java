package com.coderscampus.Assignment6;

import com.coderscampus.Assignment6.domain.TeslaModel;
import com.coderscampus.Assignment6.service.TeslaSalesService;

public class TeslaSalesApplication {
    public static void main(String[] args) {
        TeslaSalesService teslaSalesService = new TeslaSalesService();
        for (TeslaModel model : TeslaModel.values()) {
            teslaSalesService.printReport(model);
        }
    }
}
