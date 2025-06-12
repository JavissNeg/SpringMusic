package com.negrete.music.model;

public enum Genre {
    HIPHOP("Hiphop"),
    POP("Pop"),
    RAP("Rap"),
    ROCK_AND_ROLL("Rock"),
    TRAP("Trap"),
    REGAE("Regae"),
    SALSA("Salsa"),
    BACHATA("Bachata"),
    CUMBIA("Cumbia"),
    METAL("Metal"),
    JAZZ("Jazz"),
    BALADA("Balada"),
    ROCK_ALTERNATIVO("Rock alternativo"),
    BLUES("Blues"),
    COUNTRIE("Countrie"),
    RANCHERAS("Rancheras");

    private String genreName;

    Genre(String genreName) {
        this.genreName = genreName;
    }

    public static Genre findGenre(String text) {
        text = text.trim();

        for (Genre g : Genre.values()) {
            if (g.genreName.equalsIgnoreCase(text)) {
                return g;
            }
        }

        throw new IllegalArgumentException("Género no ecnontrado");
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
