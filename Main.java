package com.stc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Integer.MIN_VALUE;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        sqlreader databaseHandler = new sqlreader();
        databaseHandler.conectdatabase("stc_reader", "postgres", "Ah1411@@");


        FileProcessor fileProcessor = new FileProcessor();

        File folder = new File("C:\\Users\\HP\\Desktop\\files");


        fileProcessor.pushFilesFromFolder(String.valueOf(folder));


        fileProcessor.processFiles();


        // String folderPath = "C:\\Users\\HP\\Desktop\\files";
        // File folder = new File("C:\\Users\\HP\\Desktop\\files");

        ArrayList<unifiedFormat> employeelist = new ArrayList<>();
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {

                    String fileName = file.getName();
                    String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
                    stcReader reader = Handler.getstcReader(fileExtension);
                    assert reader != null;
                    employeelist = reader.parsee(new File(file.getPath()));
                }

                employeelist= (ArrayList<unifiedFormat>) sqlreader.readerdatabase();

                // find the employee with the highest salary:
                unifiedFormat highestSalaryEmployee = null;
                int maxSalary = MIN_VALUE;

                for (unifiedFormat employee : employeelist) {
                    if (employee.getSalary() > maxSalary) {
                        maxSalary = employee.getSalary();
                        highestSalaryEmployee = employee;
                    }
                }

                if (highestSalaryEmployee != null) {
                    System.out.println("Employee with the highest salary: " +
                            Objects.requireNonNull(highestSalaryEmployee).getName() + " ($" + highestSalaryEmployee.getSalary() + ")");
                } else {
                    System.out.println("No employees found.");
                }

                // find which department has more employee
                Map<String, Integer> departmentCounts = new HashMap<>();

                for (unifiedFormat employee : employeelist) {
                    String department = employee.getDepartment();
                    departmentCounts.put(department, departmentCounts.getOrDefault(department, 0) + 1);
                }

                String highestDepartment = "";
                int highestCount = 0;

                for (Map.Entry<String, Integer> entry : departmentCounts.entrySet()) {
                    if (entry.getValue() > highestCount) {
                        highestCount = entry.getValue();
                        highestDepartment = entry.getKey();
                    }
                }

                System.out.println("Department with the highest employees: " + highestDepartment);


                // the of number M and F .
                Map<String, Integer> genderCountMap = new HashMap<>();

                for (unifiedFormat employee : employeelist) {
                    String gender = employee.getGender();
                    genderCountMap.put(gender, genderCountMap.getOrDefault(gender, 0) + 1);
                }


                for (Map.Entry<String, Integer> entry : genderCountMap.entrySet()) {
                    System.out.println("Gender: " + entry.getKey() + ", Count: " + entry.getValue());
                }


            }
        }
    }
}
