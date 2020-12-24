package com.mathieuaime.forum.web.rest.mapper;

import com.mathieuaime.forum.model.Message;
import com.mathieuaime.forum.model.Topic;
import com.mathieuaime.forum.web.rest.dto.CreateMessageDto;
import com.mathieuaime.forum.web.rest.dto.MessageDto;

public class MessageMapper {
  public static MessageDto toDto(Message message) {
    MessageDto messageDto = new MessageDto();
    messageDto.setId(message.getId());
    messageDto.setText(message.getText());
    messageDto.setCreatedBy(message.getCreatedBy());
    messageDto.setCreatedDate(message.getCreatedDate());
    messageDto.setLastModifiedDate(message.getLastModifiedDate());
    messageDto.setLastModifiedBy(message.getLastModifiedBy());
    return messageDto;
  }

  public static Message toEntity(CreateMessageDto createMessageDto) {
    Topic topic = Topic.builder().id(createMessageDto.getTopicId()).build();
    return Message.builder()
        .text(createMessageDto.getText())
        .topic(topic)
        .build();
  }
}
