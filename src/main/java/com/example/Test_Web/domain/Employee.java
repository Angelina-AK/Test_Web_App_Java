package com.example.Test_Web.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

//import javax.persistence.Entity;


//--------------------------------------------
//          Сущность - сотрудник
//--------------------------------------------
@Entity
public class Employee {

    // Поля
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;             // Первичный ключ
                                    // !!!! По стандартам языка все лучше с маленькой буквы
    private String name;            // Имя
    private String surname;         // Фамилия
    private String otchest;         // Отчество

    // Конструкторы
    public Employee(){          // !!! Обязательно должен быть конструктор по умолчанию, иначе спринг не сможет создавать экземпляры

    }
    public Employee(String p_name, String p_surname, String p_otchest) {
        name = p_name;
        surname = p_surname;
        otchest = p_otchest;
    }

    // Сеттеры для задания значений полей объекта
    public void setName(String p_Name){
        this.name = p_Name;
    }

    public void setId(Integer p_id) {
        this.id = p_id;
    }

    public void setSurname(String p_surname) {
        surname = p_surname;
    }

    public void setOtchest(String p_otchest) {
        otchest = p_otchest;
    }

    // Геттеры для получения значений полей объекта
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getOtchest() {
        return otchest;
    }

}
