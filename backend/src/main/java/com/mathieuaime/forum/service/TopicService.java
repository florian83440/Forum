package com.mathieuaime.forum.service;

import com.mathieuaime.forum.model.Message;
import com.mathieuaime.forum.model.Topic;
import com.mathieuaime.forum.repository.MessageRepository;
import com.mathieuaime.forum.repository.TopicRepository;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
  private final TopicRepository topicRepository;
  private final MessageRepository messageRepository;

  public TopicService(TopicRepository topicRepository, MessageRepository messageRepository) {
    this.topicRepository = topicRepository;
    this.messageRepository = messageRepository;
  }

  public Page<Topic> findAll(Pageable pageable) {
    return this.topicRepository.findAll(pageable);
  }

  public Page<Message> findMessages(Pageable pageable, UUID id) {
    return this.messageRepository.findByTopicId(pageable, id);
  }

  public Topic save(Topic topic) {
    return this.topicRepository.save(topic);
  }

  public void deleteById(UUID id) {
    this.messageRepository.deleteByTopicId(id);
    this.topicRepository.deleteById(id);
  }
}
