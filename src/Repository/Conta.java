package Repository;

import Entities.ContaEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conta implements ContaRepository {
    private Connection conexao;

    public Conta() {
        try {
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/banco", "postgres", "postgres");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ContaEntity salvar(ContaEntity conta) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("INSERT INTO contas (id, titular, saldo) VALUES (?, ?, ?)");
            stmt.setLong(1, conta.getId());
            stmt.setString(2, conta.getTitular());
            stmt.setDouble(3, conta.getSaldo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conta;
    }

    @Override
    public ContaEntity buscarPorId(Long id) {
        try {
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM contas WHERE id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ContaEntity(rs.getLong("id"), rs.getString("titular"), rs.getDouble("saldo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ContaEntity> listarTodas() {
        List<ContaEntity> contas = new ArrayList<>();
        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM contas");
            while (rs.next()) {
                contas.add(new ContaEntity(rs.getLong("id"), rs.getString("titular"), rs.getDouble("saldo")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contas;
    }
}