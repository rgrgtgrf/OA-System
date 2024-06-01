package com.lanshan.Result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageResult {
    private boolean System;
    private Object message;
    private String fromName;
}
