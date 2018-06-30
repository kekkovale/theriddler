package com.neo.theriddler;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiddlerController {

    @RequestMapping("/get-riddle")
    public Riddler getRiddle() {

        HtmlParser htmlParser = new HtmlParser();
        final Riddler riddle = htmlParser.generateRiddle();

        return riddle;
    }
}
