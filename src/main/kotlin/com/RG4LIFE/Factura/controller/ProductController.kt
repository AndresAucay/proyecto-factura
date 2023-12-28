package com.RG4LIFE.Factura.controller

import com.RG4LIFE.Factura.model.Product
import com.RG4LIFE.Factura.service.ClientService
import com.RG4LIFE.Factura.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
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
@RequestMapping("/product-app")
class ProductController {
    @Autowired
    lateinit var productService: ProductService
    @GetMapping
    fun list (product:Product, pageable: Pageable):ResponseEntity<*>{
        val response= productService.list(pageable,product)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/list-dto")
    fun lisDto(): ResponseEntity<*>{
        return ResponseEntity(productService.listDto(), HttpStatus.OK)
    }

//@RequestParam searchValue:String

    @GetMapping("/{id}")
    fun listOne (@PathVariable id: Long) : Optional<Product> {
        return productService.listOne(id)
    }

    //Peticiones post - Clase controller
    @PostMapping
    fun save (@RequestBody modelo: Product): ResponseEntity<Product> {
        return ResponseEntity(productService.save(modelo), HttpStatus.OK)
    }

    //clase controller - Petición Put
    @PutMapping
    fun update (@RequestBody modelo: Product): ResponseEntity<Product> {
        return ResponseEntity(productService.update(modelo), HttpStatus.OK)
    }

    //clase  controller-Petiicon Patch
    @PatchMapping
    fun updateName (@RequestBody modelo: Product): ResponseEntity<Product> {
        return ResponseEntity(productService.update(modelo), HttpStatus.OK)
    }

    //clase  controller - Petición Delete
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return productService.delete(id)
    }
}