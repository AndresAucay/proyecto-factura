package com.RG4LIFE.Factura.repository

import com.RG4LIFE.Factura.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, String> {
    fun findByUsername(username: String): UserEntity?
}