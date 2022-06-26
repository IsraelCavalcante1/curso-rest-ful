package br.com.erudio.restcurso.services;

import br.com.erudio.restcurso.exceptions.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    private final String UNSUPPORTED_MATH_OPERATION_EXCEPTION = "Please set a numeric value";

    public Double sum(String numberOne, String numberTwo){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException(UNSUPPORTED_MATH_OPERATION_EXCEPTION);
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    public Double subtraction(String numberOne, String numberTwo){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException(UNSUPPORTED_MATH_OPERATION_EXCEPTION);
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    public Double multiply(String numberOne, String numberTwo){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException(UNSUPPORTED_MATH_OPERATION_EXCEPTION);
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    public Double division(String numberOne, String numberTwo){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException(UNSUPPORTED_MATH_OPERATION_EXCEPTION);
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    public Double mean(String numberOne, String numberTwo){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException(UNSUPPORTED_MATH_OPERATION_EXCEPTION);
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    public Double squareRoot(String number){
        if (!isNumeric(number)){
            throw new UnsupportedMathOperationException(UNSUPPORTED_MATH_OPERATION_EXCEPTION);
        }
        return Math.sqrt(convertToDouble(number));
    }

    public Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    public boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;

        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }

}
