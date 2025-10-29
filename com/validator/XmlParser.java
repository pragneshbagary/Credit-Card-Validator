package com.validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XmlParser implements FileStrategy{


    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    private ArrayList<String> test = new ArrayList<>();
    private ArrayList<String> cards = new ArrayList<>();
    String cardType;

    public XmlParser() throws ParserConfigurationException {
    }


    @Override
    public void getData(String file) throws IOException, SAXException {
        try {
            File input = new File(file);
            Document doc = db.parse(input);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("CARD");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    test.add(element.getElementsByTagName("CARD_NUMBER").item(0).getTextContent());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        this.processData(test);
    }

    @Override
    public void processData(ArrayList<String> test) throws IOException {
        ValidatorFactory validatorFactory =  new ValidatorFactory();
        for(String str : test){
//            System.out.println(str);
//            if(str ==null) str = "&";
            Validator card = validatorFactory.checkCard(str);
            cardType = card.validCard();
            cards.add(cardType);
        }
        this.writeData(test,cards);
    }

    @Override
    public void writeData(ArrayList<String> test, ArrayList<String> cards) throws IOException {

        File xml = new File("test.xml");
        FileWriter myWriter = new FileWriter("test.xml");
        Document dom;

        Element t = null;
        try{
            dom = db.newDocument();
            Element rootEle = dom.createElement("Cards");
            for(int i =0;i<test.size();i++) {
                Element cardnumber = null;
                Element card = null;
                card = dom.createElement("card");
                cardnumber = dom.createElement("CardNumber");
                cardnumber.appendChild(dom.createTextNode(test.get(i)));
                card.appendChild(cardnumber);
                cardnumber = dom.createElement("CardType");
                cardnumber.appendChild(dom.createTextNode(cards.get(i)));
                card.appendChild(cardnumber);
                rootEle.appendChild(card);
            }

            dom.appendChild(rootEle);

                try {
                    Transformer tr = TransformerFactory.newInstance().newTransformer();
                    tr.setOutputProperty(OutputKeys.INDENT, "yes");
                    tr.setOutputProperty(OutputKeys.METHOD, "xml");
                    tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

                    tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                    // send DOM to file
                    tr.transform(new DOMSource(dom),
                            new StreamResult(new FileOutputStream(xml)));

                } catch (TransformerException te) {
                    System.out.println(te.getMessage());
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }



        }catch (Exception e){
            e.printStackTrace();
        }


//

    }
}
