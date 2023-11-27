package com.RG4LIFE.Factura.repository

import com.RG4LIFE.Factura.model.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository : JpaRepository<Invoice, Long?> {

    fun findById (id: Long?): Invoice?


}