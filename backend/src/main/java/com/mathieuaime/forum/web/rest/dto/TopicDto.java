package com.mathieuaime.forum.web.rest.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopicDto {
  private UUID id;

  private String title;

  private LocalDateTime createdDate;

  private String createdBy;
}
