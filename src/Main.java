import managers.GameRoomManager;
import models.*;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Toy barbie = new Doll(110, Size.MEDIUM, "Barbie");
        Toy mcQueen = new Car(132, Size.MEDIUM, "sport");
        Toy cubes = new Figures(90, Size.SMALL, 7, "cubes");
        Toy ball = new Ball(60, Size.SMALL, "red");

        GameRoomManager gameRoomManager = new GameRoomManager();
        GameRoom gameRoom = new GameRoom(67, AgeGroup.PRESCHOOLERS, 3021);
        gameRoomManager.addGameroom(gameRoom);

        gameRoomManager.buyToy(gameRoomManager.getGameRooms().get(0), barbie);
        gameRoomManager.buyToy(gameRoomManager.getGameRooms().get(0), mcQueen);
        gameRoomManager.buyToy(gameRoomManager.getGameRooms().get(0), cubes);
        gameRoomManager.buyToy(gameRoomManager.getGameRooms().get(0), ball);

        System.out.println(gameRoomManager.getGameRooms().get(0).getToys());
        gameRoomManager.sortToysByPrice(gameRoomManager.getGameRooms().get(0).getToys());
        //System.out.println(gameRoomManager.getGameRooms().get(0).getToys());

        System.out.println(gameRoomManager.getGameRooms().get(0).getToys());
        gameRoomManager.sortToysByType(gameRoomManager.getGameRooms().get(0).getToys());
        System.out.println(gameRoomManager.getGameRooms().get(0).getToys());

    }

}
