package com.example.liquibase_test.services;

import com.example.liquibase_test.dtos.AnimalDTO;

import java.util.List;

public interface AnimalService {
    /**
     * Создает новое животное
     * @param animal - животное для создания
     */
    void create(AnimalDTO animal);

    /**
     * Возвращает список всех животных
     * @return список животных
     */
    List<AnimalDTO> readAll();

    /**
     * Возвращает животное по его id
     * @param id - id животного
     * @return - объект животного с заданным id
     */
    AnimalDTO read(Long id);

    /**
     * Обновляет животное с заданным id,
     * @param animal - животное в соответствии с которым нужно обновить данные
     * @param id - id животного которого нужно обновить
     */
    AnimalDTO update(AnimalDTO animal, Long id);

    /**
     * Удаляет животное с заданным id
     * @param id - id животного, которого нужно удалить
     */
    void delete(Long id);
}
