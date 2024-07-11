package com.example.Test_Web;

import com.example.Test_Web.domain.Employee;
import com.example.Test_Web.repos.EmploRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Controller
public class GreetingController {

    // Конструкция для таблицы сотрудников
    @Autowired
    private EmploRepo emploRepo;

    // Метод, описывающий действия при запросе с url /greeting
    // параметры: name (необязательный с дефолтным значением) и модель model
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name); // передаем атрибуту модели name значение параметра
        return "greeting"; // В итоге возвращаем шаблон с именем greeting, шаблны ищутся в папке templates
    }

    // GET - Метод для главное страницы - список сотрудников
    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Employee> employees = emploRepo.findAll();
        model.put("Employees",employees);

        return "main";
    }

    // POST - Метода для главной страницы - добавление сотрудника
    @PostMapping
    public String add(
            @RequestParam String Name,      // Наименование параметров берется из значений переменных по умолчанию
            @RequestParam String Surname,
            @RequestParam String Otchestvo,
            Map<String, Object> model) {

        Employee  employee = new Employee(Name, Surname, Otchestvo);
        emploRepo.save(employee);

        Iterable<Employee> employees = emploRepo.findAll();
        model.put("Employees",employees);

        return "main";
    }

    // POST - Метод для поиска сотрудника
    @PostMapping("filter")
    public String filter(
            @RequestParam String filter,
            Map<String, Object> model) {

        Iterable<Employee> employees;
        // Если введено значение для поиска, то возвращаем найденное
        if (filter != null && !filter.isEmpty()) {
           employees = emploRepo.findBySurnameContaining(filter);
        // В других случаях возвращаем полный список
        } else {
            employees = emploRepo.findAll();
        }
        model.put("Employees", employees);
        return "main";
    }


}
