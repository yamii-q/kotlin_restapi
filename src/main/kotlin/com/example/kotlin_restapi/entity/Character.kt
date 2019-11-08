package com.example.kotlin_restapi.entity

import javax.persistence.*

@Entity
@Table(name = "characters")
data class Character (
    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column(name = "username", length = 100)
    val username: String? = null,
    @Column(name = "age")
    val age: Long? = null,
    @Column(name = "jobs", length = 400)
    val jobs: String? = null
)