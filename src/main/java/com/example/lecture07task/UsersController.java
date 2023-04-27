package com.example.lecture07task;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
public class UsersController {

    @GetMapping("/users")
    public String getName(@RequestParam(value = "name", defaultValue = "匿名希望") String name) {
        return name;
    }

    @PostMapping("/users")
    public ResponseEntity<Map<String, String>> create(@RequestBody @Validated CreateForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/users/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "user successfully created"));
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody UpdateForm users) {
        return ResponseEntity.ok(Map.of("message", "user successfully updated"));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id, @RequestBody UpdateForm users) {
        return ResponseEntity.ok(Map.of("message", "user successfully deleted"));
    }

}
