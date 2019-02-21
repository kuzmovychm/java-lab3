package main.java.ua.lviv.iot.managers;

import main.java.ua.lviv.iot.models.GameRoom;
import main.java.ua.lviv.iot.models.Toy;

import java.util.*;

public class GameRoomManager implements IGameRoomManager {

    private List<GameRoom> gameRooms = new LinkedList<>();

    public GameRoomManager() {
    }

    public GameRoomManager(final List<GameRoom> gameRooms) {
        this.gameRooms = gameRooms;
    }

    public final List<GameRoom> getGameRooms() {
        return gameRooms;
    }

    public final void setGameRooms(final List<GameRoom> gameRooms) {
        this.gameRooms = gameRooms;
    }

    @Override
    public void addGameRoom(final GameRoom gameRoom) {
        this.gameRooms.add(gameRoom);
    }

    @Override
    public void buyToy(final GameRoom gameRoom, final Toy toy) {
        if (gameRoom.getMoneyAvailable() > toy.getPrice()) {
            gameRoom.addToy(toy);
        }
    }

    public void sortToysByPrice(final List<Toy> toys, final SortOrder sortOrder) {
        if (sortOrder == SortOrder.ASCENDING) {
            toys.sort((Toy o1, Toy o2) -> (int) (o1.getPrice() - o2.getPrice()));
        } else {
            toys.sort((Toy o1, Toy o2) -> (int) (o2.getPrice() - o1.getPrice()));
        }

    }

    public void sortToysByType(final List<Toy> toys) {
        toys.sort((Toy o1, Toy o2)->o1.getToyType().compareTo(o2.getToyType()));
    }
}
