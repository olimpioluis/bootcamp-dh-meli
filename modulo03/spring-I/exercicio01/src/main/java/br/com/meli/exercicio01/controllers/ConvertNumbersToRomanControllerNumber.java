package br.com.meli.exercicio01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConvertNumbersToRomanControllerNumber {
    private static final int[] VALUES =
            {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMANS =
            {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    @GetMapping("/numbers")
    @ResponseBody
    public String convertNumberToRomanNumber(@RequestParam String number) {
        if (number != null) {
                int numberConverted;
            try{
                numberConverted = Integer.parseInt(number);
            } catch(NumberFormatException e) {
                return "O valor informado é inválido";
            }

            StringBuilder roman = new StringBuilder();

            for(int i=0; i<VALUES.length; i++) {
                while(numberConverted >= VALUES[i]) {
                    numberConverted -= VALUES[i];
                    roman.append(ROMANS[i]);
                }
            }

            return roman.toString();
        }

        return "Nenhum valor informado";
    }
}
