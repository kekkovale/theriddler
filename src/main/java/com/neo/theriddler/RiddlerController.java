package com.neo.theriddler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RiddlerController {

    @RequestMapping("/get-riddle")
    public Riddle getRiddle() {

        RiddlerExtractor riddlerExtractor = new RiddlerExtractor();
        final Riddle riddle = riddlerExtractor.extractRiddle();

        return riddle;
    }

    @RequestMapping("/get-riddles")
    public List<Riddle> getRiddles() {

        RiddlerExtractor riddlerExtractor = new RiddlerExtractor();
        final List<Riddle> riddles = riddlerExtractor.extractRiddles(10);

        return riddles;
    }
}
