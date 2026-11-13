package com.fhocevar.academia.repository;
import com.fhocevar.academia.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MatriculaRepository extends JpaRepository<Matricula,Long> { List<Matricula> findByAlunoId(Long alunoId); }
