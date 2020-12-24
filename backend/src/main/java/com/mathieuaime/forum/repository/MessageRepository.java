package com.mathieuaime.forum.repository;

import com.mathieuaime.forum.model.Message;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, UUID> {
  Page<Message> findByTopicId(Pageable pageable, UUID topicId);

  void deleteByTopicId(UUID topicId);
}
