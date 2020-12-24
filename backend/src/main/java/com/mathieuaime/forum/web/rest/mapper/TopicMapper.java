package com.mathieuaime.forum.web.rest.mapper;

import com.mathieuaime.forum.model.Topic;
import com.mathieuaime.forum.web.rest.dto.TopicDto;

public class TopicMapper {
  public static TopicDto toDto(Topic topic) {
    TopicDto topicDto = new TopicDto();
    topicDto.setId(topic.getId());
    topicDto.setTitle(topic.getTitle());
    topicDto.setCreatedBy(topic.getCreatedBy());
    topicDto.setCreatedDate(topic.getCreatedDate());
    return topicDto;
  }

  public static Topic toEntity(TopicDto topicDto) {
    return Topic.builder()
        .id(topicDto.getId())
        .title(topicDto.getTitle())
        .build();
  }
}
