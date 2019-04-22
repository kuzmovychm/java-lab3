package ua.lviv.iot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.lviv.iot.models.Child;
import ua.lviv.iot.repositories.ChildRepository;

@Controller
@RequestMapping(path = "/demo")
public class MainController {

    @Autowired
    private ChildRepository childRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addNewChild(@RequestParam int age,
                                            @RequestParam String name,
                                            @RequestParam String parentName) {

        Child child = new Child();
        child.setAge(age);
        child.setName(name);
        child.setParentName(parentName);
        childRepository.save(child);

        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Child> getAllChildren() {

        return childRepository.findAll();
    }
}