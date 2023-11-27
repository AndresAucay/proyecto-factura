package com.RG4LIFE.Factura.service

import com.RG4LIFE.Factura.model.Invoice
import com.RG4LIFE.Factura.repository.InvoiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class InvoiceService {
    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    fun list ():List<Invoice>{
        return invoiceRepository.findAll()
    }

}