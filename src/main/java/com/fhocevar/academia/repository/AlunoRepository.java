package com.fhocevar.academia.repository;
import com.fhocevar.academia.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AlunoRepository extends JpaRepository<Aluno,Long> { boolean existsByCpf(String cpf); boolean existsByCpfAndIdNot(String cpf,Long id); List<Aluno> findByBairroContainingIgnoreCase(String bairro); List<Aluno> findByNomeContainingIgnoreCase(String nome); }
