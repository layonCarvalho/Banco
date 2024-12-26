package Service;

import Entities.ContaEntity;

import java.util.List;

public interface ContaService {
    ContaEntity criarConta(ContaEntity conta);
    ContaEntity obterConta(Long id);
    List<ContaEntity> listarContas();
}
