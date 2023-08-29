/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.stc.Handler;
import com.stc.stcReader;

import java.io.File;

/**
 *
 * @author HP
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File folder = new File( "C:\\Users\\HP\\Desktop\\files");



        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
                    stcReader reader = Handler.getstcReader(fileExtension);
                    reader.parsee(new File(file.getPath()));
                }
            }
        }


    }
    
}
