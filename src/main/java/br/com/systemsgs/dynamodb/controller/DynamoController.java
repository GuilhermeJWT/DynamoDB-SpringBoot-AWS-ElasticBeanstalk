package br.com.systemsgs.dynamodb.controller;

import br.com.systemsgs.dynamodb.model.ModelPessoa;
import br.com.systemsgs.dynamodb.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/dynamo")
public class DynamoController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping(value = "/salvar")
    public ModelPessoa salvarPessoa(@RequestBody ModelPessoa modelPessoa){
        return pessoaRepository.salvar(modelPessoa);
    }

    @GetMapping(value = "/pesquisa/{pessoaId}")
    public ModelPessoa pesquisaPessoa(@PathVariable String pessoaId){
        return pessoaRepository.pesquisaPorId(pessoaId);
    }

    @DeleteMapping(value = "/deletar")
    public String deletaPessoa(@RequestBody ModelPessoa modelPessoa){
        return pessoaRepository.deletar(modelPessoa);
    }

    @PutMapping(value = "/editar")
    public String editarPessoa(@RequestBody ModelPessoa modelPessoa){
        return pessoaRepository.editar(modelPessoa);
    }

}
