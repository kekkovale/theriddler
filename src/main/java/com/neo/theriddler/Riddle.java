package com.neo.theriddler;

public class Riddle {

    private String riddle;
    private String solution;

    public Riddle(String riddle, String solution) {
        this.riddle = riddle;
        this.solution = solution;
    }

    public Riddle(Riddle riddle) {
        this.riddle = this.getRiddle();
        this.solution = this.getSolution();
    }

    public String getSolution() {
        return solution;
    }

    public String getRiddle() {
        return riddle;
    }
}
