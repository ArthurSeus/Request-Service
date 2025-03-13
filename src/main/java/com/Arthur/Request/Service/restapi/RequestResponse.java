package com.Arthur.Request.Service.restapi;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Hello world request", required = true)
public final class RequestResponse {

    @Schema(description = "Hello with provided name", example = "Hello Arthur")
    private String helloResponse;
}

