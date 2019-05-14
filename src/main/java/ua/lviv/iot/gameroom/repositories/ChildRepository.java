package ua.lviv.iot.gameroom.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.iot.gameroom.models.Child;

public interface ChildRepository extends CrudRepository<Child, Integer> {
}
