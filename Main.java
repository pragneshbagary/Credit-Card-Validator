import com.validator.FileFormat;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, ParseException {

//        CsvParser csvParser = new CsvParser();
//        csvParser.getData("/Users/pragneshbagary/IdeaProjects/CrediCardProblem/src/input_file.csv");

//        XmlParser xmlParser =  new XmlParser();
//        xmlParser.getData("/Users/pragneshbagary/IdeaProjects/CrediCardProblem/src/input_file.xml");

//        JsonParser jsonParser = new JsonParser();
//        jsonParser.getData("/Users/pragneshbagary/IdeaProjects/CrediCardProblem/src/input_file.json");
        String csvPath = "/Users/pragneshbagary/IdeaProjects/CrediCardProblem/src/input_file.xml";
//        String jsonPath = "/Users/pragneshbagary/IdeaProjects/CrediCardProblem/src/input_file.json";
//        String xmlPath = "/Users/pragneshbagary/IdeaProjects/CrediCardProblem/src/input_file.xml";

        FileFormat file = new FileFormat();
        file.parse(csvPath).getData(csvPath);


    }

}