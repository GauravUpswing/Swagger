package com.swagger.documentation.shivalik.service


import com.swagger.documentation.shivalik.model.request.MaritalStatus
import org.springframework.stereotype.Service


@Service
class CustomerValidationService {
    fun validateMaritalStatus(maritalStatus: MaritalStatus) {
        when (maritalStatus) {
            is MaritalStatus.Married -> {
                require(maritalStatus.spouseName.isNotBlank()) { "Spouse name is required for married customers" }
                requireNotNull(maritalStatus.spouseDateOfBirth) { "Spouse date of birth is required for married customers" }  // ✅ Fix Null Check
            }
            else -> {

            }
        }
    }
}
