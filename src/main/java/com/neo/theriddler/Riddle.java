package com.neo.theriddler;

import javax.persistence.*;

@Entity
@Table(name = "riddle_table")
public class Riddle {

    @Id
    @Column(name="riddle_id")
    private Integer id;

    @Column(name="riddle")
    private String riddle;

    @Column(name="riddle_solution")
    private String solution;

    public Riddle(Integer id, String riddle, String solution) {
        this.id = id;
        this.riddle = riddle;
        this.solution = solution;
    }

    public Riddle(){

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
