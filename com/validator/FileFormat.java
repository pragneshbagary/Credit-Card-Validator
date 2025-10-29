package com.validator;

import javax.xml.parsers.ParserConfigurationException;

public class FileFormat {
    FileStrategy fileStrategy;

    public FileStrategy parse(String inputFile) throws ParserConfigurationException {
        String input_file_extension = inputFile;
        if(input_file_extension.endsWith(".csv")){
            fileStrategy =  new CsvParser();
        } else if (input_file_extension.endsWith(".xml")){
            fileStrategy =  new XmlParser();
        } else if (input_file_extension.endsWith(".json")) {
            fileStrategy = new JsonParser();
        }
        return fileStrategy;
    }
}
