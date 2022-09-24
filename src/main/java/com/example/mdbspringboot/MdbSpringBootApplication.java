package com.example.mdbspringboot;

import com.example.mdbspringboot.model.User;
import com.example.mdbspringboot.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication()
public class MdbSpringBootApplication implements CommandLineRunner {
   private final UserRepository userRepository;

   public MdbSpringBootApplication(UserRepository userRepository){
       this.userRepository = userRepository;
   }

   public static void main(String[] args) {
       SpringApplication.run(MdbSpringBootApplication.class, args);
   }

   @Override
    public void run(String...args) throws Exception {
       userRepository.deleteAll();
       userRepository.save(new User("Alice", "Vanderbilt x"));
       userRepository.save(new User("Morty", "Smith"));
       userRepository.save(new User("Summer", "Smith"));
       for (User user : userRepository.findAll()){
           System.out.println(user);
       }
   }
}
