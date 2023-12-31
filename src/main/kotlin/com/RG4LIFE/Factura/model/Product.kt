package com.RG4LIFE.Factura.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.text.DecimalFormat

@Entity
@Table(name = "product")
class Product{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var description: String? = null
    var brand: String? = null
    var price: BigDecimal? = null
    var stock: Int = 0
}