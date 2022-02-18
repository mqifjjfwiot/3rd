package com.example.rd.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@ToString
@Entity
public class SampleArticle {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    // 이 기본 생성자는 필수기 때문에 아래것과 별개로 살려둬야 함
    public SampleArticle(){ }

    //public SampleArticle(Long id, String title, String content) {
    //    this.id = id;
    //    this.title = title;
    //    this.content = content;
    //}

    //@Override
    //public String toString() {
    //    return "SampleArticle{" +
    //            "id=" + id +
    //            ", title='" + title + '\'' +
    //            ", content='" + content + '\'' +
    //            '}';
    //}

    // 여기도 롬복 화. 방식은 DTO와 동일.
}
