package com.RG4LIFE.Factura.repository

import com.RG4LIFE.Factura.model.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository : JpaRepository<Invoice, Long?>{
    fun findById (id: Long?): Invoice?
    @Query("SELECT i FROM Invoice i WHERE i.total = :total")
    fun filterTotal(@Param("total") total: Double): List<Invoice>
}