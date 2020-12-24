package com.mathieuaime.forum.web.rest;

import com.mathieuaime.forum.model.Message;
import com.mathieuaime.forum.model.Topic;
import com.mathieuaime.forum.repository.MessageRepository;
import com.mathieuaime.forum.web.rest.dto.CreateMessageDto;
import com.mathieuaime.forum.web.rest.dto.MessageDto;
import com.mathieuaime.forum.web.rest.mapper.MessageMapper;
import java.net.URI;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/messages")
public class MessageResource {
  private final MessageRepository messageRepository;

  public MessageResource(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  @PostMapping
  public ResponseEntity<MessageDto> create(@RequestBody CreateMessageDto createMessageDto) {
    Message message = MessageMapper.toEntity(createMessageDto);
    message = messageRepository.save(message);
    URI location = URI.create("/messages/" + message.getId());
    return ResponseEntity.created(location).body(MessageMapper.toDto(message));
  }

  @PutMapping
  public ResponseEntity<MessageDto> update(@RequestBody CreateMessageDto createMessageDto) {
    Message message = MessageMapper.toEntity(createMessageDto);
    message = messageRepository.save(message);
    return ResponseEntity.ok(MessageMapper.toDto(message));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Topic> deleteById(@PathVariable UUID id) {
    this.messageRepository.findById(id).ifPresent(messageRepository::delete);
    return ResponseEntity.noContent().build();
  }
}
