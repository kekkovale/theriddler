package com.neo.theriddler;

public class Riddler {

    private String riddle;
    private String solution;

    public Riddler(String riddle, String solution) {
        this.riddle = riddle;
        this.solution = solution;
    }

    public Riddler(Riddler riddler) {
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
