package com.fhocevar.academia.dto;
import com.fhocevar.academia.model.Matricula;
import java.time.LocalDateTime;
public record MatriculaResponse(Long id,Long alunoId,LocalDateTime dataDaMatricula){public static MatriculaResponse of(Matricula m){return new MatriculaResponse(m.getId(),m.getAluno().getId(),m.getDataDaMatricula());}}
