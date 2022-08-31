package org.kotlin.demo.service

import org.kotlin.demo.model.KotlinData
import org.kotlin.demo.model.KotlinModel
import org.kotlin.demo.repository.KotlinRepository
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils

@Service
class KotlinService(var repository: KotlinRepository) {
    fun findById(id: Int): KotlinModel {
        val model = repository.findById(id)
        return if (model.isPresent)
            null!!
        else {
            KotlinModel(id, model.get().name, model.get().modelDetail)
        }
    }

    fun save(model: KotlinModel): Boolean {
        var kotlinData = KotlinData(null, model.name, model.modelDetail)
        return !ObjectUtils.isEmpty(repository.save(kotlinData))

    }

    fun update(model: KotlinModel): Boolean {
        return repository.findById(model.id).map { foundData ->
            val updatedModel: KotlinData = foundData.copy(
                id = model.id,
                name = model.name,
                modelDetail = model.modelDetail
            )
            repository.save(updatedModel)
        }.isPresent
    }

    fun removeById(id: Int): Boolean {
        val data = repository.findById(id)
        if (data.isPresent) {
            repository.deleteById(id)
            return true
        } else
            return false

    }

    fun findAll(): List<KotlinModel> {
        return repository.findAll().map { data -> KotlinModel(data.id, data.name, data.modelDetail) }
    }
}
