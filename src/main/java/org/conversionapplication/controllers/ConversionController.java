package org.conversionapplication.controllers;

import org.conversionapplication.conversionservice.NumeralCollection;
import org.conversionapplication.interfaces.NumeralInterface;
import org.conversionapplication.model.Conversion;
import org.conversionapplication.model.PostDto;
import org.springframework.web.bind.annotation.*;
import org.util.CustomErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiParam;

/**
 * Controller holding the REST API endpoints for the conversion
 */


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
            @RequestParam(value = "source", required = false) String source,
            @RequestParam(value = "target", required = false) String target,
            @RequestParam(value = "number", required = false) String number,
/*
// value parameter conflicts with open api
            @RequestParam(value = "Source numeral system from which to convert", required = false) String source,
            @RequestParam(value = "Target numeral system into which the conversion is made", required = false) String target,
            @RequestParam(value = "Number string that should be converted", required = false) String number,
*/

            Model model){
        System.out.println(number + ":" + source + ":" + target);
        if(number == null && source == null && target == null){
            return new ResponseEntity(new CustomErrorType("no conversion"), HttpStatus.BAD_REQUEST);
        }
        Conversion conversion = new Conversion(source, number, target);
        NumeralCollection numeralCollection = new NumeralCollection();
        NumeralInterface numeral = numeralCollection.getNumeral(source);
        conversion.setTargetNumber(numeral.convert(target, number));
        return new ResponseEntity<Conversion>(conversion, HttpStatus.OK);

    }

    @ApiOperation(value = "Endpoint for numeral conversion.", response = Conversion.class)
    @ApiResponses(value={
            @ApiResponse(code=200, message = "Successfully converted number")
    })
    @RequestMapping(method = RequestMethod.POST, value="/api/conversion", consumes="application/json", produces="application/json")
//    @ResponseBody
    public ResponseEntity conversion(
            @RequestBody PostDto postDto){
        Conversion conversion = new Conversion(postDto.getSource(), postDto.getNumber(), postDto.getTarget());
        NumeralCollection numeralCollection = new NumeralCollection();
        NumeralInterface numeral = numeralCollection.getNumeral(postDto.getSource());
        conversion.setTargetNumber(numeral.convert(postDto.getTarget(), postDto.getNumber()));
        return new ResponseEntity<Conversion>(conversion, HttpStatus.OK);
    }


}
