package com.jojoldu.webservice.service;

import com.jojoldu.webservice.domain.dto.PostsSaveRequestDto;
import com.jojoldu.webservice.domain.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }
}
