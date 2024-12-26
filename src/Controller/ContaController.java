package src.Controller;

import src.Entities.ContaEntity;
import src.Service.ContaService;

import java.util.List;

public class ContaController {
    private ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    public ContaEntity criarConta(Long id, String titular, Double saldo) {
        ContaEntity conta = new ContaEntity(id, titular, saldo);
        return contaService.criarConta(conta);
    }

    public ContaEntity obterConta(Long id) {
        return contaService.obterConta(id);
    }

    public List<ContaEntity> listarContas() {
        return contaService.listarContas();
    }
}

