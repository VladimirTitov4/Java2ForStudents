package com.geekbrains.lesson1.howework;

import com.geekbrains.lesson1.howework.obstacles.Obstacle;
import com.geekbrains.lesson1.howework.obstacles.River;
import com.geekbrains.lesson1.howework.obstacles.Track;
import com.geekbrains.lesson1.howework.obstacles.Wall;
import com.geekbrains.lesson1.howework.participant.Cat;
import com.geekbrains.lesson1.howework.participant.Human;
import com.geekbrains.lesson1.howework.participant.Participant;
import com.geekbrains.lesson1.howework.participant.Robot;

public class Homework2 {

    public static void main(String[] args) {
        Human human = new Human("Vladimir");
        Cat cat = new Cat("Max");
        Robot robot = new Robot("Robot");

        Track track = new Track(150);
        Wall wall = new Wall(15);
        River river = new River(200);

        Participant[] participants = {human, cat, robot};
        Obstacle[] obstacles = {track, wall, river};

        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.passObstacleBy(participant)) {
                    System.out.printf("Участник %s ВЫБЫВАЕТ из соревнований %n", participant);
                    break;
                }
            }
        }

    }
}
