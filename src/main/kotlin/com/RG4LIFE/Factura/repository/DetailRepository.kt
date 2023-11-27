package com.RG4LIFE.Factura.repository

import com.RG4LIFE.Factura.model.Detail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DetailRepository : JpaRepository<Detail, Long?> {

    fun findById (id: Long?): Detail?


}