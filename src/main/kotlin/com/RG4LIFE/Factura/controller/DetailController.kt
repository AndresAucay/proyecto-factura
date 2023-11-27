package com.RG4LIFE.Factura.controller

import com.RG4LIFE.Factura.model.Detail
import com.RG4LIFE.Factura.service.DetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/detail-app")   //endpoint
class DetailController {
    @Autowired
    lateinit var detailService: DetailService
    @GetMapping
    fun list ():List <Detail>{
        return detailService.list()
    }

}