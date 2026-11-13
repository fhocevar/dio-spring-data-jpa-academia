package com.fhocevar.academia.controller;
import com.fhocevar.academia.dto.*;
import com.fhocevar.academia.service.AcademiaService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/alunos") public class AlunoController {
 private final AcademiaService service; public AlunoController(AcademiaService s){service=s;}
 @PostMapping public ResponseEntity<AlunoResponse> criar(@Valid @RequestBody AlunoRequest r){return ResponseEntity.status(HttpStatus.CREATED).body(service.criarAluno(r));}
 @GetMapping public List<AlunoResponse> listar(@RequestParam(required=false) String nome,@RequestParam(required=false) String bairro){return service.listarAlunos(nome,bairro);}
 @GetMapping("/{id}") public AlunoResponse buscar(@PathVariable Long id){return AlunoResponse.of(service.aluno(id));}
 @PutMapping("/{id}") public AlunoResponse atualizar(@PathVariable Long id,@Valid @RequestBody AlunoRequest r){return service.atualizarAluno(id,r);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void excluir(@PathVariable Long id){service.excluirAluno(id);}
}
