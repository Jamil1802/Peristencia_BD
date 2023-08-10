package Controller;
import Model.Estudante;
import Model.EstudanteDAO;
import java.util.ArrayList;

public class EstudanteController {

    private EstudanteDAO estudanteDAO;

    public EstudanteController() {
        estudanteDAO = new EstudanteDAO();
    }

    public boolean guardarEstudante(int nrMatricula, String nome, String apelido, String contacto, String endereco) {
        Estudante estudante = new Estudante();
        estudante.setNrMatricula(nrMatricula);
        estudante.setNome(nome);
        estudante.setApelido(apelido);
        estudante.setContacto(contacto);
        estudante.setEndereco(endereco);
        return estudanteDAO.guardar(estudante);
    }

    public ArrayList<Estudante> listarEstudantes() {
        return estudanteDAO.listaEstudantes();
    }

    public boolean atualizarEstudante(int nrMatricula, String nome, String apelido, String contacto, String endereco) {
        Estudante estudante = new Estudante();
        estudante.setNrMatricula(nrMatricula);
        estudante.setNome(nome);
        estudante.setApelido(apelido);
        estudante.setContacto(contacto);
        estudante.setEndereco(endereco);

        return estudanteDAO.Actualizar(estudante);
    }

    public boolean removerEstudante(int nrMatricula) {
        return estudanteDAO.Remover(nrMatricula);
    }
}