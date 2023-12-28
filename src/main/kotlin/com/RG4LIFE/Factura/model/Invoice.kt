package com.RG4LIFE.Factura.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.sql.Time
import java.sql.Timestamp
import java.time.LocalDateTime

@Entity
@Table(name = "invoice")
class Invoice{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var code: String? = null
    @Column (name = "create_at", nullable = false)
    var createdAt: Timestamp? = null
    var total: BigDecimal? = null
    @Column(name = "client_id")
    var clientId:Long?=null
}