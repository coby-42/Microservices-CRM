package com.ironhack.userservice;

import com.ironhack.userservice.service.interfaces.IUserService;
import com.ironhack.userservice.utils.styles.ConsoleColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

//	@Autowired
//    private IUserService userService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "\n\tUp and Running!!!");
//        System.out.println(ConsoleColors.WHITE_BRIGHT);
//
//		userService.createAdminIfNecessary();
//    }
}
