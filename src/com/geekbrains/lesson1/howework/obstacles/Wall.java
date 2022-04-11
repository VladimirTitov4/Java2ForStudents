package com.geekbrains.lesson1.howework.obstacles;

import com.geekbrains.lesson1.howework.participant.Participant;

public class Wall implements Obstacle {

    private final int height;

    public Wall(int length) {
        this.height = length;
    }

    @Override
    public boolean passObstacleBy(Participant participant) {
        if (participant.jump() > height) {
            System.out.printf("Участник %s успешно перепрыгнул через стену высотой %d м %n", participant, height);
            return true;
        }
        System.out.printf("Участник %s НЕ СМОГ ПЕРЕПРЫГНУТЬ через стену высотой %d м %n", participant, height);
        return false;
    }
}
