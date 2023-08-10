import Controller.EstudanteController;
import Model.Estudante;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static EstudanteController controller = new EstudanteController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarEstudante();
                    break;
                case 2:
                    listarEstudantes();
                    break;
                case 3:
                    atualizarEstudante();
                    break;
                case 4:
                    removerEstudante();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("1. Adicionar Estudante");
        System.out.println("2. Listar Estudantes");
        System.out.println("3. Atualizar Estudante");
        System.out.println("4. Remover Estudante");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarEstudante() {
        System.out.print("Nr Matricula: ");
        int nrMatricula = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Apelido: ");
        String apelido = scanner.nextLine();
        System.out.print("Contacto: ");
        String contacto = scanner.nextLine();
        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();

        if (controller.guardarEstudante(nrMatricula, nome, apelido, contacto, endereco)) {
            System.out.println("Estudante adicionado com sucesso!");
        } else {
            System.out.println("Erro ao adicionar estudante.");
        }
    }

    private static void listarEstudantes() {
        System.out.println("Lista de Estudantes:");
        ArrayList<Estudante> estudantes = controller.listarEstudantes();
        for (Estudante estudante : estudantes) {
            System.out.println(estudante);
        }
    }

    private static void atualizarEstudante() {
        System.out.print("Nr Matricula do Estudante a atualizar: ");
        int matriculaAtualizar = scanner.nextInt();
        scanner.nextLine();

        // Aqui você pode pedir os novos valores para atualização
        // e chamar o método da classe controller para atualizar o estudante
    }

    private static void removerEstudante() {
        System.out.print("Nr Matricula do Estudante a remover: ");
        int matriculaRemover = scanner.nextInt();
        scanner.nextLine(); // Limpar a quebra de linha

        if (controller.removerEstudante(matriculaRemover)) {
            System.out.println("Estudante removido com sucesso!");
        } else {
            System.out.println("Estudante não encontrado.");
        }
    }
}
