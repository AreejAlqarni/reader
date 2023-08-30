package com.stc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class csvReader implements stcReader{
    @Override
    public ArrayList<unifiedFormat> parsee(File pathFile ) throws FileNotFoundException {
        ArrayList<unifiedFormat> employeelist = new ArrayList<>();
        File employeefile = new File(pathFile.toURI());
        Scanner SCAN = new Scanner(employeefile);
        {
            while (SCAN.hasNextLine()) {
                //String line = SCAN.nextLine();
                //String[] elements = line.split(",");
                String[] elements = SCAN.nextLine().split(",");
                if (elements.length >= 4) {
                    String name = elements[0];
                    int salary = Integer.parseInt(elements[1]);
                    String department = elements[2];
                    String gender = elements[3];

                    unifiedFormat imp = new unifiedFormat(name, salary, department, gender);
                    employeelist.add(imp);
                    System.out.println(employeelist);

                }
            }
        }


        return employeelist;
    }


}


