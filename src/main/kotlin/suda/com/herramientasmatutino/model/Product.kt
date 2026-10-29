
package suda.com.herramientasmatutino.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "product")
class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    var id: Int? = null

    @Column(name = "description")
    var description: String? = null

    @Column(name = "price")
    var price: String? = null

    @Column(name = "cantidad")
    var cantidad: Int? = null
}
