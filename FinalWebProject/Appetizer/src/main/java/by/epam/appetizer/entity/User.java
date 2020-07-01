package by.epam.appetizer.entity;

import java.util.Objects;

public class User extends Entity {

    private String email;
    private String password;
    private int roleId;
    private String firstName;
    private String lastName;
    private String gender;
    private String username;
    private String phoneNumber;

    public User() {
    }

    public User(int id, String email, String password, int roleId,
            String firstName, String lastName, String gender, String username,
            String phoneNumber) {
        super(id);
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        User user = (User) obj;
        return Objects.equals(email, user.email)
                && Objects.equals(password, user.password)
                && roleId == user.roleId
                && Objects.equals(firstName, user.firstName)
                && Objects.equals(lastName, user.lastName)
                && Objects.equals(gender, user.gender)
                && Objects.equals(username, user.username)
                && Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, password, roleId, firstName,
                lastName, gender, username, phoneNumber);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        str.append("email=").append(email).append(", ");
        str.append("password=").append(password).append(", ");
        str.append("roleId=").append(roleId).append(", ");
        str.append("firstName=").append(firstName).append(", ");
        str.append("lastName=").append(lastName).append(", ");
        str.append("gender=").append(gender).append(", ");
        str.append("username=").append(username).append(", ");
        str.append("phoneNumber=").append(firstName).append("]");
        return str.toString();
    }
}
