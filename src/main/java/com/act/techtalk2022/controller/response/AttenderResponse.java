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
public class AttenderResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("date_of_birth")
    private String dateOfBirth;

    @JsonProperty("avatar")
    private String avatar;

    @JsonProperty("organization")
    private String organization;

    @JsonProperty("role")
    private String role;

    @JsonProperty("months_of_experience")
    private Integer monthsOfExperience;

    @JsonProperty("is_join_experience_section")
    private Boolean isJoinExperienceSection;
}

