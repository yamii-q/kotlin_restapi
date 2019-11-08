package com.example.kotlin_restapi

import com.example.kotlin_restapi.controller.CharacterController
import com.example.kotlin_restapi.entity.Character
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.junit4.SpringRunner


@RunWith(value = SpringRunner::class)
@SpringBootTest
@Sql("classpath:setup.sql")
class CharacterControllerTest {
    @Autowired
    private lateinit var characterController: CharacterController

    @Test
    fun noDataTest() {
        val characters = characterController.findAll()
        Assertions.assertThat(characters).isEmpty()
    }

    @Test
    fun createTest() {
        val createCharacter = characterController.create(Character(username = "Kazuma", age = 16, jobs = "NEET"))
        Assertions.assertThat(createCharacter.username).isEqualTo("Kazuma")
        Assertions.assertThat(createCharacter.age).isEqualTo(16)
        Assertions.assertThat(createCharacter.jobs).isEqualTo("NEET")
        Assertions.assertThat(createCharacter.id).isEqualTo(createCharacter.id)
    }

    @Test
    fun findByIdTest() {
        val createCharacter = characterController.create(Character(username = "Kazuma", age = 16, jobs = "NEET"))
        val findCharacter = characterController.findById(createCharacter.id ?: 0)
        Assertions.assertThat(findCharacter.orElse(null).username).isEqualTo("Kazuma")
        Assertions.assertThat(findCharacter.orElse(null).age).isEqualTo(16)
        Assertions.assertThat(findCharacter.orElse(null).jobs).isEqualTo("NEET")
    }

    @Test
    fun findAllTest() {
        val createCharacter1 = characterController.create(Character(username = "Kazuma", age = 16, jobs = "NEET"))
        val createCharacter2 = characterController.create(Character(username = "Megumin", age = 13, jobs = "Arc Wizard"))
        val findCharacters = characterController.findAll()
        Assertions.assertThat(findCharacters[0].id).isEqualTo(createCharacter1.id)
        Assertions.assertThat(findCharacters[0].username).isEqualTo("Kazuma")
        Assertions.assertThat(findCharacters[0].age).isEqualTo(16)
        Assertions.assertThat(findCharacters[0].jobs).isEqualTo("NEET")
        Assertions.assertThat(findCharacters[1].id).isEqualTo(createCharacter2.id)
        Assertions.assertThat(findCharacters[1].username).isEqualTo("Megumin")
        Assertions.assertThat(findCharacters[1].age).isEqualTo(13)
        Assertions.assertThat(findCharacters[1].jobs).isEqualTo("Arc Wizard")
    }

    @Test
    fun updateTest() {
        val createCharacter = characterController.create(Character(username = "Kazuma", age = 16, jobs = "NEET"))
        val findCharacter = characterController.findById(createCharacter.id ?: 0)
        Assertions.assertThat(findCharacter.orElse(null).username).isEqualTo("Kazuma")
        Assertions.assertThat(findCharacter.orElse(null).age).isEqualTo(16)
        Assertions.assertThat(findCharacter.orElse(null).jobs).isEqualTo("NEET")

        characterController.update(createCharacter.id ?: 0, Character(username = "Aqua", age = 999, jobs = "Arc Priest"))
        val updateCharacter = characterController.findById(createCharacter.id ?: 0)
        Assertions.assertThat(updateCharacter.orElse(null).username).isEqualTo("Aqua")
        Assertions.assertThat(updateCharacter.orElse(null).age).isEqualTo(999)
        Assertions.assertThat(updateCharacter.orElse(null).jobs).isEqualTo("Arc Priest")
    }

    @Test
    fun deleteTest() {
        val createCharacter = characterController.create(Character(username = "Kazuma", age = 16, jobs = "NEET"))
        val findCharacter = characterController.findById(createCharacter.id ?: 0)
        Assertions.assertThat(findCharacter.orElse(null).username).isEqualTo("Kazuma")
        Assertions.assertThat(findCharacter.orElse(null).age).isEqualTo(16)
        Assertions.assertThat(findCharacter.orElse(null).jobs).isEqualTo("NEET")
        characterController.delete(createCharacter.id ?: 0)
        val deleteCharacter = characterController.findById(createCharacter.id ?: 0)
        Assertions.assertThat(deleteCharacter).isEmpty
    }
}