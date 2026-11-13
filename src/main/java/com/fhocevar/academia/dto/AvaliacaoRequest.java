package com.fhocevar.academia.dto;
import jakarta.validation.constraints.*;
public record AvaliacaoRequest(@NotNull Long alunoId,@NotNull @DecimalMin("0.1") Double peso,@NotNull @DecimalMin("0.1") Double altura) {}
