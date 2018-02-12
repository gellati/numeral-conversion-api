package org.conversionapplication.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import io.swagger.annotations.ApiModelProperty;

/**
 * Class to hold data about the number conversion
 *
 */

public class Conversion {

    @ApiModelProperty(dataType = "java.lang.String", example = "decimal", required = true,  value = "The source number's numeral system")
    private String sourceNumeralSystem;
    @ApiModelProperty(dataType = "java.lang.String", example = "6",       required = true,  value = "The number to be converted")
    private String sourceNumber;
    @ApiModelProperty(dataType = "java.lang.String", example = "roman",   required = true,  value = "The target system into which the number should be converted")
    private String targetNumeralSystem;
    @ApiModelProperty(dataType = "java.lang.String", example = "VI",      required = false, value = "The converted number")
    private String targetNumber;

    public Conversion(){}

    /**
     * Initialization with data needed for the conversion.
     *
     * @param sourceNumeralSystem The source number's numeral system
     * @param sourceNumber        The number to be converted
     * @param targetNumeralSystem The target system into which the number should be converted
     */

    public Conversion(String sourceNumeralSystem, String sourceNumber, String targetNumeralSystem){
        this.sourceNumber = sourceNumber;
        this.sourceNumeralSystem = sourceNumeralSystem;
        this.targetNumeralSystem = targetNumeralSystem;
    }

    public void setSourceNumeralSystem(String sourceNumeralSystem) {
        this.sourceNumeralSystem = sourceNumeralSystem;
    }

    public void setSourceNumber(String sourceNumber) {
        this.sourceNumber = sourceNumber;
    }

    public void setTargetNumeralSystem(String targetNumeralSystem) {
        this.targetNumeralSystem = targetNumeralSystem;
    }

    public void setTargetNumber(String targetNumber) {
        this.targetNumber = targetNumber;
    }

    public String getSourceNumeralSystem() {
        return sourceNumeralSystem;
    }

    public String getSourceNumber() {
        return sourceNumber;
    }

    public String getTargetNumeralSystem() {
        return targetNumeralSystem;
    }

    public String getTargetNumber() {
        return targetNumber;
    }

    @Override
    public String toString() {
        return "Conversion{" +
                "sourceNumeralSystem='" + sourceNumeralSystem + '\'' +
                ", sourceNumber='" + sourceNumber + '\'' +
                ", targetNumeralSystem='" + targetNumeralSystem + '\'' +
                ", targetNumber='" + targetNumber + '\'' +
                '}';
    }

}
