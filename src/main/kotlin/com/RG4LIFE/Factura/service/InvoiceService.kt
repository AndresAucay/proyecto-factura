package com.RG4LIFE.Factura.service

import com.RG4LIFE.Factura.model.Invoice
import com.RG4LIFE.Factura.repository.ClientRepository
import com.RG4LIFE.Factura.repository.InvoiceRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.Optional


@Service
class InvoiceService {
    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    @Autowired
    lateinit var clientRepository: ClientRepository

    fun list(): List<Invoice> {
        return invoiceRepository.findAll()
    }

    fun filterTotal(value: Double): List<Invoice>{
        return invoiceRepository.filterTotal(value)
    }

    fun listOne(id: Long): Optional<Invoice> {
        return invoiceRepository.findById(id)
    }

    // PETICIONES POST
    fun save(modelo: Invoice): Invoice {
        try {
            clientRepository.findById(modelo.clientId)
                ?: throw Exception("Id del autor no encontrado")
            return invoiceRepository.save(modelo)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message)
        }
    }

    // clase service -Petición put
    fun update(modelo: Invoice): Invoice {
        try {
            invoiceRepository.findById(modelo.id)
                ?: throw Exception("ID no existe")

            return invoiceRepository.save(modelo)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    // clase service - Delete by id
    fun delete(id: Long?): Boolean? {
        try {
            val response = invoiceRepository.findById(id)
                ?: throw Exception("ID no existe")
            invoiceRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}