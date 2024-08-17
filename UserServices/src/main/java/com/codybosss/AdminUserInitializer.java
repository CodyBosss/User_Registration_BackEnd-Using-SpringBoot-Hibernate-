package com.codybosss;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.codybosss.Dao.RoleRepository;
import com.codybosss.entity.Role;
import com.codybosss.entity.RoleName;
import com.codybosss.service.UserService;

@Component
public class AdminUserInitializer implements CommandLineRunner {

    private final UserService userService;
    private final RoleRepository roleRepository;

    public AdminUserInitializer(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userService.listUsers().isEmpty()) {
            Role adminRole = new Role();
            adminRole.setName(RoleName.ROLE_ADMIN);
            roleRepository.save(adminRole);

            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);

            userService.createUser("admin", "adminpassword", RoleName.ROLE_ADMIN);
        }
    }
}
