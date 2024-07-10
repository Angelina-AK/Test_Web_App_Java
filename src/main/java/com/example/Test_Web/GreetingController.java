package com.example.Test_Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

// Контроллер, метод, описывающий действия при запросе с url /greeting
// параметры: name (необязательный с дефолтным значением) и модель model
@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name); // передаем атрибуту модели name значение параметра
        return "greeting"; // В итоге возвращаем шаблон с именем greeting, шаблны ищутся в папке templates
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("some","hello, letsCode");
        return "main";
    }

}
