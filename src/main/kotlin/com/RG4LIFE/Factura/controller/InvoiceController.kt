package com.RG4LIFE.Factura.controller

import com.RG4LIFE.Factura.model.Invoice
import com.RG4LIFE.Factura.service.InvoiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.Optional


@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
@RestController
@RequestMapping("/invoice-app")
class InvoiceController {
    @Autowired
    lateinit var invoiceService: InvoiceService
    @GetMapping
    fun list ():List <Invoice>{
        return invoiceService.list()
    }

    @GetMapping("/{id}")
    fun listOne (@PathVariable id: Long) : Optional<Invoice> {
        return invoiceService.listOne(id)
    }
    @GetMapping("/filter-total/{value}")
    fun listTotals (@PathVariable value: Double ):ResponseEntity<*>{
        return ResponseEntity(invoiceService.filterTotal(value), HttpStatus.OK)
    }

    //Peticiones post - Clase controller
    @PostMapping
    fun save (@RequestBody modelo: Invoice): ResponseEntity<Invoice> {
        return ResponseEntity(invoiceService.save(modelo), HttpStatus.OK)
    }

    //clase controller - Petición Put
    @PutMapping
    fun update (@RequestBody modelo: Invoice): ResponseEntity<Invoice> {
        return ResponseEntity(invoiceService.update(modelo), HttpStatus.OK)
    }

    //clase  controller-Petiicon Patch
    @PatchMapping
    fun updateName (@RequestBody modelo: Invoice): ResponseEntity<Invoice> {
        return ResponseEntity(invoiceService.update(modelo), HttpStatus.OK)
    }

    //clase  controller - Petición Delete
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return invoiceService.delete(id)
    }
}