package com.mathieuaime.forum.web.rest;

import com.mathieuaime.forum.model.Topic;
import com.mathieuaime.forum.service.TopicService;
import com.mathieuaime.forum.web.rest.dto.MessageDto;
import com.mathieuaime.forum.web.rest.dto.TopicDto;
import com.mathieuaime.forum.web.rest.mapper.MessageMapper;
import com.mathieuaime.forum.web.rest.mapper.TopicMapper;
import java.net.URI;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/topics")
public class TopicResource {
  private final TopicService topicService;

  public TopicResource(TopicService topicService) {
    this.topicService = topicService;
  }

  @GetMapping
  public Page<TopicDto> findAll(Pageable pageable) {
    return this.topicService.findAll(pageable).map(TopicMapper::toDto);
  }

  @GetMapping("/{id}/messages")
  public Page<MessageDto> findMessages(Pageable pageable, @PathVariable UUID id) {
    return this.topicService.findMessages(pageable, id).map(MessageMapper::toDto);
  }

  @PostMapping
  public ResponseEntity<TopicDto> create(@RequestBody TopicDto topicDto) {
    if (topicDto.getId() != null) {
      return ResponseEntity.badRequest().build();
    }

    Topic topic = TopicMapper.toEntity(topicDto);
    topic = this.topicService.save(topic);
    URI location = URI.create("/topics/" + topic.getId());
    return ResponseEntity.created(location).body(TopicMapper.toDto(topic));
  }

  @PutMapping
  public ResponseEntity<TopicDto> update(@RequestBody TopicDto topicDto) {
    Topic topic = TopicMapper.toEntity(topicDto);
    topic = this.topicService.save(topic);
    return ResponseEntity.ok(TopicMapper.toDto(topic));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Topic> deleteById(@PathVariable UUID id) {
    this.topicService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
