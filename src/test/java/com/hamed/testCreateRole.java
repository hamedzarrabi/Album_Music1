package com.hamed;

import com.hamed.model.Role;
import com.hamed.repository.RoleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class testCreateRole {

    @Autowired private RoleRepository roleRepository;

    @Test
    public void testCreateRole() {
        Role user = new Role("User");
        Role admin = new Role("Admin");
        Role customer = new Role("Customer");

        roleRepository.saveAll(List.of(user, admin, customer));

        List<Role> roleList = roleRepository.findAll();
        Assertions.assertThat(roleList.size()).isEqualTo(3);
    }
}
