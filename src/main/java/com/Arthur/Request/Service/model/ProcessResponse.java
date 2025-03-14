package com.Arthur.Request.Service.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Hello world request", required = true)
public final class ProcessResponse {

    @Schema(description = "Hello with provided name", example = "Hello Arthur")
    private String helloResponse;
}

