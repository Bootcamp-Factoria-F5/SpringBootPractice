package com.example.SpringBootPractice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/practice")
public class FirstController {
    @GetMapping
    public String saluda() {
        return "Hola";
    }

    @PostMapping
    public String saludar2(@RequestBody String name) {
        return "Hola por post " + name;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return "quieres eliminar el recurso" + id;
    }

    @PutMapping("/{id}")
    public String update(@PathVariable String id, @RequestBody String name) {
        return id + "vas a cambiar el nombre por: " + name;
    }

}
