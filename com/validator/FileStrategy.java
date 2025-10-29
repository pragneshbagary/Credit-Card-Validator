package com.validator;

import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

public interface FileStrategy {
    public void getData(String file) throws IOException, SAXException, ParseException;
    public void processData(ArrayList<String> test) throws IOException;
    public void writeData(ArrayList<String> test, ArrayList<String> cards) throws IOException;
}
