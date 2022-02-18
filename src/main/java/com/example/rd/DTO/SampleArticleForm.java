package com.example.rd.DTO;

import com.example.rd.entity.SampleArticle;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class SampleArticleForm {

    // 운송할때만 개인적으로 쓰이고 버려지기 때문에, 중간에 가로채이지 않도록 private화
    private String title;
    private String content;

    // 롬복 베이스로 수리. 비활성화
    // 생성자를 이용해 위에서 만든 비공개 상자 title, content칸에 받아온 데이터 이식.
    // public SampleArticleForm(String title, String content) {
    // this.title = title;
    // this.content = content;
    // }

    // 롬복 베이스로 수리. 비활성화.
    // 만든 '결과물'을 스트링 형태로 출력. 테스트용.
    //@Override
    //public String toString() {
    //    return "SampleArticleForm{" +
    //            "title='" + title + '\'' +
    //           ", content='" + content + '\'' +
    //            '}';
    //}

    public SampleArticle toEntity() {
        return new SampleArticle(null, title, content);
    }

    // 롬복 베이스로 수리 시작.
    // 1. toString anno화
    // 2. 생성자 @AllArgsConstructor로 대체

}
