package com.act.techtalk2022.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAttenderRequest {
    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("date_of_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

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
