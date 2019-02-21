package ua.lviv.iot.managers;

import ua.lviv.iot.models.GameRoom;
import ua.lviv.iot.models.Toy;

import java.util.List;

public interface IGameRoomManager {

    void addGameRoom(GameRoom gameRoom);

    void buyToy(GameRoom gameRoom, Toy toy);

    void sortToysByPrice(List<Toy> toys, SortOrder sortOrder);

    void sortToysByType(List<Toy> toys);

}
