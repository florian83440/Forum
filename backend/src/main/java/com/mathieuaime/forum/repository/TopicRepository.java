package com.mathieuaime.forum.repository;

import com.mathieuaime.forum.model.Topic;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, UUID> {
}
