package com.example.liquibase_test.services;

import com.example.liquibase_test.dtos.EmployeeDTO;

import java.util.List;

/**
 * Created by MadThreeD on 2022.
 */

public interface EmployeeService {
    /**
     * Создает нового сотрудника
     *
     * @param employeeDTO - сотрудник для создания
     */
    EmployeeDTO create(EmployeeDTO employeeDTO);

    /**
     * Возвращает список всех сотрудников
     *
     * @return список сотрудников
     */
    List<EmployeeDTO> readAll();

    /**
     * Возвращает сотрудника по его id
     *
     * @param id - id сотрудника
     * @return - объект сотрудника с заданным id
     */
    EmployeeDTO readById(Long id);

    /**
     * Обновляет сотрудника с заданным id,
     *
     * @param employeeDTO - сотрудник в соответствии с которым нужно обновить данные
     * @param id          - id сотрудника которого нужно обновить
     */
    EmployeeDTO update(EmployeeDTO employeeDTO, Long id);

    /**
     * Удаляет сотрудника с заданным id
     *
     * @param id - id сотрудника, которого нужно удалить
     */
    void delete(Long id);
}
