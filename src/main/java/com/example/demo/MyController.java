package com.example.demo;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class MyController {
    private int counter = 0;
    private List<Integer> counterList = new ArrayList<>();

    @GetMapping("/message")
    public String getMessage() {
        String[] messages = {"мы вам не рады", "добро пожаловать"};
        return messages[new Random().nextInt(messages.length)];
    }

    @GetMapping("/count")
    public void incrementCounter() {
        counter++;
    }

    @GetMapping("/info")
    public int getCounter() {
        return counter;
    }

    @GetMapping("/save-and-reset")
    public void saveAndResetCounter() {
        counterList.add(counter);
        counter = 0;
    }
    /*
    Создать spring-приложение с контроллером

Создать для него 5 endpoint (входных точек):
get /message - случайным образом выбирается фраза из двух "мы вам не рады" и "добро пожаловать"


get /count - увеличить счетчик на один (можно завести поле в классе и изменять его)


get /info - показать актуальное значение счетчика (в браузере)


get /save-and-reset - записать актуальное значение счетчика в список, обнулить счетчик


get /list - показать список, в который записывали значения счетчика


     */

    @GetMapping("/list")
    public List<Integer> getCounterList() {
        return counterList;
    }
}