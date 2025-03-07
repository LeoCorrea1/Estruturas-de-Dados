using static System.Runtime.InteropServices.JavaScript.JSType;

List<int> lista = new List<int>();
Random gerador = new Random();

int quantidade = 11;

for (int j = 0; j < quantidade; j++)
{
    lista.Add(gerador.Next(50 , 240));
}

lista.Sort();

Console.WriteLine("Numeros da glicose:");
foreach (var numeroGlic in lista)
{
    Console.WriteLine(numeroGlic);
}

float soma = 0;
foreach (var numeroGlic in lista)
{
    soma += numeroGlic;
}
float media = soma / quantidade;

Console.WriteLine($"\nA media da Glicose esta em : {media:F2}"); // Formata com 2 casas decimais

int mediana = 0;

if (quantidade % 2 != 0) 
{
    mediana = lista[quantidade / 2];
}
else
{
    mediana = (lista[quantidade / 2 - 1] + lista[quantidade / 2]) / 2;
}
Console.WriteLine("\nMediana dos números: " + mediana);

int moda = 0;
int maiorQuant = 0;

foreach (var numeroGlic in lista)
{
    int contador = 0;

    foreach (var num in lista)
    {
        if (numeroGlic == num)
        {
            contador++;
        }
    }
    if (contador > maiorQuant)
    {
        maiorQuant = contador;
        moda = numeroGlic;
    }
}
if (maiorQuant > 1)
{
    Console.WriteLine("\nA moda é: " + moda);
}
else
{
    Console.WriteLine("\nNão há números que aparecem duas ou mais vezes.");
}

