package com.calculadora;

import org.springframework.web.bind.annotation.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CalculadoraController {

    @PostMapping("/calcular")
    public Map<String, String> calcular(@RequestBody Map<String, String> body) {
        String expressao = body.get("expressao");
        Map<String, String> resposta = new HashMap<>();
        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
            Object resultado = engine.eval(expressao);
            resposta.put("resultado", String.valueOf(resultado));
        } catch (Exception e) {
            resposta.put("resultado", "Erro");
        }
        return resposta;
    }
}
