package com.example.respaktest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class VacuumCleanerDTO {

    @Schema(description = "Fridge name", example = "Dyson")
    private String name;

    @Schema(description = "Fridge seriesNumber", example = "EGHFHW387JEFJ783W3")
    private String seriesNumber;

    @Schema(description = "Fridge color", example = "green")
    private String color;

    @Schema(description = "Fridge size", example = "10")
    private Integer size;

    @Schema(description = "Fridge price", example = "20000")
    private Integer price;

    @Schema(description = "Fridge containerVolume", example = "2")
    private Integer containerVolume;

    @Schema(description = "Fridge numberModes", example = "4")
    private Integer numberModes;

    @Schema(description = "Fridge availability", example = "false")
    private Boolean availability;
}
