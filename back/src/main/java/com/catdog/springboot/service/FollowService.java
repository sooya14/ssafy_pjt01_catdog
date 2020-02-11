package com.catdog.springboot.service;


import com.catdog.springboot.domain.follow.Follow;
import com.catdog.springboot.domain.follow.FollowRepository;
import com.catdog.springboot.domain.user.User;
import com.catdog.springboot.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class FollowService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    @Transactional
    public void save(String follower, String following) {
        User followeruser = userRepository.findAllByNickname(follower);
        User followinguser = userRepository.findAllByNickname(following);
        followRepository.save(Follow.builder().follower(followeruser).following(followinguser).build());
    }

}