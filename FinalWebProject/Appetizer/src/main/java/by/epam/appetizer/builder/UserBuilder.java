package by.epam.appetizer.builder;

import by.epam.appetizer.entity.User;

public interface UserBuilder {

    User build();

    UserBuilder withId(int id);

    UserBuilder withEmail(String email);

    UserBuilder withPassword(String password);

    UserBuilder withRoleId(int roleId);

    UserBuilder withFirstName(String firstName);

    UserBuilder withLastName(String lastName);

    UserBuilder withGender(String gender);

    UserBuilder withUsername(String username);

    UserBuilder withPhoneNumber(String number);
}
