package com.swagger.documentation.shivalik.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springdoc.core.models.GroupedOpenApi

@Configuration
class OpenAPIConfig {

    @Bean
    fun shivalikBankAPI(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("Shivalik Small Finance Bank API")
            .pathsToMatch("/RetCustAdd/add/**", "/api/PanVerification/**")
            .addOpenApiCustomizer { openApi ->
                openApi.info(
                    Info()
                        .title("Shivalik Small Finance Bank API")
                        .version("1.2.0")
                        .description(
                            """
                            📌 API Documentation for Shivalik Bank  
                            
                            ---
                            🔄 Version History:
                            - **v1.2.0 (Latest)**
                              - Added PAN verification API
                              - Improved error handling and response structure
                            - **v1.1.0**
                              - Enhanced security and authentication handling
                            - **v1.0.0**
                              - Initial API release with customer addition
                            ---
                            """.trimIndent()
                        )
                )
            }
            .build()
    }
}
