package com.fhocevar.academia.repository;
import com.fhocevar.academia.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoFisica,Long> { List<AvaliacaoFisica> findByAlunoId(Long alunoId); }
