package com.springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet() {
        GreetResponse response = new GreetResponse(
                "Hello",
                List.of("Java", "PHP", "JavaScript"),
                new Person("Eduardo", "Developer", 30_000)
        );
        return response;
    }

    record Person(String name, String role, double savings) { }

    record GreetResponse(
            String greet,
            List<String> favProgrammingLanguages,
            Person person
    ) {
    }

//    class GreetResponse {
//        private final String greeet;
//
//        GreetResponse(String greeet) {
//            this.greeet = greeet;
//        }
//
//        public String getGreeet() {
//            return greeet;
//        }
//
//        @Override
//        public String toString() {
//            return "GreetResponse{" +
//                    "greeet='" + greeet + '\'' +
//                    '}';
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            GreetResponse that = (GreetResponse) o;
//            return Objects.equals(greeet, that.greeet);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(greeet);
//        }
//    }

}
