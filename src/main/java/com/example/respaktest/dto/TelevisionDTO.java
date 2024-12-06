package com.example.respaktest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TelevisionDTO {

    @Schema(description = "Television name", example = "LG")
    private String name;

    @Schema(description = "Television seriesNumber", example = "EIOWFIWE901290DWQKLQWK")
    private String seriesNumber;

    @Schema(description = "Television color", example = "red")
    private String color;

    @Schema(description = "Television size", example = "32")
    private Integer size;

    @Schema(description = "Television price", example = "120000")
    private Integer price;

    @Schema(description = "Television category", example = "office")
    private String category;

    @Schema(description = "Television technology", example = "3D")
    private String technology;

    @Schema(description = "Television availability", example = "false")
    private Boolean availability;
}
