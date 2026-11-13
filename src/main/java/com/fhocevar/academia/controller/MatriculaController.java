package com.fhocevar.academia.controller;
import com.fhocevar.academia.dto.*;
import com.fhocevar.academia.service.AcademiaService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/matriculas") public class MatriculaController {
 private final AcademiaService service;public MatriculaController(AcademiaService s){service=s;}
 @PostMapping public ResponseEntity<MatriculaResponse> criar(@Valid @RequestBody MatriculaRequest r){return ResponseEntity.status(HttpStatus.CREATED).body(service.matricular(r));}
 @GetMapping public List<MatriculaResponse> listar(@RequestParam(required=false) Long alunoId){return service.listarMatriculas(alunoId);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void excluir(@PathVariable Long id){service.excluirMatricula(id);}
}
