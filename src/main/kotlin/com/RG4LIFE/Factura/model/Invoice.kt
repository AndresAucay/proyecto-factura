package com.RG4LIFE.Factura.model

import jakarta.persistence.*
import java.sql.Time

@Entity
@Table(name = "invoice")
class Invoice{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var code: String? = null
    @Column (name = "create_at")
    var createAt: Time? = null
    var total: String? = null
    @Column(name = "client_id")
    var clientId:Long?=null
}