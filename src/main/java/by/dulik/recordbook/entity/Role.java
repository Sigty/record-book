package by.dulik.recordbook.entity;

import java.util.Objects;

public class Role {

    private String role;

    public Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static Role createRole(String role) {
        return new Role(role);
    }

    @Override
    public String toString() {
        return "Role : " + role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }
        Role role1 = (Role) o;
        return getRole().equals(role1.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRole());
    }
}
