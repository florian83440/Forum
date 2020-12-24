package com.mathieuaime.forum.web.rest.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class MessageDto {
  private UUID id;

  private String text;

  private LocalDateTime createdDate;

  private String createdBy;

  private LocalDateTime lastModifiedDate;

  private String lastModifiedBy;
}
