package main.java.ua.lviv.iot;

import main.java.ua.lviv.iot.managers.GameRoomManager;
import main.java.ua.lviv.iot.managers.SortOrder;
import main.java.ua.lviv.iot.models.*;


public final class Main {

    public static void main(final String[] args) {

        Toy barbie = new Doll(110, Size.MEDIUM, "Barbie");
        Toy mcQueen = new Car(132, Size.MEDIUM, "sport");
        Toy cubes = new Figures(90, Size.SMALL, 7, "cubes");
        Ball ball = new Ball(60, Size.SMALL, "red");

        GameRoomManager gameRoomManager = new GameRoomManager();
        GameRoom gameRoom = new GameRoom(67, AgeGroup.PRESCHOOLERS, 3021);
        gameRoomManager.addGameRoom(gameRoom);

        gameRoomManager.buyToy(gameRoom, barbie);
        gameRoomManager.buyToy(gameRoom, mcQueen);
        gameRoomManager.buyToy(gameRoom, cubes);
        gameRoomManager.buyToy(gameRoom, ball);
        System.out.println(gameRoom.getToys());

        gameRoomManager.sortToysByPrice(gameRoom.getToys(), SortOrder.ASCENDING);
        System.out.println(gameRoomManager.getGameRooms().get(0).getToys());

        gameRoomManager.sortToysByPrice(gameRoom.getToys(), SortOrder.DESCENDING);
        System.out.println(gameRoom.getToys());

        gameRoomManager.sortToysByType(gameRoom.getToys());
        System.out.println(gameRoom.getToys());

    }

}
