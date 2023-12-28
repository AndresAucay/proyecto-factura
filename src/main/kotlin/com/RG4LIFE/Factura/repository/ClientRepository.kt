package com.RG4LIFE.Factura.repository

import com.RG4LIFE.Factura.model.Client

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository :JpaRepository<Client, Long?>{
    fun findById (id: Long?): Client?
}