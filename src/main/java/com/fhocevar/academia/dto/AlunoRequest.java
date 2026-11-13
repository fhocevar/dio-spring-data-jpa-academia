package com.fhocevar.academia.dto;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
public record AlunoRequest(@NotBlank String nome,@NotBlank @Pattern(regexp="[0-9]{11}",message="CPF deve conter 11 digitos") String cpf,@NotBlank String bairro,@NotNull @Past LocalDate dataDeNascimento) {}
