package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalculatorController {

    @RequestMapping(value="/calculator.do",method= RequestMethod.GET)
    public String handleCalculator(){
        System.out.println("CalculatorController.handleCalculator");
        return "calculator";
    }
}
