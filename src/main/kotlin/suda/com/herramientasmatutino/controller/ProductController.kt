
package suda.com.herramientasmatutino.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import suda.com.herramientasmatutino.model.Product
import suda.com.herramientasmatutino.service.ProductService

@RestController
@RequestMapping("/product")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping
    fun listar(): List<Product> {
        return productService.listar()
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    fun guardar(@RequestBody product: Product): Product {
        return productService.crear(product)
    }

    @PutMapping("/{id}")
    fun actualizar(
        @PathVariable id: Int,
        @RequestBody product: Product
    ): Product {
        return productService.actualizar(id, product)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun eliminar(@PathVariable id: Int) {
        productService.eliminar(id)
    }
}
