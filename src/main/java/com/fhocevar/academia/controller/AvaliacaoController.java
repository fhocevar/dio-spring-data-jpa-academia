package com.fhocevar.academia.controller;
import com.fhocevar.academia.dto.*;
import com.fhocevar.academia.service.AcademiaService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/avaliacoes") public class AvaliacaoController {
 private final AcademiaService service;public AvaliacaoController(AcademiaService s){service=s;}
 @PostMapping public ResponseEntity<AvaliacaoResponse> criar(@Valid @RequestBody AvaliacaoRequest r){return ResponseEntity.status(HttpStatus.CREATED).body(service.avaliar(r));}
 @GetMapping public List<AvaliacaoResponse> listar(@RequestParam(required=false) Long alunoId){return service.listarAvaliacoes(alunoId);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void excluir(@PathVariable Long id){service.excluirAvaliacao(id);}
}
