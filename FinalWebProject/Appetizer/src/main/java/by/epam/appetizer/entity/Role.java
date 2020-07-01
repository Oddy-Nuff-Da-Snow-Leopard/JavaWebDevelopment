package by.epam.appetizer.entity;

public enum Role {

    ADMIN(1),
    CUSTOMER(2);

    private final int roleId;

    Role(int roleId) {
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }
}
