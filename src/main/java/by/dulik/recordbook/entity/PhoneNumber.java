package by.dulik.recordbook.entity;

import java.util.Objects;

public class PhoneNumber {

    private String number;

    public PhoneNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public static PhoneNumber createPhoneNumber(String number) {
        return new PhoneNumber(number);
    }

    @Override
    public String toString() {
        return "PhoneNumber : " + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
