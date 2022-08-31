package org.kotlin.demo.model

import com.fasterxml.jackson.annotation.JsonInclude
import javax.persistence.*
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "Data")
data class KotlinData(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int?=null, var name: String?=null, var modelDetail: ModelDetails?=ModelDetails.LONG
)
