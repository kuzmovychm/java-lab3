package ua.lviv.iot.managers;

import ua.lviv.iot.models.GameRoom;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class GameRoomWriter {

    public void writeToFile(List<GameRoom> gameRooms, File file) throws IOException {

        try (FileOutputStream fos = new FileOutputStream(file);
             OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
             BufferedWriter buffWriter = new BufferedWriter(osw);) {

            for (int i = 0; i < gameRooms.size(); i++) {
                buffWriter.write(gameRooms.get(i).getHeaders());
                buffWriter.newLine();
                buffWriter.write(gameRooms.get(i).toCSV());

                if (i < gameRooms.size() - 1) {
                    buffWriter.newLine();
                }
            }

        }

    }

}
