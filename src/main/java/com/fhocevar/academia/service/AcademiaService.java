package com.fhocevar.academia.service;
import com.fhocevar.academia.dto.*;
import com.fhocevar.academia.model.*;
import com.fhocevar.academia.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
@Service @Transactional public class AcademiaService {
 private final AlunoRepository alunos; private final MatriculaRepository matriculas; private final AvaliacaoRepository avaliacoes;
 public AcademiaService(AlunoRepository a,MatriculaRepository m,AvaliacaoRepository v){alunos=a;matriculas=m;avaliacoes=v;}
 @Transactional(readOnly=true) public Aluno aluno(Long id){return alunos.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno nao encontrado"));}
 public AlunoResponse criarAluno(AlunoRequest r){if(alunos.existsByCpf(r.cpf()))throw new ResponseStatusException(HttpStatus.CONFLICT,"CPF ja cadastrado");Aluno a=new Aluno(); preencher(a,r);return AlunoResponse.of(alunos.save(a));}
 public AlunoResponse atualizarAluno(Long id,AlunoRequest r){Aluno a=aluno(id);if(alunos.existsByCpfAndIdNot(r.cpf(),id))throw new ResponseStatusException(HttpStatus.CONFLICT,"CPF ja cadastrado");preencher(a,r);return AlunoResponse.of(alunos.save(a));}
 private void preencher(Aluno a,AlunoRequest r){a.setNome(r.nome());a.setCpf(r.cpf());a.setBairro(r.bairro());a.setDataDeNascimento(r.dataDeNascimento());}
 @Transactional(readOnly=true) public List<AlunoResponse> listarAlunos(String nome,String bairro){List<Aluno> lista=nome!=null&&!nome.isBlank()?alunos.findByNomeContainingIgnoreCase(nome):bairro!=null&&!bairro.isBlank()?alunos.findByBairroContainingIgnoreCase(bairro):alunos.findAll();return lista.stream().map(AlunoResponse::of).toList();}
 public void excluirAluno(Long id){Aluno a=aluno(id);if(!matriculas.findByAlunoId(id).isEmpty()||!avaliacoes.findByAlunoId(id).isEmpty())throw new ResponseStatusException(HttpStatus.CONFLICT,"Aluno possui matriculas ou avaliacoes; exclua os registros relacionados primeiro");alunos.delete(a);}
 public MatriculaResponse matricular(MatriculaRequest r){Matricula m=new Matricula();m.setAluno(aluno(r.alunoId()));return MatriculaResponse.of(matriculas.saveAndFlush(m));}
 @Transactional(readOnly=true) public List<MatriculaResponse> listarMatriculas(Long alunoId){return (alunoId==null?matriculas.findAll():matriculas.findByAlunoId(alunoId)).stream().map(MatriculaResponse::of).toList();}
 public void excluirMatricula(Long id){Matricula m=matriculas.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Matricula nao encontrada"));matriculas.delete(m);}
 public AvaliacaoResponse avaliar(AvaliacaoRequest r){AvaliacaoFisica a=new AvaliacaoFisica();a.setAluno(aluno(r.alunoId()));a.setPeso(r.peso());a.setAltura(r.altura());return AvaliacaoResponse.of(avaliacoes.saveAndFlush(a));}
 @Transactional(readOnly=true) public List<AvaliacaoResponse> listarAvaliacoes(Long alunoId){return (alunoId==null?avaliacoes.findAll():avaliacoes.findByAlunoId(alunoId)).stream().map(AvaliacaoResponse::of).toList();}
 public void excluirAvaliacao(Long id){AvaliacaoFisica a=avaliacoes.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Avaliacao nao encontrada"));avaliacoes.delete(a);}
}
