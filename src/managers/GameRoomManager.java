package managers;

import models.GameRoom;
import models.Toy;

import java.util.*;

public class GameRoomManager implements IGameRoomManager {

    List<GameRoom> gameRooms = new LinkedList<>();

    public GameRoomManager() {
    }

    public GameRoomManager(List<GameRoom> gameRooms) {
        this.gameRooms = gameRooms;
    }

    public List<GameRoom> getGameRooms() {
        return gameRooms;
    }

    public void setGameRooms(List<GameRoom> gameRooms) {
        this.gameRooms = gameRooms;
    }

    @Override
    public void addGameroom(GameRoom gameRoom) {
        this.gameRooms.add(gameRoom);
    }

    @Override
    public void buyToy(GameRoom gameRoom, Toy toy) {
        if (gameRoom.getMoneyAvailable() > toy.getPrice()) {
            gameRoom.addToy(toy);
        }
    }

    public void sortToysByPrice(List<Toy> toys) {
        toys.sort((Toy o1, Toy o2) -> (int) (o1.getPrice() - o2.getPrice()));
    }

    public void sortToysByType(List<Toy> toys) {
        toys.sort((Toy o1, Toy o2)->o1.getToyType().compareTo(o2.getToyType()));
    }
}
