package com.hamed;

import com.hamed.model.Role;
import com.hamed.model.User;
import com.hamed.repository.RoleRepository;
import com.hamed.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class TestUserRepositort {
    @Autowired private UserRepository userRepository;
    @Autowired private RoleRepository roleRepository;
    @Autowired private TestEntityManager entityManager;




    @Test
    public void testCreateUser() {
        User user = new User();

        user.setEmail("hamed.zarrabi87@gmail.com");
        user.setFirstName("hamed");
        user.setLastName("zarrabi");
        user.setUserName("hami");
        user.setPassword("1234");

        User saveUser = userRepository.save(user);
        User existUser = entityManager.find(User.class, saveUser.getId());

        Assertions.assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void findUserByUserName() {
        String userName = "hami";
        User user = userRepository.findByUserName(userName);

        Assertions.assertThat(user).isNotNull();
    }

    @Test
    public void testAndRoleToNewUser() {

        User user = new User();
        user.setEmail("tabasom@yahoo.com");
        user.setFirstName("hamed");
        user.setLastName("zarrabi");
        user.setUserName("hami");
        user.setPassword("1234");

        Role roleUser = roleRepository.findByName("Admin");

        user.addRole(roleUser);

        User saveUser = userRepository.save(user);

        Assertions.assertThat(saveUser.getRoles().size()).isEqualTo(1);
    }

    @Test
    public void testAndRolesToExistUser() {
        User user = userRepository.findById(1L).get();

        Role roleUser = roleRepository.findByName("Admin");
        user.addRole(roleUser);

        Role roleAdmin = new Role(2L);
        user.addRole(roleAdmin);

        User saveUser = userRepository.save(user);

        Assertions.assertThat(saveUser.getRoles().size()).isEqualTo(2);

    }
}
