package ua.lviv.iot.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameRoomTest {

    GameRoom gameRoom;

    @BeforeEach
    void setUp() {
        gameRoom = new GameRoom();

//        List<Toy> toys = new LinkedList<>();
//        List<Child> children = new LinkedList<>();

        gameRoom.setPlaygroundArea(29.2);
        gameRoom.setAgeGroup(AgeGroup.PRESCHOOLERS);

    }

    @Test
    void calculateMaximalNumberOfChildren() {
        assertEquals(7, gameRoom.calculateMaximalNumberOfChildren());
    }

    @Test
    void calculateFreePlaces() {
        for(int i = 0; i < 5; i++) {
            gameRoom.addChild(new Child());
        }
        assertEquals(2, gameRoom.calculateMaximalNumberOfChildren() - gameRoom.getPresentChildren());
    }

    @Test
    void addChild() {
        int expected = gameRoom.getChildren().size() + 1;
        gameRoom.getChildren().add(new Child());
        assertEquals(expected, gameRoom.getChildren().size());
    }

    @Test
    void removeChild() {
        Child child = new Child();
        gameRoom.addChild(child);
        int expected = gameRoom.getPresentChildren() - 1;
        gameRoom.removeChild(child);
        assertEquals(expected, gameRoom.getPresentChildren());
    }

    @Test
    void removeChildPassingWrongChild() {
        int expected = gameRoom.getChildren().size();
        gameRoom.removeChild(new Child());
        assertEquals(expected, gameRoom.getPresentChildren());
    }

    @Test
    void removeChildPassingNull() {
        int expected = gameRoom.getChildren().size();
        gameRoom.removeChild(null);
        assertEquals(expected, gameRoom.getPresentChildren());
    }

    @Test
    void addToy() {
        int expected = gameRoom.getToys().size() + 1;
        gameRoom.setMoneyAvailable(122);
        Toy ball = new Ball();
        ball.setPrice(23);
        gameRoom.addToy(ball);
        assertEquals(expected, gameRoom.getToys().size());
    }

    @Test
    void addToyPassingNull() {
        int expected = gameRoom.getToys().size();
        gameRoom.setMoneyAvailable(12);
        gameRoom.addToy(null);
        assertEquals(expected, gameRoom.getToys().size());
    }

    @Test
    void addTooExpensiveToy() {
        int expected = gameRoom.getToys().size();
        gameRoom.setMoneyAvailable(12);
        Toy ball = new Ball();
        ball.setPrice(23);
        gameRoom.addToy(ball);
        assertEquals(expected, gameRoom.getToys().size());
    }
}