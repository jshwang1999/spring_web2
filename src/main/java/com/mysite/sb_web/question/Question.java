package com.mysite.sb_web.question;

import com.mysite.sb_web.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


// 글 번호(id, int, AUTO_INCREMENT, PRIMARY_KEY),
// 제목(subject, String, 최대 길이 200),
// 내용(content, String, 길이 제한 없음)
// 작성시간(createDate, LocalTimeDate)

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}
