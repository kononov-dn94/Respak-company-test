package com.example.respaktest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ComputerDTO {

    @Schema(description = "Computer name", example = "Apple")
    private String name;

    @Schema(description = "Computer seriesNumber", example = "WLX20360E1")
    private String seriesNumber;

    @Schema(description = "Computer color", example = "white")
    private String color;

    @Schema(description = "Computer size", example = "30")
    private Integer size;

    @Schema(description = "Computer price", example = "150000")
    private Integer price;

    @Schema(description = "Computer category", example = "work")
    private String category;

    @Schema(description = "Computer processorType", example = "CPU")
    private String processorType;

    @Schema(description = "Computer availability", example = "true")
    private Boolean availability;
}
