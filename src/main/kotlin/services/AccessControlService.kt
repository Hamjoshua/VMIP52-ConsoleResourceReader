package org.example.services

import org.example.entities.Permission
import org.example.entities.Resource
import org.example.entities.StatusCode
import org.example.entities.User
import org.example.validators.ValidationContext
import org.example.validators.ValidationResult
import org.example.validators.concrete.ActionValidator
import org.example.validators.concrete.AuthValidator
import org.example.validators.concrete.PermissionValidator
import org.example.validators.concrete.ResourceExistenceValidator
import org.example.validators.concrete.ResourceFormatValidator
import org.example.validators.concrete.VolumeValidator

class AccessControlService(
    private val users: Map<String, User>,
    private val resources: Set<Resource>,
    private val permissions: List<Permission>
) {
    private val validatorChain by lazy {
        AuthValidator(users)
            .setNext(ResourceFormatValidator())
            .setNext(ActionValidator())
            .setNext(ResourceExistenceValidator(resources))
            .setNext(PermissionValidator(permissions))
            .setNext(VolumeValidator())
    }

    fun checkAccess(
        validationContext: ValidationContext
    ): StatusCode {
        return when (val result = validatorChain.handle(validationContext)) {
            is ValidationResult.Success -> StatusCode.SUCCESS
            is ValidationResult.Failure -> result.exitCode
        }
    }
}