package com.aluracursos.literalura.model;

public enum Languages {
    ENGLISH("en"),
    SPANISH("es"),
    FRENCH("fr"),
    GERMAN("de"),
    ITALIAN("it"),
    RUSSIAN("ru");

    private String lang;
    Languages(String lang) {
        this.lang = lang;
    }

    public static Languages fromString(String text) {
        for (Languages languages : Languages.values())
            if(languages.lang.equalsIgnoreCase(text)){
                return languages;
            }
        throw new IllegalArgumentException("Language " + text + " not found");
    }

}

