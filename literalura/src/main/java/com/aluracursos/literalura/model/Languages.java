package com.aluracursos.literalura.model;

public enum Languages {
    ENGLISH("en"),
    SPANISH("es"),
    FRENCH("fr"),
    GERMAN("de"),
    ITALIAN("it"),
    RUSSIAN("ru");

    private final String languages;

    Languages(String languages) {
        this.languages = languages;
    }

    public static Languages fromString(String text) {
        for (Languages categoria : Languages.values()) {
            if (categoria.languages.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Language " + text + " not found");
    }
}

