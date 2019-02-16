package managers;


import models.GameRoom;
import models.Toy;

import java.util.List;

public interface IGameRoomManager {

    public void addGameroom(GameRoom gameRoom);
    public void buyToy(GameRoom gameRoom ,Toy toy);
    public void sortToysByPrice(List<Toy> toys);
    public void sortToysByType(List<Toy> toys);

}
