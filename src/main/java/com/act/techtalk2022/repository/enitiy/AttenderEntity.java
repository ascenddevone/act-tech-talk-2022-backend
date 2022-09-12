package com.act.techtalk2022.repository.enitiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "attender")
public class AttenderEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    @NotBlank
    @NonNull
    private String fullName;

    @Column(name = "email")
    @NotBlank
    @NonNull
    @Email
    private String email;

    @Column(name = "date_of_birth")
    @Past
    private Date dateOfBirth;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "organization")
    private String organization;

    @Column(name = "role")
    private String role;

    @Column(name = "months_of_experience")
    private Integer monthsOfExperience;

    @Column(name = "is_join_experience_section")
    private Boolean isJoinExperienceSection;

}
