package com.geekbrains.lesson1.howework.obstacles;

import com.geekbrains.lesson1.howework.participant.Participant;

public class Track implements Obstacle {

    private final int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public boolean passObstacleBy(Participant participant) {
        if (participant.run() > length) {
            System.out.printf("Участник %s успешно пробежал по дорожке длиной %d метров %n", participant, length);
            return true;
        }
        System.out.printf("Участник %s НЕ СМОГ ПРОБЕЖАТЬ по дорожке длиной %d м %n", participant, length);
        return false;
    }
}
