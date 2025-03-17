package com.swagger.documentation.shivalik.model.request

import java.time.LocalDate

enum class Gender {
    MALE, FEMALE, OTHER
}

enum class Occupation {
    SALARIED, SELF_EMPLOYED, OTHERS
}

sealed class MaritalStatus {
    object Unmarried : MaritalStatus()
    object Divorced : MaritalStatus()
    object Widowed : MaritalStatus()
    data class Married(val spouseName: String, val spouseDateOfBirth: LocalDate) : MaritalStatus()
}

enum class YesNo{
    Y,N
}
enum class Salutation{
    MR, MRS, Miss
}