package Repository;

import Entities.ContaEntity;

import java.util.List;

public interface ContaRepository {
    ContaEntity salvar(ContaEntity conta);
    ContaEntity buscarPorId(Long id);
    List<ContaEntity> listarTodas();
}
