
package com.stc;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class jsonReader implements stcReader{
    @Override
    public ArrayList<unifiedFormat> parsee(File pathFile) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File file = new File(pathFile.toURI());
            List<unifiedFormat> employees = objectMapper.readValue(file, new TypeReference<List<unifiedFormat>>() {});

            for (unifiedFormat employee : employees) {

                System.out.println("Name: " + employee.getName());
                System.out.println("Department: " + employee.getDepartment());
                System.out.println("Salary: " + employee.getSalary());
                System.out.println("gender " + employee.getGender());

                System.out.println();
            }
            return (ArrayList<unifiedFormat>) employees;
        } catch (IOException e) {

        }


        return null;
    }
}