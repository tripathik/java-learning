package com.iintelliguru.core.exception;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
@Slf4j
public class ExceptionUnderstanding {
    private void handleCheckedException() throws CustomException {
        try {
            File file = new File("file1.txt");
            FileReader fileReader = new FileReader(file);
            int read = fileReader.read();
            log.info(String.format("The result after file has been read: %s",read));
        } catch (FileNotFoundException e) {
            log.error("The given file is not found", e);
        }catch (IOException e){
            throw new CustomException("IOException occurred: ",e);
        }

    }

    private void handleUnCheckedException(){
        String value = null;
        try {
            int stringLength = value.length();
            log.info(String.format("Length Value is: %s", stringLength));
        }catch (NullPointerException e){
            log.error(String.format("Null pointer Exception occurred: %s:", "Exception"),e);
        }
    }
}
