package ru.aipov.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.aipov.springapp.dao.LessonDAO;

@Controller
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonDAO lessonDAO;

    @Autowired
    public LessonsController(LessonDAO lessonDAO) {
        this.lessonDAO = lessonDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("lessons", lessonDAO.index());
        return "lessons/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("lesson", lessonDAO.show(id));
        return "lessons/show";
    }
}
