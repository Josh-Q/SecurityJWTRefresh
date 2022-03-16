package com.example.SecurityJWTRefresh;

import com.example.SecurityJWTRefresh.users.domain.AppUser;
import com.example.SecurityJWTRefresh.users.domain.Role;
import com.example.SecurityJWTRefresh.users.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityJwtRefreshApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityJwtRefreshApplication.class, args);
	}



	@Bean
	CommandLineRunner run(AppUserService appUserService){
		return args ->{
			appUserService.saveRole(new Role(null,"ROLE_USER"));
			appUserService.saveRole(new Role(null,"ROLE_MANAGER"));
			appUserService.saveRole(new Role(null,"ROLE_ADMIN"));
			appUserService.saveRole(new Role(null,"ROLE_SUPERADMIN"));

			appUserService.saveUser(new AppUser(null,"John","John","1234",new ArrayList<>()));
			appUserService.saveUser(new AppUser(null,"Apple","Apple","1234",new ArrayList<>()));
			appUserService.saveUser(new AppUser(null,"Bear","Bear","1234",new ArrayList<>()));
			appUserService.saveUser(new AppUser(null,"Car","Car","1234",new ArrayList<>()));
			appUserService.saveUser(new AppUser(null,"Donkey","Donkey","1234",new ArrayList<>()));


			appUserService.addRoleToUser("John","ROLE_USER");
			appUserService.addRoleToUser("John","ROLE_MANAGER");
			appUserService.addRoleToUser("Apple","ROLE_USER");
			appUserService.addRoleToUser("Bear","ROLE_MANAGER");
			appUserService.addRoleToUser("Car","ROLE_SUPER_ADMIN");
			appUserService.addRoleToUser("Donkey","ROLE_ADMIN");
			appUserService.addRoleToUser("Donkey","ROLE_USER");


		};
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
