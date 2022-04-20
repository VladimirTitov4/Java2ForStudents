package com.company;

public class Cat {
    int runningSkill;
    int jumpingSkill;
    String name;

    public Cat(int runningSkill, int jumpingSkill, String name){
        if (runningSkill >= 0) { this.runningSkill = runningSkill; }
        else { System.out.println("Введены некорректные данные"); }
        if (jumpingSkill >= 0) { this.jumpingSkill = jumpingSkill; }
        else { System.out.println("Введены некорректные данные"); }
        this.name = name;
    }
    public int    getRunningSkill() { return runningSkill; }
    public int    getJumpingSkill(){ return jumpingSkill; }
    public String getName()         { return name; }

    public boolean running(Treadmill treadmill){
        if(treadmill.getDistance() <= runningSkill){ return true; }
        else{ return false; }
    }
    public boolean jumping(Wall wall){
        if(wall.getHeight() <= jumpingSkill){ return true; }
        else{ return false; }
    }
}
