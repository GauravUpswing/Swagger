package com.swagger.documentation.shivalik.model.response


import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class RsData(
    @JsonProperty("RetCustAdd")
    val retCustAdd: RetCustAdd? = null,

    @JsonProperty("Status")
    val status: Status? = null
)

data class RetCustAdd(
    @JsonProperty("RetCustDetails")
    val retCustDetails: CustDetails
)

data class CustDetails(
    @JsonProperty("Message")
    val custId: String,
    @JsonProperty("Status")
    val desc: String,
    @JsonProperty("ReferenceID")
    val entity: String,
    @JsonProperty("Code")
    val service: String,
    @JsonProperty("Description")
    val status: String
)

data class Status(
    @JsonProperty("Status")
    val status: String,
    @JsonProperty("Message")
    val message: String,
    @JsonProperty("Code")
    val code: String,
    @JsonProperty("Description")
    val description: String
)
