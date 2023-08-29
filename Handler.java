/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.stc.csvReader;
import com.stc.jsonReader;
import com.stc.stcReader;
import com.stc.xmlReader;

/**
 *
 * @author HP
 */
public class Handler {
    public static stcReader getstcReader(String filetype) {
        if (filetype.equalsIgnoreCase("xml")) {
            return new xmlReader();
        } else if (filetype.equalsIgnoreCase("csv")) {
            return new csvReader();
        } else if (filetype.equalsIgnoreCase("json")) {
            return new jsonReader();
        } else {
            return null;
        }
    }
    
}
