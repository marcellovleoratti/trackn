package com.example.trackn.Teste;

import com.example.trackn.Model.Model;
import com.example.trackn.Teste.Repository.RespositoryTeste;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class TesteApi {
  @Autowired
    private RespositoryTeste desafioRepository;

  @Test
    public void CadastrarRegistros() {
        Model model = new Model("nome",11, "03184070", "M", "Rua São Carlos",
                "Bela Vista", "São Paulo","SP");
        desafioRepository.save(model);
    }
    public Optional<Model> listarPorId() {
        long id =1;
        return desafioRepository.findById(id);
    }
@Test
    public List<Model> listarTodos() {
        return desafioRepository.findAll();
    }

    public List<String> listarPorCEP() {
        String cep = "03184070";
        return desafioRepository.findByCep(cep);
    }
@Test
    public void AtualizarRegistro() {
        Model desafioModel = new Model();
        long id = 3;
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
            System.out.println("Registro Atualizado com Sucesso");
        }else{
            System.out.println("Erro de Atualização do Registro");
        }
    }
@Test
    public void apagarRegistros(){
        long id =3;
        desafioRepository.deleteById(id);
    }

}
