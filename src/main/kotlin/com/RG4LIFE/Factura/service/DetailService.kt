package com.RG4LIFE.Factura.service

import com.RG4LIFE.Factura.model.Detail
import com.RG4LIFE.Factura.repository.DetailRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class DetailService {
    @Autowired
    lateinit var detailRepository: DetailRepository

    fun list ():List<Detail>{
        return detailRepository.findAll()
    }

}