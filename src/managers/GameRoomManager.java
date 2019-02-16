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

    @Override
    public void sortToysByPrice(List<Toy> toys) {
        Collections.sort(toys, new Comparator<Toy>() {
            @Override
            public int compare(Toy o1, Toy o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });

        toys.sort((Toy o1, Toy o2) -> (int) (o1.getPrice() - o2.getPrice()));
    }

    @Override
    public void sortToysByType(List<Toy> toys) {
        Collections.sort(toys, new Comparator<Toy>() {
            @Override
            public int compare(Toy o1, Toy o2) {
                return o1.getToyType().compareTo(o2.getToyType());
            }
        });

        //lambda
        toys.sort((Toy o1, Toy o2)->o1.getToyType().compareTo(o2.getToyType()));
    }
}
