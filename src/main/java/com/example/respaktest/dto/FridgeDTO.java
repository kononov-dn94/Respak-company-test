package com.example.respaktest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FridgeDTO {

    @Schema(description = "Fridge name", example = "Beko")
    private String name;

    @Schema(description = "Fridge seriesNumber", example = "JEHWFJW132HEF1892")
    private String seriesNumber;

    @Schema(description = "Fridge color", example = "green")
    private String color;

    @Schema(description = "Fridge size", example = "150")
    private Integer size;

    @Schema(description = "Fridge price", example = "50000")
    private Integer price;

    @Schema(description = "Fridge doorsNumber", example = "1")
    private Integer doorsNumber;

    @Schema(description = "Fridge compressorType", example = "piston")
    private String compressorType;

    @Schema(description = "Fridge availability", example = "true")
    private Boolean availability;
}
