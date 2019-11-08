package com.example.kotlin_restapi.entity

import javax.persistence.*

@Entity
@Table(name = "characters")
data class Character (
    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column(name = "username", length = 100, nullable = false)
    val username: String,

    @Column(name = "age", nullable = false)
    val age: Long,

    @Column(name = "jobs", length = 100)
    val jobs: String? = null
)