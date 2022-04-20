package com.company;

public class Main {
    public interface Actions{
        boolean running (Treadmill treadmill);
        boolean jumping(Wall wall);
    }
    public static void main(String[] args) {
        Object [] obstacleArray = new Object[6];
        obstacleArray[0] = new Treadmill(100);
        obstacleArray[1] = new Treadmill(200);
        obstacleArray[2] = new Wall(1);
        obstacleArray[3] = new Wall(2);
        obstacleArray[4] = new Treadmill(323);
        obstacleArray[5] = new Wall(3);

        Object [] participantsArray = new Object[3];
        participantsArray[0] = new Human(200, 1, "Лорд Вейдер");
        participantsArray[1] = new Cat(100,2,"Мурзик");
        participantsArray[2] = new Robot(1000,4,"Робонатор");


        for(int i = 0; i < participantsArray.length; i++) {
            int j = 0;
            while(true) {
                if(obstacleArray[j] instanceof Treadmill){
                    Treadmill treadmill = (Treadmill)obstacleArray[j];
                    if (running(participantsArray[i], treadmill)){
                        System.out.println("Следующее препятсвие");
                    }
                    else{
                        break;
                    }
                }
                else{
                    Wall wall = (Wall)obstacleArray[j];
                    if (running(participantsArray[i], wall)){
                        System.out.println("Следующее препятсвие");
                    }
                    else{
                        break;
                    }
                }
                j++;
                if(j == obstacleArray.length) {
                    System.out.println("Участник прошел все препятствия!");
                    break;
                }
            }
        }
    }
    public static boolean running(Object participant, Treadmill treadmill){
        if (participant instanceof Human) {
            Human human = (Human)participant;
                if(human.running(treadmill)){
                    System.out.println("Человек " + human.getName() + " преодолел препятствие");
                    System.out.println("Дистанця" + treadmill.getDistance());
                    return true;
                }
                else{
                    System.out.println("Человек " + human.getName() + " выбыл");
                    System.out.println("Дистанця" + treadmill.getDistance());
                    return false;
                }
        }
        if (participant instanceof Cat) {
            Cat cat = (Cat)participant;
            if(cat.running(treadmill)){
                System.out.println("Кот " + cat.getName() + " преодолел препятствие");
                System.out.println("Дистанця" + treadmill.getDistance());
                return true;
            }
            else{
                System.out.println("Кот " + cat.getName() + " выбыл");
                System.out.println("Дистанця" + treadmill.getDistance());
                return false;
            }
        }
        if (participant instanceof Robot) {
            Robot robot = (Robot)participant;
            if(robot.running(treadmill)){
                System.out.println("Робот " + robot.getName() + " преодолел препятствие");
                System.out.println("Дистанця" + treadmill.getDistance());
                return true;
            }
            else{
                System.out.println("Робот " + robot.getName() + " выбыл");
                System.out.println("Дистанця" + treadmill.getDistance());
                return false;
            }
        }
        return false;
    }
    public static boolean running(Object participant, Wall wall){
        if (participant instanceof Human) {
            Human human = (Human)participant;
            if(human.jumping(wall)){
                System.out.println("Человек " + human.getName() + " преодолел препятствие");
                System.out.println("Высота" + wall.getHeight());
                return true;
            }
            else{
                System.out.println("Человек " + human.getName() + " выбыл");
                System.out.println("Высота" + wall.getHeight());
                return false;
            }
        }
        if (participant instanceof Cat) {
            Cat cat = (Cat)participant;
            if(cat.jumping(wall)){
                System.out.println("Кот " + cat.getName() + " преодолел препятствие");
                System.out.println("Высота" + wall.getHeight());
                return true;
            }
            else{
                System.out.println("Кот " + cat.getName() + " выбыл");
                System.out.println("Высота" + wall.getHeight());
                return false;
            }
        }
        if (participant instanceof Robot) {
            Robot robot = (Robot)participant;
            if(robot.jumping(wall)){
                System.out.println("Робот " + robot.getName() + " преодолел препятствие");
                System.out.println("Высота" + wall.getHeight());
                return true;
            }
            else{
                System.out.println("Робот " + robot.getName() + " выбыл");
                System.out.println("Высота" + wall.getHeight());
                return false;
            }
        }
        return false;
    }
}
