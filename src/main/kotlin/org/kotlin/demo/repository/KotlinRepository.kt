package org.kotlin.demo.repository

import org.kotlin.demo.model.KotlinData
import org.springframework.data.jpa.repository.JpaRepository

interface KotlinRepository : JpaRepository<KotlinData,Int>
