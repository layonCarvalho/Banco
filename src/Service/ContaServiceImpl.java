package src.Service;


import src.Entities.ContaEntity;
import src.Repository.ContaRepository;

import java.util.List;

public class ContaServiceImpl implements ContaService {
        private final ContaRepository contaRepository;

        public ContaServiceImpl(ContaRepository contaRepository) {
            this.contaRepository = contaRepository;
        }

        @Override
        public ContaEntity criarConta(ContaEntity conta) {
            return contaRepository.salvar(conta);
        }

        @Override
        public ContaEntity obterConta(Long id) {
            return contaRepository.buscarPorId(id);
        }

        @Override
        public List<ContaEntity> listarContas() {
            return contaRepository.listarTodas();
        }
    }
