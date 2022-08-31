package org.kotlin.demo.controller

import org.kotlin.demo.model.KotlinModel
import org.kotlin.demo.service.KotlinService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/kotlinDemo")
class KotlinController(private val service: KotlinService) {
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): KotlinModel = service.findById(id)

    @GetMapping
    fun findAll(): List<KotlinModel> = service.findAll()

    @PostMapping
    fun add(@RequestBody model: KotlinModel): Boolean = service.save(model)

    @PutMapping
    fun update(@RequestBody model: KotlinModel): Boolean = service.update(model)

    @DeleteMapping("/{id}")
    fun remove(@PathVariable id: Int): Boolean = service.removeById(id)
}