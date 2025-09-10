package org.example.validators

import org.example.entities.Resource
import org.example.entities.User

// может меняться в зависимости от того, что нужно валидаторам
data class ValidationContext(
    var user: User? = null,
    var targetResource: Resource? = null, // после поиска ресурса
    var requiredVolume: Int = 0,
    var requiredResourceAction: ResourceAction
)
