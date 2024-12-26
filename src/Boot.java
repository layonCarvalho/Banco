package src;

import src.Controller.ContaController;
import src.Repository.Conta;
import src.Repository.ContaRepository;
import src.Service.ContaService;
import src.Service.ContaServiceImpl;

public class Boot {
    public static void main(String[] args) {
        ContaRepository contaRepository = new Conta();
        ContaService contaService = new ContaServiceImpl(contaRepository);
        ContaController contaController = new ContaController(contaService);

        contaController.criarConta(1L, "João", 1000.0);
        contaController.criarConta(2L, "Maria", 2000.0);

        System.out.println("Contas cadastradas:");
        contaController.listarContas().forEach(conta ->
                System.out.println(conta.getTitular() + " - Saldo: " + conta.getSaldo()));
    }
}
