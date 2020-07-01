package by.epam.appetizer.builder.impl;

import by.epam.appetizer.builder.UserBuilder;
import by.epam.appetizer.entity.User;

public class UserBuilderImpl implements UserBuilder {

    private int id;
    private String email;
    private String password;
    private int roleId;
    private String firstName;
    private String lastName;
    private String gender;
    private String username;
    private String phoneNumber;

    public User build() {
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setRoleId(roleId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGender(gender);
        user.setUsername(username);
        user.setPhoneNumber(phoneNumber);
        return user;
    }

    public UserBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withRoleId(int roleId) {
        this.roleId = roleId;
        return this;
    }

    public UserBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
