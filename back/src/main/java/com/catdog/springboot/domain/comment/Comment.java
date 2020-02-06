package com.catdog.springboot.domain.comment;
import com.catdog.springboot.domain.posts.Posts;
import com.catdog.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid; // Comment ID
    @ManyToOne
    @JoinColumn(name = "uid") // 유저 번호
    private User user;
    @ManyToOne
    @JoinColumn(name = "pid") // 게시글 번호
    private Posts posts;
    @Column
    private String content; // 글 내용
    @Column
    private String wdate; // 작성 시간
    @Builder
    public Comment(User user, Posts posts , String content , String wdate) {
        this.user = user;
        this.posts = posts;
        this.content = content;
        this.wdate = wdate;
    }
}