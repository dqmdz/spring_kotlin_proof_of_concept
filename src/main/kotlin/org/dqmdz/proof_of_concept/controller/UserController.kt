package org.dqmdz.proof_of_concept.controller

import org.dqmdz.proof_of_concept.model.User
import org.dqmdz.proof_of_concept.repository.UserRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(val repository: UserRepository) {

    @GetMapping("/")
    fun getAll(): List<User> {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): User? {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/")
    fun create(@RequestBody user: User): User {
        return repository.save(user);
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody newUser: User): User? {
        return if (repository.existsById(id)) {
            repository.save(
                User(
                    id = id,
                    name = newUser.name,
                    email = newUser.email,
                    password = newUser.password
                )
            )
        } else {
            null;
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) {
        repository.deleteById(id);
    }

}