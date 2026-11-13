package com.fhocevar.academia.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="avaliacoes_fisicas") public class AvaliacaoFisica {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="aluno_id",nullable=false) private Aluno aluno;
 @Column(nullable=false,updatable=false) private LocalDateTime dataDaAvaliacao;
 @Column(nullable=false) private Double peso;
 @Column(nullable=false) private Double altura;
 @PrePersist void criarData(){if(dataDaAvaliacao==null)dataDaAvaliacao=LocalDateTime.now();}
 public Long getId(){return id;} public Aluno getAluno(){return aluno;} public void setAluno(Aluno a){aluno=a;}
 public LocalDateTime getDataDaAvaliacao(){return dataDaAvaliacao;}
 public Double getPeso(){return peso;} public void setPeso(Double v){peso=v;}
 public Double getAltura(){return altura;} public void setAltura(Double v){altura=v;}
}
