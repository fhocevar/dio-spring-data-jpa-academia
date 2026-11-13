package com.fhocevar.academia.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="matriculas") public class Matricula {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="aluno_id",nullable=false) private Aluno aluno;
 @Column(nullable=false,updatable=false) private LocalDateTime dataDaMatricula;
 @PrePersist void criarData(){if(dataDaMatricula==null)dataDaMatricula=LocalDateTime.now();}
 public Long getId(){return id;} public Aluno getAluno(){return aluno;} public void setAluno(Aluno a){aluno=a;}
 public LocalDateTime getDataDaMatricula(){return dataDaMatricula;}
}
