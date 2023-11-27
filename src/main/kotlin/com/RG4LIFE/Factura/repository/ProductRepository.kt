package com.RG4LIFE.Factura.repository

import com.RG4LIFE.Factura.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long?> {

    fun findById (id: Long?): Product?


}