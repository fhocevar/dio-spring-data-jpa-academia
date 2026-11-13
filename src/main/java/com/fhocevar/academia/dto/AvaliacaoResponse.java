package com.fhocevar.academia.dto;
import com.fhocevar.academia.model.AvaliacaoFisica;
import java.time.LocalDateTime;
public record AvaliacaoResponse(Long id,Long alunoId,LocalDateTime dataDaAvaliacao,Double peso,Double altura,Double imc){public static AvaliacaoResponse of(AvaliacaoFisica a){return new AvaliacaoResponse(a.getId(),a.getAluno().getId(),a.getDataDaAvaliacao(),a.getPeso(),a.getAltura(),a.getPeso()/(a.getAltura()*a.getAltura()));}}
