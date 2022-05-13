package com.jojoldu.webservice.domain.repository;

import com.jojoldu.webservice.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("select p from Posts p order by p.id desc ")
    Stream<Posts> findAllDesc();
}
