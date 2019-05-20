package ua.lviv.iot.gameroom.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import ua.lviv.iot.gameroom.exceptions.ChildNotFoundException;
import ua.lviv.iot.gameroom.models.Child;
import ua.lviv.iot.gameroom.repositories.ChildRepository;

import java.util.List;

@RestController
public class MainController {

    private ChildRepository repository;

    public MainController(ChildRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/children")
    public List<Child> getAllChildren() {
        return (List<Child>) repository.findAll();
    }

    @PostMapping("/children")
    public Child newChild(@RequestBody Child newChild) {
        return repository.save(newChild);
    }

    @GetMapping("/children/{id}")
    public Child one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ChildNotFoundException(id));
    }

    @PutMapping("/children/{id}")
    public Child replaceChild(@RequestBody Child newChild, @PathVariable Long id) {
        return repository.findById(id)
                .map(child -> {
                    child.setAge(newChild.getAge());
                    child.setName(newChild.getName());
                    child.setParentName(newChild.getParentName());
                    return repository.save(child);
                })
                .orElseGet(() -> {
                    newChild.setId(id);
                    return repository.save(newChild);
                });
    }

    @DeleteMapping("children/{id}")
    public void deleteChild(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
