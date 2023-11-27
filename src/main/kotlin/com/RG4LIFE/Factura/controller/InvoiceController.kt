package com.RG4LIFE.Factura.controller

import com.RG4LIFE.Factura.model.Invoice
import com.RG4LIFE.Factura.service.InvoiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/invoice-app")   //endpoint
class InvoiceController {
    @Autowired
    lateinit var invoiceService: InvoiceService

    @GetMapping
    fun list ():List <Invoice>{
        return invoiceService.list()
    }

}