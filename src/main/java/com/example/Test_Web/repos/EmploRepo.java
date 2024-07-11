package com.example.Test_Web.repos;

// Интерфейс для описания работы с таблицей сотрудников
// (запись, изменение, удаление, чтение)
// все на основе существующего

import com.example.Test_Web.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;


import java.util.List;

public interface EmploRepo extends CrudRepository<Employee, Long> { // CrudRepository Repository


    List<Employee> findBySurnameContaining (String surname); // Поиск в БД по значению поля
}
