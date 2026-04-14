import java.util.Scanner;
import java.util.ArrayList;

// Classe para representar o Livro [cite: 32, 41]
class Livro {
    String titulo, autor, codigo;
    boolean disponivel;

    Livro(String titulo, String autor, String codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.disponivel = true; // Status inicial: disponível [cite: 50]
    }
}

// Classe para representar o Usuário [cite: 56, 57]
class Usuario {
    String nome, documento;

    Usuario(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }
}

public class BibliotecaSenac {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        int opcao = 0;

        while (opcao != 6) { // Opção 6 para Sair [cite: 88]
            System.out.println("\n--- SISTEMA DE BIBLIOTECA ---");
            System.out.println("1- Cadastrar Livro");
            System.out.println("2- Cadastrar Usuário");
            System.out.println("3- Emprestar Livro");
            System.out.println("4- Devolver Livro");
            System.out.println("5- Listar Livros");
            System.out.println("6- Sair");
            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();
            leitor.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1: // Cadastro de Livro [cite: 83]
                    System.out.println("Título:");
                    String t = leitor.nextLine();
                    System.out.println("Autor:");
                    String a = leitor.nextLine();
                    System.out.println("Código:");
                    String c = leitor.nextLine();
                    livros.add(new Livro(t, a, c));
                    System.out.println("Livro cadastrado!");
                    break;

                case 2: // Cadastro de Usuário [cite: 84]
                    System.out.println("Nome do Usuário:");
                    String nomeU = leitor.nextLine();
                    System.out.println("CPF ou ID:");
                    String doc = leitor.nextLine();
                    usuarios.add(new Usuario(nomeU, doc));
                    System.out.println("Usuário cadastrado!");
                    break;

                case 3: // Emprestar Livro 
                    System.out.println("Digite o código do livro para emprestar:");
                    String codBusca = leitor.nextLine();
                    for (Livro l : livros) {
                        if (l.codigo.equals(codBusca)) {
                            if (l.disponivel) { // Regra: só empresta se disponível
                                l.disponivel = false;
                                System.out.println("Empréstimo realizado com sucesso!");
                            } else {
                                System.out.println("Este livro já está emprestado!");
                            }
                        }
                    }
                    break;

                case 4: // Devolver Livro 
                    System.out.println("Digite o código do livro para devolver:");
                    String codDev = leitor.nextLine();
                    for (Livro l : livros) {
                        if (l.codigo.equals(codDev)) {
                            l.disponivel = true;
                            System.out.println("Livro devolvido!");
                        }
                    }
                    break;

                case 5: // Listar Livros
                    System.out.println("--- Lista de Livros ---");
                    for (Livro l : livros) {
                        System.out.println("Título: " + l.titulo + " | Status: " + (l.disponivel ? "Livre" : "Emprestado"));
                    }
                    break;
            }
        }
    }
}