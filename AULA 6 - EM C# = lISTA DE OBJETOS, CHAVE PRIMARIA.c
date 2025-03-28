using System;
using System.Collections.Generic;

public class Aluno
{
    public string nome;
    public int matricula;
    public string email;

    public Aluno(int matricula, string nome)
    {
        this.nome = nome;
        this.matricula = matricula;
        this.email = this.GerarEmail(); // Corrected method name
    }

    public string GerarEmail() // Corrected method name
    {
        string[] vetorNomes = this.nome.ToLower().Split(" ");
        return vetorNomes[0] + "." + vetorNomes[vetorNomes.Length - 1] + "@ufn.edu.br";
    }

    public override bool Equals(object obj) // Corrected method signature
    {
        if (obj == null || GetType() != obj.GetType())
        {
            return false;
        }

        Aluno aluno = (Aluno)obj;
        return email == aluno.email;
    }

    public override int GetHashCode() // Added GetHashCode() to match Equals()
    {
        return email.GetHashCode();
    }

    public override string ToString() // Corrected method name and override
    {
        return "Matricula: " + matricula + ", Nome: " + nome + ", Email: " + email;
    }

    public static void Main(string[] args)
    {
        List<Aluno> alunos = new List<Aluno>();

        Aluno tmp;
        string nome;
        int matricula = 1;
        string opcao;

        while (true)
        {
            Console.WriteLine("Digite o nome do aluno: ");
            nome = Console.ReadLine().ToUpper();
            tmp = new Aluno(matricula, nome);

            if (alunos.Contains(tmp))
            {
                Console.WriteLine("Aluno com este email ja cadastrado!");
            }
            else
            {
                alunos.Add(tmp);
                Console.WriteLine("Aluno cadastrado com sucesso! Matricula: " + matricula + " Email: " + tmp.email);
                matricula++;
            }

            Console.WriteLine("CONTINUA ? (s/n)");
            opcao = Console.ReadLine();

            if (!opcao.Equals("s", StringComparison.OrdinalIgnoreCase)) // Corrected string comparison
                break;
        }

        alunos.Sort((aluno1, aluno2) => aluno1.nome.CompareTo(aluno2.nome));

        Console.WriteLine("Relação de alunos:");
        foreach (Aluno aluno in alunos)
        {
            Console.WriteLine(aluno);
        }
    }
}
