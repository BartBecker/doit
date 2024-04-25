package dev.bart.doit.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

public record PostIt(
        @Id
        Integer id,
        @NotBlank
        String title,
        @NotBlank
        String description,
        @NotNull
        Status status,
        @NotNull
        Difficulty difficulty,
        @NotNull
        Integer timeNeeded,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated
) {
}
