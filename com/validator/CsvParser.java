package com.validator;

import java.io.*;
import java.util.ArrayList;

public class CsvParser implements FileStrategy{
    String line = "";
    String splitBy = ",";
    String cardType;
    private ArrayList<String> cards = new ArrayList<>();
    private ArrayList<String> test = new ArrayList<>();
//    public void csvParser() throws IOException {
//        File csvfile = new File("/Users/pragneshbagary/IdeaProjects/CrediCardProblem/outputfiles/test.csv");
//        csvfile.createNewFile();
//    }




    @Override
    public void getData(String file) throws FileNotFoundException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null) {
//                System.out.println("test");
                test.add(line.split(splitBy)[0]);
//                System.out.println(line.split(splitBy)[0]);
            }
            this.processData(test);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void processData(ArrayList<String> test) throws IOException {
//        System.out.println(test.get(0));
//        for
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
    public void writeData(ArrayList<String> test, ArrayList<String> cards ) throws IOException {
        try{
            File csvfile = new File("test.csv");
            csvfile.createNewFile();
            FileWriter myWriter = new FileWriter("test.csv");
            BufferedWriter bw  = new BufferedWriter(myWriter);
            for(int i = 0; i<test.size();i++){
                bw.write(test.get(i)+","+cards.get(i));
                bw.newLine();
            }
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
