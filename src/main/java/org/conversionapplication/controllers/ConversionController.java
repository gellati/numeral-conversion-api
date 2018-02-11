package org.conversionapplication.controllers;

import org.conversionapplication.conversionservice.NumeralCollection;
import org.conversionapplication.interfaces.NumeralInterface;
import org.conversionapplication.model.Conversion;
import org.util.CustomErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@Api(value="numberconversion", description="Number conversion operations")
public class ConversionController {

    @ApiOperation(value = "Basic description of the api", response = String.class)
    @RequestMapping(method= RequestMethod.GET, value= "/api")
    public String index() {
        return "The org system converter";
    }

    //         ?number={n}&source={source}&target={target}
    @ApiOperation(value = "Endpoint for numeral conversion.", response = Conversion.class)
    @ApiResponses(value={
            @ApiResponse(code=200, message = "Successfully converted number")
    })
    @RequestMapping(method=RequestMethod.GET, value="/api/conversion", produces="application/json")
    public ResponseEntity conversion(
            @RequestParam(value = "Source numeral system from which to convert", required = true) String source,
            @RequestParam(value = "Target numeral system into which the conversion is made", required = true) String target,
            @RequestParam(value = "Number that should be converted", required = true) String number,
            Model model){
        if(number == null && source == null && target == null){
            return new ResponseEntity(new CustomErrorType("no conversion"), HttpStatus.I_AM_A_TEAPOT);
        }
        Conversion conversion = new Conversion(source, number, target);
        NumeralCollection numeralCollection = new NumeralCollection();
        NumeralInterface numeral = numeralCollection.getNumeral(source);
        conversion.setTargetNumber(numeral.convert(target, number));
        return new ResponseEntity<Conversion>(conversion, HttpStatus.OK);

    }

}
