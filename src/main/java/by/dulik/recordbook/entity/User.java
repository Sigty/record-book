package by.dulik.recordbook.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<PhoneNumber> phoneNumbers;
    private ArrayList<Role> roles;

    User(String firstName, String lastName, String email, ArrayList<PhoneNumber> phoneNumbers, ArrayList<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.roles = roles;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private ArrayList<PhoneNumber> phoneNumbers;
        private ArrayList<Role> roles;

        UserBuilder() {
        }

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder phoneNumbers(ArrayList<PhoneNumber> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
            return this;
        }

        public UserBuilder roles(ArrayList<Role> roles) {
            this.roles = roles;
            return this;
        }

        public User build() {
            return new User(firstName, lastName, email, phoneNumbers, roles);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return getFirstName().equals(user.getFirstName())
                && getLastName().equals(user.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + email + ", role: " + roles + ", phone Numbers: " + phoneNumbers;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }
}