package com.example.scorekepperapp;

public class Team {
    public static int HIGH_SCORE = 0;
    private String name;
    private int score;

    public Team(String name)
    {
        this.name = name;
        this.score = 0;
    }

    public Team(String name, int score){
        this.name = name;
        this.score = score;
    }

    public void incrementScore(){
        this.score += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
