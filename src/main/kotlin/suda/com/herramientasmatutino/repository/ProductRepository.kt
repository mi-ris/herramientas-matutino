package suda.com.herramientasmatutino.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import suda.com.herramientasmatutino.model.Product

@Repository
interface ProductRepository: JpaRepository<Product, Int>{
}