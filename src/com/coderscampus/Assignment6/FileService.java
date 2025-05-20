package com.coderscampus.Assignment6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileService {
    public  List<String> read(String fileName) {
        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/" + fileName + ".csv"))) {
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException exception) {
            System.out.println("there was exception IO file :" + exception.getMessage());
        }
        return data;
    }
}
