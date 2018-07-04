package com.neo.theriddler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class RiddlerExtractor {

    public Riddle extractRiddle(){

        int riddleNumber = generateRandomValue();
        return extractRiddle(riddleNumber);

    }

    private int generateRandomValue() {
        return (int) (Math.random() * (6000 - 1)) + 1;
    }

    public List<Riddle> extractRiddles(int numberOfRiddleToExtract){
        List<Riddle> riddles = new LinkedList<>();

        while(numberOfRiddleToExtract != 0){
            final Riddle riddle = this.extractRiddle(this.generateRandomValue());

            if (riddle != null){
                riddles.add(riddle);
                --numberOfRiddleToExtract;
            }
        }

        return riddles;
    }

    private Riddle extractRiddle(int riddleNumber){
        Riddle riddle = null;
        String riddleText = null;
        String riddleSolutionText = null;

        try {
            Document doc = Jsoup.connect("https://www.riddles.com/riddle/" + riddleNumber)
                    .userAgent("Mozilla")
                    .timeout(3000)
                    .get();

            Elements riddleBlock = doc.select(".orange_dk_blockquote");

            if (!riddleBlock.isEmpty()){
                riddleText = riddleBlock.get(0).text();
            } else {
                //exception
            }

            Elements riddleSolutionBlock = doc.select(".dark_purple_blockquote");

            if (!riddleSolutionBlock.isEmpty()){
                riddleSolutionText = riddleSolutionBlock.get(0).text();
            } else {
                //exception
            }

            riddle = new Riddle(riddleNumber, riddleText, riddleSolutionText);
            StoreRiddles.storeRiddle(riddle);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return riddle;

    }

}
