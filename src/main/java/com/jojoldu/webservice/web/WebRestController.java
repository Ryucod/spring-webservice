package com.jojoldu.webservice.web;

import com.jojoldu.webservice.domain.dto.PostsSaveRequestDto;
import com.jojoldu.webservice.domain.repository.PostsRepository;
import com.jojoldu.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
public class WebRestController {

    private PostsRepository postsRepository;
    private PostsService postsService;

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        log.info("dto::{}", dto);
        log.info("dto.toEntity()::{}", dto.toEntity());
//        postsRepository.save(dto.toEntity());
        return postsService.save(dto);
    }
}
