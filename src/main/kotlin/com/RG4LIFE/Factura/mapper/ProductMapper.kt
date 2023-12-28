package com.RG4LIFE.Factura.mapper

import com.RG4LIFE.Factura.dto.ProductDto
import com.RG4LIFE.Factura.model.Product

object ProductMapper {
    fun mapToDto(product:Product):ProductDto{
        return ProductDto(
            product.id,
             "${product.description} ${product.brand}"
        )
    }
}