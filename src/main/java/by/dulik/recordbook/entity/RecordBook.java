package by.dulik.recordbook.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RecordBook {

    private String nameRecordBook;
    private Set<User> users = new HashSet<>();

    public RecordBook() {
    }

    public static RecordBook createRecordBook() {
        return new RecordBook();
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

    public boolean editUser(User editUser) {
        if (users.contains(editUser)) {
            users.remove(editUser);
            users.add(editUser);
            return true;
        }
        return false;
    }

    public User findUserByFullName(String[] fullName) {
        return users
                .stream()
                .filter(x -> x.getFirstName().equals(fullName[0]) && x.getLastName().equals(fullName[1]))
                .findFirst()
                .orElse(null);
    }

    public Set<User> findAll() {
        return users;
    }

    public boolean deleteUser(User user) {
        if (user != null) {
            users.remove(user);
            return true;
        }
        return false;
    }

    public int getSizeSet() {
        if (!users.isEmpty()) {
            return users.size();
        }
        return 0;
    }

    public void openSaveSet(Set<User> savedSet) {
        if (savedSet != null && !savedSet.isEmpty()) {
            users.addAll(savedSet);
        }
    }

    public String getNameRecordBook() {
        return nameRecordBook;
    }

    public void setNameRecordBook(String nameRecordBook) {
        this.nameRecordBook = nameRecordBook;
    }

    public Set<User> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RecordBook)) {
            return false;
        }
        RecordBook that = (RecordBook) o;
        return Objects.equals(getNameRecordBook(), that.getNameRecordBook())
                && Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameRecordBook(), users);
    }

    @Override
    public String toString() {
        return "RecordBook{" + "users =" + users + "}\n";
    }
}