package com.example.calculator.controllers;

import ch.qos.logback.core.model.Model;
import com.example.calculator.model.CalculationRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.calculator.service.ClaculatorService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @Autowired
    private ClaculatorService calculatorService;

    @GetMapping
    public String showCalculator(Model model) {
        model.addAttribute("calculationRequest", new CalculationRequest());
        return "calculator";
    }

    @PostMapping("/calculate")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> calculate(@Valid @RequestBody CalculationRequest request) {
        Map<String, Object> response = new HashMap<>();

        try {
            double result = calculatorService.calculate(
                    request.getOperand1(),
                    request.getOperand2(),
                    request.getOperation()
            );

            response.put("success", true);
            response.put("result", result);
            response.put("operation", request.getOperation());
            response.put("operand1", request.getOperand1());
            response.put("operand2", request.getOperand2());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/sqrt")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> sqrt(@RequestParam double operand) {
        Map<String, Object> response = new HashMap<>();

        try {
            double result = calculatorService.sqrt(operand);
            response.put("success", true);
            response.put("result", result);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/percentage")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> percentage(@RequestParam double operand) {
        Map<String, Object> response = new HashMap<>();

        try {
            double result = calculatorService.percentage(operand);
            response.put("success", true);
            response.put("result", result);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
