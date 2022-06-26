package br.com.erudio.restcurso.controllers;

import br.com.erudio.restcurso.exceptions.UnsupportedMathOperationException;
import br.com.erudio.restcurso.services.MathService;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private final String UNSUPPORTED_MATH_OPERATION_EXCEPTION = "Please set a numeric value";
    private final AtomicLong counter = new AtomicLong();

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo")
    String numberTwo) throws Exception {

        return mathService.sum(numberOne, numberTwo);
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo")
    String numberTwo) throws Exception {

        return mathService.subtraction(numberOne, numberTwo);
    }

    @RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiply(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        return mathService.multiply(numberOne, numberTwo);
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        return mathService.division(numberOne, numberTwo);
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return mathService.mean(numberOne, numberTwo);
    }

    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "number") String number) throws Exception {
        return mathService.squareRoot(number);
    }
}
