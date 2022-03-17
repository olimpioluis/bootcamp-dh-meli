package br.com.meli.exercicio02.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class ConversorMorseToPortugueseController {


    private final List<String> morseCode = new ArrayList<>(Arrays.asList(
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--... ", "---..", "----.", "-----", "..--..", "-.-.--", ".-.-.-", "--..--"
    ));

    private final char[] symbols = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.', ','
    };

    @GetMapping("/sentences")
    @ResponseBody
    public String convertSentenceMorseToPortugueseCode(@RequestParam String sentence) {
        StringBuilder sentenceInPortuguese = new StringBuilder();

        if (sentence != null) {
            String[] senteceSplitted = sentence.split(" ");

            for (int i = 0; i < senteceSplitted.length; i++) {
                if (senteceSplitted[i].equals("") && senteceSplitted[i + 1].equals("")) {
                    sentenceInPortuguese.append(" ");
                } else {
                    int findWordIndex = morseCode.indexOf(senteceSplitted[i]);

                    if (findWordIndex != -1) {
                        sentenceInPortuguese.append(symbols[findWordIndex]);
                    }
                }

            }

            return sentenceInPortuguese.toString();
        }

        return "Nenhum valor informado";
    }
}
