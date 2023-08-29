/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Handler {
     public static stcReader getstcReader(String fileName) {
        if (fileName.endsWith(".xml")) {
            return new xmlReader();
        } else if (fileName.endsWith(".csv")) {
            return new csvReader();
        } else if (fileName.endsWith(".json")) {
            return new jsonReader();
        } else {
            return null;
        }
    }
    
}
