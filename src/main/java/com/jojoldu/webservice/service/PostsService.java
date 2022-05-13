package com.jojoldu.webservice.service;

import com.jojoldu.webservice.domain.dto.PostsMainResponseDto;
import com.jojoldu.webservice.domain.dto.PostsSaveRequestDto;
import com.jojoldu.webservice.domain.repository.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
//    @Autowired
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc(){
        postsRepository.findAllDesc().forEach((data) -> data.getAuthor());

        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
