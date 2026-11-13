package com.fhocevar.academia.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity @Table(name="alunos")
public class Aluno {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String nome;
 @Column(nullable=false,unique=true,length=11) private String cpf;
 @Column(nullable=false) private String bairro;
 @Column(nullable=false) private LocalDate dataDeNascimento;
 public Long getId(){return id;} public String getNome(){return nome;} public void setNome(String v){nome=v;}
 public String getCpf(){return cpf;} public void setCpf(String v){cpf=v;}
 public String getBairro(){return bairro;} public void setBairro(String v){bairro=v;}
 public LocalDate getDataDeNascimento(){return dataDeNascimento;} public void setDataDeNascimento(LocalDate v){dataDeNascimento=v;}
}
