package com.example.respaktest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SmartphoneDTO {

    @Schema(description = "Smartphone name", example = "Xiaomi")
    private String name;

    @Schema(description = "Smartphone seriesNumber", example = "LWFKWEFK12QWFQ31-0DW")
    private String seriesNumber;

    @Schema(description = "Smartphone color", example = "silver")
    private String color;

    @Schema(description = "Smartphone size", example = "5")
    private Integer size;

    @Schema(description = "Smartphone price", example = "30000")
    private Integer price;

    @Schema(description = "Smartphone memory", example = "32")
    private Integer memory;

    @Schema(description = "Smartphone camerasNumber", example = "4")
    private Integer camerasNumber;

    @Schema(description = "Smartphone availability", example = "true")
    private Boolean availability;
}
