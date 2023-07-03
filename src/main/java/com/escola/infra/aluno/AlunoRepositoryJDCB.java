package com.escola.infra.aluno;

import com.escola.dominio.aluno.Aluno;
import com.escola.dominio.aluno.AlunoRepository;
import com.escola.dominio.aluno.CPF;
import com.escola.dominio.aluno.Email;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AlunoRepositoryJDCB implements AlunoRepository {

    private final Connection connection;

    public AlunoRepositoryJDCB(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        String sql = "INSERT INTO ALUNO VALUES(?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(aluno.getCpf()));
            preparedStatement.setString(2, aluno.getNome());
            preparedStatement.setString(3, String.valueOf(aluno.getEmail()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Aluno buscarAlunoPorCPF(CPF cpf) {
        String sql = "SELECT INTO ALUNO VALUES(cpf, nome, email) WHERE cpf = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(cpf));
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean encontrou = resultSet.next();
            if (!encontrou) {
                throw new RuntimeException("Não existe aluno cadastrado com o CPF informado!");
            }
            String nome = resultSet.getString("nomes");
            Email email = new Email(resultSet.getString("email"));
            CPF cpfAluno = new CPF(resultSet.getString("cpf"));
            Aluno alunoEncontrado = new Aluno(cpfAluno, nome, email);

            Long id = resultSet.getLong("id");
            sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String numero = resultSet.getString("numero");
                String ddd = resultSet.getString("ddd");
                alunoEncontrado.adicionarTelefone(ddd, numero);
            }

            return alunoEncontrado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> buscarTodos() {
        return null;
    }
}
