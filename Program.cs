List<string> ListaNomes = new List<string>();
string opcao;
string nome;

do
{
    Console.Write("digite um nome completo : ");
    nome = Console.ReadLine();
    nome = nome.ToUpper();

    if (!ListaNomes.Contains(nome))
    {
     ListaNomes.Add(nome);  
    }else
    {
        Console.WriteLine("Nome ja cadastrado");
    }
    Console.WriteLine("1 - continua , 2 - finaliza");
    opcao = Console.ReadLine();

}while (opcao != "2");

ListaNomes.Sort();
Console.WriteLine("A lista Contem : " +ListaNomes.Count);
foreach (var i in ListaNomes)
{
    Console.WriteLine(i);
}
     
