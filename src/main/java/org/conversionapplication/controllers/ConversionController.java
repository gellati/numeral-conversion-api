package org.conversionapplication.controllers;

import org.conversionapplication.conversionservice.NumeralCollection;
import org.conversionapplication.interfaces.NumeralInterface;
import org.conversionapplication.model.Conversion;
import org.conversionapplication.model.PostDto;
import org.springframework.web.bind.annotation.*;
import org.conversionapplication.util.CustomErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Controller holding the REST API endpoints for the conversion
 *     //         ?number={n}&source={source}&target={target}
 *
 */


@RestController
@Tag(name = "conversion service")
public class ConversionController {

    static Logger logger = Logger.getLogger(ConversionController.class.getName());

    @Operation(summary = "Basic description of the api")
    @GetMapping("/api")
    public String index() {
        return "The org system converter";
    }

    @Operation(summary = "Endpoint for numeral conversion.")
    @ApiResponses(value={
            @ApiResponse(responseCode="200", description = "Successfully converted number")
    })
    @GetMapping(value = "/api/conversion", produces="application/json")
    // public ResponseEntity<Conversion> conversion(
    public ResponseEntity<String> conversion(
            @RequestParam(value = "source", required = false) String source,
            @RequestParam(value = "target", required = false) String target,
            @RequestParam(value = "number", required = false) String number
/*
// value parameter conflicts with open api
            @RequestParam(value = "Source numeral system from which to convert", required = false) String source,
            @RequestParam(value = "Target numeral system into which the conversion is made", required = false) String target,
            @RequestParam(value = "Number string that should be converted", required = false) String number,
*/

            // Model model
            ){
                // System.out.println(String.format("%i : %s : %s", number, source, target));
                if(logger.isLoggable(Level.ALL)) {
                    logger.log(Level.INFO, String.format("%i : %s : %s", number, source, target));
                }
                if(
                    number == null && source == null && target == null
                ){
                    return new ResponseEntity<CustomErrorType, String>(new CustomErrorType("no conversion"), HttpStatus.BAD_REQUEST);
                    // return new ResponseEntity<>("all null2", HttpStatus.OK);
                }

                // Conversion conversion = new Conversion("decimal", "2", "roman");
                // NumeralCollection numeralCollection = new NumeralCollection();
                // NumeralInterface numeral = numeralCollection.getNumeral("decimal");
                // conversion.setTargetNumber(numeral.convert("roman", "2"));
                // return new ResponseEntity<>(conversion.getTargetNumber(), HttpStatus.OK);
                // return new ResponseEntity<>("hello", HttpStatus.OK);



                Conversion conversion = new Conversion(source, number, target);
                NumeralCollection numeralCollection = new NumeralCollection();
                NumeralInterface numeral = numeralCollection.getNumeral(source);
                conversion.setTargetNumber(numeral.convert(target, number));
                // return new ResponseEntity<Conversion>(conversion, HttpStatus.OK);
                return new ResponseEntity<>(conversion.getTargetNumber(), HttpStatus.OK);

    }

    @Operation(summary = "Endpoint for numeral conversion.")
    @ApiResponses(value={
            @ApiResponse(responseCode="200", description = "Successfully converted number")
    })
    @PostMapping(value="/api/conversion", consumes="application/json", produces="application/json")
    public ResponseEntity<Conversion> conversion(
            @RequestBody PostDto postDto){
        Conversion conversion = new Conversion(postDto.getSource(), postDto.getNumber(), postDto.getTarget());
        NumeralCollection numeralCollection = new NumeralCollection();
        NumeralInterface numeral = numeralCollection.getNumeral(postDto.getSource());
        conversion.setTargetNumber(numeral.convert(postDto.getTarget(), postDto.getNumber()));
        return new ResponseEntity<>(conversion, HttpStatus.OK);
    }
}
