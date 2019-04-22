package ua.lviv.iot.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.iot.models.Child;

public interface ChildRepository extends CrudRepository<Child, Integer> {
}
