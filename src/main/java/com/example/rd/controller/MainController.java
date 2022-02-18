package com.example.rd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // /hello 쿼리가 추가되면 끌어와 매핑
    @GetMapping("/hello")
    // 이어 hellosample 메소드 발동. 모델 파라미터도 받아온다.
    public String hellosample(Model model) {
        // 파라미터로 받아온 모델 객체에 값 추가. 만들어온 빈 상자에 내용물 채우기
        // 앞은 key, 뒤는 value
        model.addAttribute("name", "김가네");
        // templates/hello 로 연결해줌
        return "hello";
    }

    @GetMapping("/sample2")
    public String sample2(Model model) {
        model.addAttribute("name","박가네");
        return "sample2";
    }

    @GetMapping("/sampleArticle")
    public String sampleArticle() {
        //model.addAttribute("name","박가네");
        return "sampleArticle/sampleArticle";
    }
}
