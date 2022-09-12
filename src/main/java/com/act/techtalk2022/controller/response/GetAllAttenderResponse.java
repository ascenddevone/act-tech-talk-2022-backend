package com.act.techtalk2022.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAttenderResponse {
    @JsonProperty("attenders")
    private List<AttenderResponse> attenders;
}
