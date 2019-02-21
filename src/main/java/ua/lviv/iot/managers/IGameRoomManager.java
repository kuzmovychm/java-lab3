package main.java.ua.lviv.iot.managers;


import main.java.ua.lviv.iot.models.GameRoom;
import main.java.ua.lviv.iot.models.Toy;

import java.util.List;

public interface IGameRoomManager {

    public void addGameRoom(GameRoom gameRoom);
    public void buyToy(GameRoom gameRoom ,Toy toy);
    public void sortToysByPrice(List<Toy> toys, SortOrder sortOrder);
    public void sortToysByType(List<Toy> toys);

}
