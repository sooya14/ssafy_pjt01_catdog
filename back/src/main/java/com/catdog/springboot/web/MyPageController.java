package com.catdog.springboot.web;

import com.catdog.springboot.domain.follow.FollowRepository;
import com.catdog.springboot.domain.posts.Posts;
import com.catdog.springboot.domain.posts.PostsRepository;
import com.catdog.springboot.domain.user.User;
import com.catdog.springboot.domain.user.UserRepository;
import com.catdog.springboot.web.dto.MyPageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MyPageController {

    private final UserRepository userRepository;
    private final PostsRepository postsRepository;
    private final FollowRepository followRepository;

    @GetMapping("/MyPage/{id}")
    public MyPageResponseDto MyPage(@PathVariable String id) {
        Optional<User> user = userRepository.findByEmail(id);
        Long uid = user.get().getUid();
        Long post_cnt = postsRepository.cnt_post(uid);
        Long follow_from = followRepository.follow_F_Count(uid);
        Long follow_to = followRepository.follow_T_Count(uid);
        List<Posts> postsList = postsRepository.postList(uid);

        MyPageResponseDto mypage = new MyPageResponseDto(uid, post_cnt, follow_from, follow_to , postsList);

        System.out.println(mypage.getUid());
        System.out.println(mypage.getPost_cnt());
        System.out.println(mypage.getFollow_from());
        System.out.println(mypage.getFollow_to());
        System.out.println(mypage.getPostsList());

        return mypage;
    }
}
