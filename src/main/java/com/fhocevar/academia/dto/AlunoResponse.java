package com.fhocevar.academia.dto;
import com.fhocevar.academia.model.Aluno;
import java.time.LocalDate;
public record AlunoResponse(Long id,String nome,String cpf,String bairro,LocalDate dataDeNascimento){ public static AlunoResponse of(Aluno a){return new AlunoResponse(a.getId(),a.getNome(),a.getCpf(),a.getBairro(),a.getDataDeNascimento());} }
