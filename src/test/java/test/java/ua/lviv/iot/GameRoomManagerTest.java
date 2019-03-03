package test.java.ua.lviv.iot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.managers.GameRoomManager;
import ua.lviv.iot.models.*;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameRoomManagerTest {

    /*
    * @Test
   public void testFindShipsWithNegativeTonnage() {
       assertThrows(IllegalArgumentException.class,
               () -> transportationManager.findShipsWithTonnageBiggerThan(-10),
               "Expected doThing() to throw, but it didn't");
   }*/

    //throw new IllegalArgumentException("msg");

    //private List<GameRoom> gameRooms;
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
    void sortToysByPrice() {
    }

    @Test
    void sortToysByType() {
    }
}