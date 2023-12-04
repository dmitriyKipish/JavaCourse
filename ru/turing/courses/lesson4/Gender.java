package ru.turing.courses.lesson4;

import java.util.Objects;

/**
 * Пол человека
 *
 * @author diagorn
 */
public enum Gender {
    MALE("Male", 'M', "Мужской пол"),
    FEMALE("Female", 'F', "Женский пол");


    /** Техническое название */
    private final String name;
    /** Символьное представление */
    private final char shortNameRepr;
    /** Описание */
    private final String description;

    Gender(String name, char shortNameRepr, String description) {
        this.name = name;
        this.shortNameRepr = shortNameRepr;
        this.description = description;
    }

    public static Gender ofName(String name) throws NotFound, NullPointerException {
        for (var value : Gender.values()){
            if (name != null){
                if (Objects.equals(value.name.toLowerCase(), name.toLowerCase())){
                    return value;
                }
            }
            else {
                throw new NullPointerException("Введенное значение null...");
            }
        }
        throw new NotFound("Пол " + name + " не найден");
        //return null;
    }

    public static Gender ofShortNameRepr(Character shortNameRepr) throws NotFound {
        //todo реализовать с кастомным эксепшном
        for (var value : Gender.values()) {
            if (shortNameRepr.equals(value.shortNameRepr)){
                return value;
            }
        }
        throw new NotFound("Пол " + shortNameRepr + " не найден");
    }

    public String getName() {
        return name;
    }

    public char getShortNameRepr() {
        return shortNameRepr;
    }

    public String getDescription() {
        return description;
    }

}
