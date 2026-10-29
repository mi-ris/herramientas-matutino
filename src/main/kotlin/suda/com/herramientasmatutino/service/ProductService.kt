
package suda.com.herramientasmatutino.service

import org.springframework.stereotype.Service
import suda.com.herramientasmatutino.model.Product
import suda.com.herramientasmatutino.repository.ProductRepository

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    fun listar(): List<Product> {
        return productRepository.findAll()
    }

    fun crear(product: Product): Product {
        product.id = null
        return productRepository.save(product)
    }

    fun actualizar(id: Int, product: Product): Product {
        val productoExistente = productRepository.findById(id)
            .orElseThrow {
                NoSuchElementException("No existe un producto con id $id")
            }

        productoExistente.description = product.description
        productoExistente.price = product.price
        productoExistente.cantidad = product.cantidad

        return productRepository.save(productoExistente)
    }

    fun eliminar(id: Int) {
        if (!productRepository.existsById(id)) {
            throw NoSuchElementException("No existe un producto con id $id")
        }

        productRepository.deleteById(id)
    }
}
