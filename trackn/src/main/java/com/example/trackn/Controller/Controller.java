package com.example.trackn.Controller;

import com.example.trackn.Model.Model;
import com.example.trackn.Repository.Repository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/cadastrar")
public class Controller {

    @Autowired
    private Repository desafioRepository;

    //Gravar Registro
    @PostMapping(path = "/cadastrarRegistro")
    public void gravar(@RequestBody Model desafioModel) {
        desafioRepository.save(desafioModel);
    }

    //Localizar por Id
    @GetMapping(path = "/listar/{id}")
    public Optional<Model> listarPorId(@PathVariable Long id) {
        return desafioRepository.findById(id);
    }

    //Listar Todos
    @GetMapping(path = "/listarTodos")
    public List<Model> listarTodos() {
        return desafioRepository.findAll();
    }

    //Localizar por CEP
    @PatchMapping(path = "/listarCEP/{cep}")
    public void Atualiza(@NotNull @PathVariable("cep") String cep,
                                      @RequestBody Model desafioModel) {
        String uri = "https://viacep.com.br/";
        RestTemplate restTemplate = new RestTemplate();
        Model filtrarCepTeste = restTemplate.getForObject(uri, Model.class);
        desafioRepository.findByCep(filtrarCepTeste);
    }

    //Atualizar registros
    @PutMapping(path = "/atualizar/{id}")
    public ResponseEntity<Model> Atualizar(@PathVariable Long id, @Validated @RequestBody Model desafioModel) {
        Optional<Model> itemAntigo = desafioRepository.findById(id);
        if (itemAntigo.isPresent()) {
            Model m = itemAntigo.get();
            m.setNome(desafioModel.getNome());
            m.setIdade(desafioModel.getIdade());
            m.setCep(desafioModel.getCep());
            m.setSexo(desafioModel.getSexo());
            m.setEndereco(desafioModel.getEndereco());
            m.setBairro(desafioModel.getBairro());
            m.setCidade(desafioModel.getCidade());
            m.setEstado(desafioModel.getEstado());
            return new ResponseEntity<Model>(m, HttpStatus.MULTI_STATUS.OK);
        }else{
            return new ResponseEntity<Model>(HttpStatus.MULTI_STATUS.NOT_FOUND);
        }
    }
    //Apagar Resgitros
    @DeleteMapping(path="/apagar/{id}")
    public void apagarRegistros(@PathVariable Long id){
        desafioRepository.deleteById(id);
    }
}
