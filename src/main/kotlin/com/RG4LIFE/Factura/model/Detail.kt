package com.RG4LIFE.Factura.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.sql.Time

@Entity
@Table(name = "detail")
class Detail{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var quantity: Int = 0
    var price: BigDecimal? = null
    @Column(name = "invoice_id")
    var invoiceId: Long? = null
    @Column(name = "product_id")
    var productId:Long?=null
}

