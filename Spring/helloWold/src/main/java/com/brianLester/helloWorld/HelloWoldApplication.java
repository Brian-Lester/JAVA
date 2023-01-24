package com.brianLester.helloWorld;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class HelloWoldApplication {
        public static void main(String[] args) {
                SpringApplication.run(HelloWoldApplication.class, args);
        }
        
        // 1. Annotation
        @RequestMapping("/")
        // 3. Method that maps to the request route above
        public String hello() { // 3
                return "Hello World!";
        }
                
         @RequestMapping("/hi")
                // 3. Method that maps to the request route above
         public String hiBrian() { // 3
                 return "Hi brian!";
        }
}
