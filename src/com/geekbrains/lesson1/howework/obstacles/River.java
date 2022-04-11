package com.geekbrains.lesson1.howework.obstacles;

import com.geekbrains.lesson1.howework.participant.Participant;

public class River implements Obstacle{

    private final int width;

    public River(int width) {
        this.width = width;
    }

    @Override
    public boolean passObstacleBy(Participant participant) {
        if (participant.swim() > width) {
            System.out.printf("Участник %s успешно переплыл через реку шириной %d метров %n", participant, width);
            return true;
        }
        System.out.printf("Участник %s НЕ СМОГ ПЕРЕПЛЫТЬ через реку шириной %d м %n", participant, width);
        return false;
    }
}
