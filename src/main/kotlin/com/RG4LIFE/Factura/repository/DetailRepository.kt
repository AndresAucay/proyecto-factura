package com.RG4LIFE.Factura.repository

import com.RG4LIFE.Factura.model.Detail
import com.RG4LIFE.Factura.model.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface DetailRepository : JpaRepository<Detail, Long?>{
    fun findById (id: Long?): Detail?

    fun findByInvoiceId(invoiceId: Long?) : List<Detail>

}