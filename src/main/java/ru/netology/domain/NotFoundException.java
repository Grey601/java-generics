package ru.netology.domain;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Продукт с ID " + id + " не найден");
    }
}