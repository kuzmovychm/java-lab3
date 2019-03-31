package ua.lviv.iot.managers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.managers.GameRoomManager;
import ua.lviv.iot.managers.SortOrder;
import ua.lviv.iot.models.*;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameRoomManagerTest {

    private GameRoomManager gameRoomManager;
    private GameRoom gameRoom;

    @BeforeEach
    public void setUp() {

        gameRoomManager = new GameRoomManager();
        gameRoom = new GameRoom(67, AgeGroup.PRESCHOOLERS, 3021);
        gameRoomManager.addGameRoom(gameRoom);

        Toy mcQueen = new Car(132, Size.MEDIUM, "sport");
        Ball ball = new Ball(60, Size.SMALL, "red");
        Toy barbie = new Doll(110, Size.MEDIUM, "Barbie");
        Toy cubes = new Figures(90, Size.SMALL, 7, "cubes");

        gameRoomManager.buyToy(gameRoom, cubes);
        gameRoomManager.buyToy(gameRoom, mcQueen);
        gameRoomManager.buyToy(gameRoom, barbie);
        gameRoomManager.buyToy(gameRoom, ball);

    }

    @Test
    void addGameRoom() {
        int expected = gameRoomManager.getGameRooms().size() + 1;
        gameRoomManager.addGameRoom(new GameRoom());
        int actual = gameRoomManager.getGameRooms().size();
        assertEquals(expected, actual);
    }

    @Test
    void addGameRoomWithPassingNull() {
        assertThrows(NullPointerException.class,
                () -> gameRoomManager.addGameRoom(null),
                "Expected addGameRoom() to throw NullPointerException but it did not"
                );
    }

    @Test
    void buyToy() {
        int expected = gameRoom.getToys().size() + 1;
        gameRoomManager.buyToy(gameRoom, new Car());
        int actual = gameRoom.getToys().size();
        assertEquals(expected, actual);
    }

    @Test
    void buyToyWithPassingNull() {
        assertThrows(NullPointerException.class,
                () -> gameRoomManager.buyToy(null, null),
                "Expected buyToy() to throw NullPointerException but it did not"
        );
    }

    @Test
    void sortToysByPriceByAscending() {
        gameRoomManager.sortToysByPrice(gameRoom.getToys(), SortOrder.ASCENDING);
        assertEquals(60 , gameRoom.getToys().get(0).getPrice());
        assertEquals(90 , gameRoom.getToys().get(1).getPrice());
        assertEquals(110, gameRoom.getToys().get(2).getPrice());
        assertEquals(132, gameRoom.getToys().get(3).getPrice());
    }

    @Test
    void sortToysByPriceByDescending() {
        gameRoomManager.sortToysByPrice(gameRoom.getToys(), SortOrder.DESCENDING);
        assertEquals(132, gameRoom.getToys().get(0).getPrice());
        assertEquals(110, gameRoom.getToys().get(1).getPrice());
        assertEquals(90 , gameRoom.getToys().get(2).getPrice());
        assertEquals(60 , gameRoom.getToys().get(3).getPrice());
    }

    @Test
    void sortToysByPriceByAscendingPassingEmptyList() {
        List<Toy> emptyList = new LinkedList<>();
        gameRoomManager.sortToysByPrice(emptyList, SortOrder.ASCENDING);
        assertEquals(0, emptyList.size());
    }

    @Test
    void sortToysByPriceByDescendingPassingEmptyList() {
        List<Toy> emptyList = new LinkedList<>();
        gameRoomManager.sortToysByPrice(emptyList, SortOrder.DESCENDING);
        assertEquals(0, emptyList.size());
    }

    @Test
    void sortToysByPriceByAscendingPassingNull() throws NullPointerException {
        assertThrows(NullPointerException.class,
                () -> gameRoomManager.sortToysByPrice(null, SortOrder.ASCENDING),
                "Expected sortToysByPrice() to throw NullPointerException but it did not");
    }

    @Test
    void sortToysByPriceByDescendingPassingNull() {
        assertThrows(NullPointerException.class,
                () -> gameRoomManager.sortToysByPrice(null, SortOrder.DESCENDING),
                "Expected sortToysByPrice() to throw NullPointerException but it did not");
    }

    @Test
    void sortToysByType() {
        gameRoomManager.sortToysByType(gameRoom.getToys());
        assertEquals(ToyType.BALL_SMALL, gameRoom.getToys().get(0).getToyType());
        assertEquals(ToyType.CAR_MEDIUM, gameRoom.getToys().get(1).getToyType());
        assertEquals(ToyType.DOLL_MEDIUM, gameRoom.getToys().get(2).getToyType());
        assertEquals(ToyType.FIGURES_SMALL, gameRoom.getToys().get(3).getToyType());
    }

    @Test
    void sortToysByTypePassingEmptyList() {
        List<Toy> emptyList = new LinkedList<>();
        gameRoomManager.sortToysByType(emptyList);
        assertEquals(0, emptyList.size());
    }

    @Test
    void sortToysByTypePassingNull() {
        assertThrows(NullPointerException.class,
                () -> gameRoomManager.sortToysByType(null),
                "Expected sortToysByType() to throw NullPointerException but it did not");
    }
}