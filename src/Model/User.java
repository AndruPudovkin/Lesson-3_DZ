package Model;

import java.time.LocalDate;

public class User {
    private String fio;
    private LocalDate date;
    private Integer phoneNumder;
    private char gender;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPhoneNumder() {
        return phoneNumder;
    }

    public void setPhoneNumder(int phoneNumder) {
        this.phoneNumder = phoneNumder;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
