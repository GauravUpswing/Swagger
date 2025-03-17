package com.swagger.documentation.shivalik.controller

import com.swagger.documentation.shivalik.model.request.CustomerRequest
import com.swagger.documentation.shivalik.model.response.RetCustAdd
import com.swagger.documentation.shivalik.model.response.CustDetails
import com.swagger.documentation.shivalik.service.CustomerValidationService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.parameters.RequestBody
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.servers.Server
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

// Server URLs for different environments
@Server(url = "http://localhost:8080", description = "Local Development Server")
@Server(url = "http://localhost:9080", description = "Staging Server")
@Server(url = "https://api.example.com", description = "Production Server")
@RestController
@RequestMapping("/RetCustAdd/add")
@Tag(name = "Customer Addition API", description = "Adding a customer")
class ShivalikCustomerController(private val validationService: CustomerValidationService) {

    @Operation(
        summary = "Adds new customer",
        description = "Adds a new customer with provided details for Shivalik Small Finance Bank.\n\nRefer to [master list](https://docs.google.com/spreadsheets/d/1deAQzIqNNm-CCwNDLnWRcr3LI06M9XiLh7PyvH0Qn6k/edit?gid=786681812#gid=786681812) for any doubts.",
        requestBody = RequestBody(
            required = true,
            content = [Content(
                mediaType = "application/json",
                schema = Schema(implementation = CustomerRequest::class),
                examples = [
                    ExampleObject(
                        name = "Success Case",
                        value = """{
                            "requestData": {
                                "retCustAdd": {
                                    "customerDetails": {
                                        "addressList": [
                                            {
                                                "addressLine1": "123 MG Road",
                                                "city": "Bangalore",
                                                "state": "Karnataka",
                                                "postalCode": "560001",
                                                "addressCategory": "Home",
                                                "prefAddr": "Y",
                                                "isAddressProofReceived": "Y",
                                                "isAddressVerified": "Y",
                                                "startDate": "2024-01-01T00:00:00"
                                            }
                                        ],
                                        "personalDetails": {
                                            "firstName": "Rahul",
                                            "lastName": "Sharma",
                                            "dateOfBirth": "1992-08-25",
                                            "birthDay": "25",
                                            "birthMonth": "08",
                                            "birthYear": "1992",
                                            "gender": "Male",
                                            "preferredLanguage": "Hindi",
                                            "nationality": "Indian",
                                            "phoneNumber": "+91-9876543210"
                                        },
                                        "defaultAddrType": "Home",
                                        "segmentationClass": "002",
                                        "subSegment": "002"
                                    },
                                    "flags": {
                                        "isVerified": "YES",
                                        "isSMSBankingEnabled": "NO",
                                        "isEbankingEnabled": "YES"
                                    },
                                    "relatedDetails": {
                                        "employmentStatus": "Salaried",
                                        "maritalStatus": "Single",
                                        "nameOfEmployer": "TechCorp Ltd.",
                                        "nationalityCode": "079",
                                        "entityData": [
                                            {
                                                "docCode": "AADHA",
                                                "desc": "Aadhar Card",
                                                "issueDate": "2018-08-22T00:00:00",
                                                "referenceNum": "261323386259",
                                                "status": "Received"
                                            }
                                        ]
                                    }
                                }
                            }
                        }"""
                    ),
                    ExampleObject(
                        name = "Failure Case - Missing Fields",
                        value = """{
                            "requestData": {
                                "retCustAdd": {
                                    "customerDetails": {
                                        "addressList": [
                                            {
                                                "addressLine1": "village Beelpur",
                                                "city": "JAIP",
                                                "state": "RJ",
                                                "postalCode": "303104",
                                                "prefAddr": "Y",
                                                "isAddressProofReceived": "Y",
                                                "isAddressVerified": "Y",
                                                "startDate": "2018-08-23T00:00:00"
                                            }
                                        ],
                                        "personalDetails": {
                                            "firstName": "LOKESH",
                                            "lastName": "YOGI",
                                            "dateOfBirth": "1990-12-01T00:00:00.000",
                                            "birthDay": "01",
                                            "birthMonth": "12",
                                            "birthYear": "1990",
                                            "gender": "M"
                                        },
                                        "defaultAddrType": "Mailing",
                                        "segmentationClass": "002",
                                        "subSegment": "002"
                                    }
                                }
                            }
                        }"""
                    )
                ]
            )]
        )
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Customer creation",
                content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = RetCustAdd::class),
                    examples = [
                        ExampleObject(
                            name = "Success case",
                            value = """{
                            "RetCustDetails": {
                                "CustId": "477209",
                                "Entity": "Retail Customer",
                                "Status": "Success",
                                "Service": "CIFRetailCustomerCreate",
                                "Description": "Retail Customer successfully created with CIFID 477209"
                            }
                        }"""),
                        ExampleObject(
                            name = "Failure case-Missing Fields",
                            value = """{
                            "RetCustDetails": {
                                "Message": "BE",
                                "Status": "Failure",
                                "Code": "CRMEJB0123",
                                "Description": "CRMEJB0123.The value provided for , AccountBO.region is not valid data category"
                            }
                        }"""

                        ),
                        ExampleObject(
                            name="Failure Case",
                            value = """{
                            "RetCustDetails": {
                                
                                "Message": "Request UUID Already Submitted on : 2023-03-21 at 09:51:23",
                                "Status": "Failure",
                                "Code": "001",
                                "Description": "Completed - Response received from CBS",
                                "ReferenceID": "Upswing123POSTMYAN2023-03-21"
                                
                                }}"""
                        )
                    ]
                )]
            ),
            ApiResponse(
                responseCode = "400",
                description = "Bad Request",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            ),
            ApiResponse(
                responseCode = "500",
                description = "Internal server error",
                content = [Content(schema = Schema(implementation = ErrorResponse1::class))]
            )
        ]
    )
    @PostMapping("/add")
    fun createCustomer(@Valid @org.springframework.web.bind.annotation.RequestBody request: CustomerRequest)
            : ResponseEntity<RetCustAdd> {
        validationService.validateMaritalStatus(request.requestData.retCustAdd.relatedDetails.maritalStatus)

        val customerId = "CUS" + System.currentTimeMillis()
        val response = RetCustAdd(
            retCustDetails = CustDetails(
                custId = customerId,
                desc = "Customer created successfully",
                entity = "CUSTOMER",
                service = "ADD",
                status = "SUCCESS"
            )
        )
        return ResponseEntity.ok(response)
    }
}

@Schema(description = "Error response model")
data class ErrorResponse(
    @field:Schema(description = "Bad Request", example = "Invalid input data")
    val message: String,

    @field:Schema(description = "Error code", example = "400")
    val code: Int
)
@Schema(description = "Error response model")
data class ErrorResponse1(
    @field:Schema(description = "Internal Server Error", example = "Internal Server Error")
    val message: String,

    @field:Schema(description = "Error code", example = "503")
    val code: Int
)
