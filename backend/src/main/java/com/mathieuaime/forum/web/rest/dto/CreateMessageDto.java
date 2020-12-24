package com.mathieuaime.forum.web.rest.dto;

import java.util.UUID;
import lombok.Data;

@Data
public class CreateMessageDto {
  private UUID topicId;

  private String text;
}
