Random gerador = new Random();
int quantidade = 10;


List<int> lista1 = new List<int>();
while (lista1.Count < quantidade)
{
    int numero = gerador.Next(0, 100);
    if (!lista1.Contains(numero)) 
    {
        lista1.Add(numero);
    }
}
Console.WriteLine("Lista 1:");
foreach (var numero in lista1)
{
    Console.WriteLine(numero);
}


List<int> lista2 = new List<int>();
while (lista2.Count < quantidade)
{
    int numero = gerador.Next(0, 100);
    if (!lista2.Contains(numero)) 
    {
        lista2.Add(numero);
    }
}

Console.WriteLine("Lista 2:");
foreach (var numero in lista2)
{
    Console.WriteLine(numero);
}


List<int> listaComum = lista1.Intersect(lista2).ToList();

Console.WriteLine("\nNúmeros em comum:");
foreach (var numero in listaComum)
{
    Console.WriteLine(numero);
}