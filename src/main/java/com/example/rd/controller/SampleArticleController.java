package com.example.rd.controller;

import com.example.rd.DTO.SampleArticleForm;
import com.example.rd.entity.SampleArticle;
import com.example.rd.repository.SampleArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class SampleArticleController {

    @Autowired
    // 스프링 부트가 미리 생성해 놓은 객체를 가져다가 자동으로 연결. 밑에 save기능을 이용하기 위해선 사전에 의존성 연결을 해둬야 하는것같다.
    private SampleArticleRepository saRepository;

    @GetMapping("/sampleArticle/article")
    public String sampleArticle() {
        return "sampleArticle/sampleArticle";
    }

    // sampleArticle/sampleArticle 에서 submit 받은 값을 post 해 오기 위하여 postmaapping annotation 한다.
    // 타 페이지의 데이터를 받아와야 하기 때문에 받아올 데이터의 '틀' DTO가 필요하다.
    @PostMapping("sampleArticle/create")
    // DTO(SampleArticleForm)에서 폼 내부의 비밀 상자에 담긴 값을 기록한 문장을 리턴받았음. 아래에서 파라미터로 받은 form이 그것.
    public String createArticle(SampleArticleForm form) {
        //System.out.println(form.toString());
        //SampleArticleForm{title='111', content='sad'}
        log.info(form.toString());

        // DB에 DTO정보를 입력하기 위해 entity 변환
        // SampleArticle 이라는 새 객체에 form 내용물 변환, 저장. saf
        SampleArticle saf = form.toEntity();
        //System.out.println(saf.toString());
        log.info(saf.toString());

        // Repository에게 Entity를 DB안에 저장하게 함.
        SampleArticle sa = saRepository.save(saf);
        //System.out.println(sa.toString());
        log.info(sa.toString());

        // SampleArticleForm{title='123124', content='sdwe'}
        // SampleArticle{id=null, title='123124', content='sdwe'}
        // SampleArticle{id=1, title='123124', content='sdwe'}
        // 최초에 입력받았던 값을 DTO에 넣기만 했던 form은 title, content만 존재.
        // Entity에 의해 pk나 마찬가지인 id 칼럼을 새로 배정받음. 입력받은 값이 없기에 당연히 null. 하지만 자동 번호 부여 annotation인 @GeneratedValue가 부여되어있는 상태.
        // 그래서 repository에 의해 DB저장이 된 뒤에 새 id인 1을 배정받게 된다.


        // syslog대신 logging을 사용하기 위해선 @Slf4j 를 사용해야 함.

        return "";
    }



}
