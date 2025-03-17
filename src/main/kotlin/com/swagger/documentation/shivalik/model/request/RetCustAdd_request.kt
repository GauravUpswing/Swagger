package com.swagger.documentation.shivalik.model.request


import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate
import java.time.LocalDateTime
import io.swagger.v3.oas.annotations.ExternalDocumentation
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

@Schema(description = "Customer request model containing all necessary customer details.")
data class CustomerRequest(
    @field:Schema(description = "Customer request payload.")
    val requestData: RequestData
)

@Schema(description = "Wrapper for request data.")
data class RequestData(
    @field:Schema(description = "Customer address and personal details.")
    val retCustAdd: Request
)

@Schema(description = "Encapsulates customer data, including personal and address details.")
data class Request(
    @field:Schema(description = "Customer's address and personal details.")
    val customerDetails: CustomerDetails,

    @field:Schema(description = "Customer-related boolean flags.")
    val flags: FlagsDto,

    @field:Schema(description = "Details of related customers.")
    val relatedDetails: RelatedDetails
)

@Schema(description = "Customer details including address, personal information, and additional data.")
data class CustomerDetails(
    @field:Schema(description = "List of customer addresses.", example = "[{\"addressLine1\": \"123 MG Road\", \"city\": \"Bangalore\"}]")
    val addressList: List<Address>,

    @field:Schema(description = "Personal details of the customer.")
    val personalDetails: PersonalDetails,

    @field:Schema(description = "Default address type.", example = "Home")
    val defaultAddrType: String,

    @field:Schema(description = "Segmentation class.", example = "002")
    val segmentationClass: String,

    @field:Schema(description = "Sub-segment classification.", example = "002")
    val subSegment: String
)

@Schema(description = "Details of a customer's address.")
data class Address(
    @field:Schema(description = "First line of the address.", example = "123 MG Road")
    val addressLine1: String,

    @field:Schema(description = "Second line of the address, if applicable.", example = "Near Brigade Road")
    val addressLine2: String? = null,

    @field:Schema(description = "Third line of the address, if applicable.", example = "MG Road Area")
    val addressLine3: String? = null,

    @field:Schema(
        description = "City of residence.",
        example = "Bangalore",
        externalDocs = ExternalDocumentation(
            description = "City Information",
            url = "https://example.com/city-info"
        )
    )
    val city: String,

    @field:Schema(
        description = "State of residence.",
        example = "Karnataka",
        externalDocs = ExternalDocumentation(
            description = "State Information",
            url = "https://example.com/state-info"
        )
    )
    val state: String,

    @field:Schema(
        description = "Postal code.",
        example = "560001",
        externalDocs = ExternalDocumentation(
            description = "Postal Code Lookup",
            url = "https://example.com/postal-code-lookup"
        )
    )
    val postalCode: String,

    @field:Schema(
        description = "Address category.",
        example = "Home",
        externalDocs = ExternalDocumentation(
            description = "Address Category Definitions",
            url = "https://example.com/address-category-definitions"
        )
    )
    val addressCategory: String,

    @field:Schema(description = "Preferred address flag.", example = "Y")
    val prefAddr: YesNo,

    @field:Schema(description = "Indicates if the address proof is received.", example = "Y")
    val isAddressProofReceived: YesNo,

    @field:Schema(description = "Indicates if the address is verified.", example = "Y")
    val isAddressVerified: YesNo,

    @field:Schema(description = "Address start date.", example = "2024-01-01T00:00:00")
    val startDate: LocalDateTime
)

@Schema(description = "Personal information about the customer.")
data class PersonalDetails(
    @field:Schema(description = "Customer's first name.", example = "Rahul")
    val firstName: String,

    @field:Schema(description = "Customer's last name.", example = "Sharma")
    val lastName: String,

    @field:Schema(description = "Middle name of the customer.", example = "Kumar")
    val middleName: String? = null,

    @field:Schema(description = "Date of birth in YYYY-MM-DD format.", example = "1992-08-25")
    val dateOfBirth: LocalDate,

    @field:Schema(description = "Birth day.", example = "25")
    @field:Min(1)
    @field:Max(31)
    val birthDay: String,

    @field:Schema(description = "Birth month.", example = "08")
    @field:Min(1)
    @field:Max(12)
    val birthMonth: String,

    @field:Schema(description = "Birth year.", example = "1992")
    @field:Min(1900)  // Example: Birth year must be 1900 or later
    @field:Max(2100)  // Prevent unrealistic future birth years
    val birthYear: String,


    @field:Schema(description = "Gender of the customer.", example = "Male")
    val gender: Gender,

    @field:Schema(
        description = "Preferred language.",
        example = "Hindi",
        externalDocs = ExternalDocumentation(
            description = "Language Preferences",
            url = "https://example.com/language-preferences"
        )
    )
    val preferredLanguage: String,

    @field:Schema(description = "Nationality.", example = "Indian")
    val nationality: String,

    @field:Schema(description = "Phone number.", example = "+91-9876543210")
    val phoneNumber: String
)

@Schema(description = "Common boolean flags associated with the customer.")
data class FlagsDto(
    @field:Schema(description = "Indicates if the customer is verified.", example = "YES")
    val isVerified: YesNo,

    @field:Schema(description = "Indicates if SMS banking is enabled.", example = "NO")
    val isSMSBankingEnabled: YesNo,

    @field:Schema(description = "Indicates if e-banking is enabled.", example = "YES")
    val isEbankingEnabled: YesNo
)

@Schema(description = "Information about related customers.")
data class RelatedDetails(
    @field:Schema(description = "Employment status.", example = "Salaried")
    val employmentStatus: String,

    @field:Schema(description = "Marital status.", example = "Single")
    val maritalStatus: MaritalStatus,

    @field:Schema(description = "Employer name.", example = "TechCorp Ltd.")
    val nameOfEmployer: Occupation,

    @field:Schema(description = "Nationality code.", example = "079")
    val nationalityCode: String,

    @field:Schema(description = "List of entity documents.")
    val entityData: List<EntityData>
)

@Schema(description = "Details about an entity document.")
data class EntityData(
    @field:Schema(description = "Document type code.", example = "AADHA")
    val docCode: String,

    @field:Schema(description = "Description of the document.", example = "Aadhar Card")
    val desc: String,

    @field:Schema(description = "Issue date of the document.", example = "2018-08-22T00:00:00")
    val issueDate: LocalDateTime,

    @field:Schema(description = "Reference number of the document.", example = "261323386259")
    val referenceNum: String,

    @field:Schema(description = "Status of the document.", example = "Received")
    val status: String
)
