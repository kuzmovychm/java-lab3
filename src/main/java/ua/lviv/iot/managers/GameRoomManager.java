package ua.lviv.iot.managers;

import ua.lviv.iot.models.GameRoom;
import ua.lviv.iot.models.Toy;

import java.util.LinkedList;
import java.util.List;

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
    public void addGameRoom(final GameRoom gameRoom) throws NullPointerException {
        if (gameRoom == null) {
            throw new NullPointerException();
        }
        this.gameRooms.add(gameRoom);
    }

    @Override
    public void buyToy(final GameRoom gameRoom, final Toy toy) throws NullPointerException {
        if (gameRoom == null || toy == null) {
            throw new NullPointerException();
        }
        if (gameRoom.getMoneyAvailable() > toy.getPrice()) {
            gameRoom.addToy(toy);
        }
    }

    public void sortToysByPrice(final List<Toy> toys, final SortOrder sortOrder) throws NullPointerException {
        if (toys == null || sortOrder == null) {
            throw new NullPointerException();
        }
        if (sortOrder == SortOrder.ASCENDING) {
            toys.sort((Toy o1, Toy o2) -> (int) (o1.getPrice() - o2.getPrice()));
        } else {
            toys.sort((Toy o1, Toy o2) -> (int) (o2.getPrice() - o1.getPrice()));
        }
    }

    public void sortToysByType(final List<Toy> toys) throws NullPointerException {
        if (toys == null) {
            throw new NullPointerException();
        }
        toys.sort((Toy o1, Toy o2) -> o1.getToyType().compareTo(o2.getToyType()));
    }
}
