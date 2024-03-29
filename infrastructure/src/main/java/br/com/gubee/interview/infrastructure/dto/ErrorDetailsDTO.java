package br.com.gubee.interview.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetailsDTO {
    private Long timestamp;
    private int status;
    private String message;
    private String details;

}
