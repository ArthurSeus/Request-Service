package com.Arthur.Request.Service.restapi;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Schema(description = "Hello world request", required = true)
public final class RequestRequest {

        @Size(max = 25)
        @Schema(description = "Hello World name", example = "Arthur", defaultValue = "World")
        private String name;

        @Size(max = 300)
        @Schema(description = "Delay in seconds for the name to be added", example = "30", defaultValue = "10")
        private int delay;
}
