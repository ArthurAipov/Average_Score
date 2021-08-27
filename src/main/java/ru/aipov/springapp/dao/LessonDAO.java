package ru.aipov.springapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.aipov.springapp.models.Lesson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class LessonDAO{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LessonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Lesson> index() {
        return jdbcTemplate.query("SELECT * FROM Lesson", new BeanPropertyRowMapper<>(Lesson.class));
    }

    public Lesson show(int id) {
        return jdbcTemplate.query("SELECT * FROM Lesson WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Lesson.class))
                .stream().findAny().orElse(null);
    }
}