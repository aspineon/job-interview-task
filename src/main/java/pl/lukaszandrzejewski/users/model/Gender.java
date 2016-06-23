package pl.lukaszandrzejewski.users.model;

public enum Gender {

    MALE("Jestem mężczyzną"), FEMALE("Jestem kobietą");

    private String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
