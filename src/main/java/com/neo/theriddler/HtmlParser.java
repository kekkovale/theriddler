package com.neo.theriddler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HtmlParser {

    public Riddler generateRiddle(){

        int riddleNumber = generateRandomValue();
        return extractRiddle(riddleNumber);

    }

    private int generateRandomValue() {
        return (int) (Math.random() * (6000 - 1)) + 1;
    }

    private Riddler extractRiddle(int riddleNumber){
        Riddler riddle = null;
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

            riddle = new Riddler(riddleText, riddleSolutionText);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return riddle;

    }

}
