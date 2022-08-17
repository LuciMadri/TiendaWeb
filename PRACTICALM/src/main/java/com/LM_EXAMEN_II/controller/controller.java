/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.LM_EXAMEN_II.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author madri
 */

@Controller
public class controller {
    
    @GetMapping("/ejemplo")
    public String ejemplo(Model model) {

        return "ejemplo";
    }
    
    @GetMapping("/home")
    public String home(Model model) {

        return "home";
    }
}
