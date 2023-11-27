package com.RG4LIFE.Factura.model

import jakarta.persistence.*
import java.sql.Time

@Entity
@Table(name = "detail")
class Detail{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var quantily: Long? = null
    var price: String? = null
    @Column(name = "invoice_id")
    var invoiceId: Time? = null
    @Column(name = "product_id")
    var productId:Long?=null
}