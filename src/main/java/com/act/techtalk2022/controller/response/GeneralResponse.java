package com.act.techtalk2022.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponse<T> {
    @JsonProperty("status")
    private ResponseStatus status;

    @JsonProperty("data")
    private T data;
}
