package com.example.kotlin_restapi.controller

import com.example.kotlin_restapi.entity.Character
import com.example.kotlin_restapi.service.CharacterService
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/api/v1/characters")
class CharacterController (private val characterService: CharacterService){

    @GetMapping("")
    fun findAll(): List<Character> {
        return characterService.findAll()
    }

    @PostMapping("")
    fun create(@RequestBody character: Character): Character {
        characterService.save(character)
        return character
    }

    @GetMapping("{id}")
    fun findById(@PathVariable id: Long): Optional<Character> {
        return characterService.findById(id)
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody character: Character): Character {
        characterService.save(character.copy(id = id))
        return character.copy(id = id)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): String {
        characterService.delete(id)
        return "削除が完了しました"
    }
}