package domain;

public enum Emails {
    TOTEST("contateoduo@gmail.com"),
    FROM("eduardoalcarialopes@gmail.com");

    private final String email;

    Emails(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
