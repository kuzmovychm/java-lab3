package ua.lviv.iot.gameroom.exceptions;

public class ChildNotFoundException extends RuntimeException {

    public ChildNotFoundException(Long id) {
        super("Could not find child with id " + id);
    }
}
