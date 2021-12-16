package com.codeup.springblog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

public class MathController {

    @GetMapping("/add/{x}/and/{y}")
    @ResponseBody
    public int addNum(@PathVariable int x, @PathVariable int y){
        return  x + y;
    }
    @GetMapping("/subtract/{x}/and/{y}")
    @ResponseBody
    public int subNum(@PathVariable int x, @PathVariable int y){
        return  y - x;
    }
    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public int multiplyNum(@PathVariable int x, @PathVariable int y){
        return  x * y;
    }
    @GetMapping("/divide/{x}/and/{y}")
    @ResponseBody
    public int divideNum(@PathVariable int x, @PathVariable int y){
        return  x / y;
    }
}
