package ua.lviv.iot.managers;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.models.AgeGroup;
import ua.lviv.iot.models.GameRoom;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameRoomWriterTest {

    @Test
    void writeToFile() {
        File file = new File("output.csv");

        GameRoomManager manager = new GameRoomManager();

        GameRoom gameRoom1 = new GameRoom();
        gameRoom1.setPlaygroundArea(123);
        gameRoom1.setPresentChildren(4);
        gameRoom1.setMoneyAvailable(231);
        gameRoom1.setAgeGroup(AgeGroup.PRESCHOOLERS);
        manager.addGameRoom(gameRoom1);

        GameRoom gameRoom2 = new GameRoom();
        gameRoom2.setPlaygroundArea(143);
        gameRoom2.setPresentChildren(2);
        gameRoom2.setMoneyAvailable(261);
        gameRoom2.setAgeGroup(AgeGroup.PRESCHOOLERS);
        manager.addGameRoom(gameRoom2);

        GameRoom gameRoom3 = new GameRoom();
        gameRoom3.setPlaygroundArea(723);
        gameRoom3.setPresentChildren(14);
        gameRoom3.setMoneyAvailable(2651);
        gameRoom3.setAgeGroup(AgeGroup.PRESCHOOLERS);
        manager.addGameRoom(gameRoom3);

        GameRoom gameRoom4 = new GameRoom();
        gameRoom4.setPlaygroundArea(653);
        gameRoom4.setPresentChildren(7);
        gameRoom4.setMoneyAvailable(2711);
        gameRoom4.setAgeGroup(AgeGroup.PRESCHOOLERS);
        manager.addGameRoom(gameRoom4);

        try {
            (new GameRoomWriter()).writeToFile(manager.getGameRooms(), file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotEquals(0, file.length());
    }
}