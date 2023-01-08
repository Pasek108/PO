using System;
using System.Diagnostics.Metrics;
using System.Text.Encodings.Web;
using System.Text.Json;
using System.Text.Json.Serialization;

namespace CSharp_Lab4
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // zadanie 1
            var imie = "Artur";
            var numer = "122961";
            var nazwa_pliku = "plik";

            using var src1 = new StreamWriter(nazwa_pliku + ".txt");
            src1.WriteLine(imie);
            src1.WriteLine(numer);
            src1.Close();

            // zadanie 2
            using var src = new StreamReader(nazwa_pliku + ".txt");
            var line = src.ReadToEnd();
            Console.WriteLine(line);
            src.Close();

            // zadanie 3
            using var pesels = new StreamReader("pesels.txt");
            var pesel = pesels.ReadLine();
            int counter = 0;

            while (pesel != null)
            {
                if (Convert.ToInt16(pesel[9]) % 2 == 0) counter++;
                pesel = pesels.ReadLine();
            }

            Console.WriteLine("Peseli żeńskich jest " + counter);
            Console.WriteLine();
            pesels.Close();

            // zadanie 4
            using var sr = new StreamReader("db.json");
            string json = sr.ReadToEnd();
            var DBObjects = JsonSerializer.Deserialize<List<DBObject>>(json);

            String india_population_2000 = "0";
            String india_population_1970 = "0";
            String usa_population_2010 = "0";
            String usa_population_1965 = "0";
            String china_population_2018 = "0";
            String china_population_1980 = "0";

            for (int i = 0; i < DBObjects.Count; i++)
            {
                var current_data = DBObjects.ElementAt(i);

                if (current_data.country.value == "India")
                {
                    if (current_data.date == "2000") india_population_2000 = current_data.value;
                    if (current_data.date == "1970") india_population_2000 = current_data.value;
                }

                if (current_data.country.value == "United States")
                {
                    if (current_data.date == "2010") usa_population_2010 = current_data.value;
                    if (current_data.date == "1965") usa_population_1965 = current_data.value;
                }

                if (current_data.country.value == "China")
                {
                    if (current_data.date == "2018") china_population_2018 = current_data.value;
                    if (current_data.date == "1980") china_population_1980 = current_data.value;
                }
            }

            Console.WriteLine("Roznica ludnosci indi miedzy 1970 a 2000");
            Console.WriteLine(Convert.ToDouble(india_population_2000) - Convert.ToDouble(india_population_1970));
            Console.WriteLine();

            Console.WriteLine("Roznica ludnosci usa miedzy 1965 a 2010");
            Console.WriteLine(Convert.ToDouble(usa_population_2010) - Convert.ToDouble(usa_population_1965));
            Console.WriteLine();

            Console.WriteLine("Roznica ludnosci indi miedzy 1980 a 2018");
            Console.WriteLine(Convert.ToDouble(china_population_2018) - Convert.ToDouble(china_population_1980));
            Console.WriteLine();

            /*
            String aaa = @"{""Name"":""Mario"",""Level"":1,""HealthPoints"":100,""Statictics"":[{""Name"":""Strength"",""Points"":16},{""Name"":""Intelligence"",""Points"":8},{""Name"":""Agility"",""Points"":7}]}";

            using var sr = new StreamReader("mario.json");
            string json = sr.ReadToEnd();
            var player = JsonSerializer.Deserialize<Player>(json);
            Console.WriteLine(player.Statictics.Count);*/
        }

        internal class Player
        {
            public String Name { get; set; }
            public int Level { get; set; }
            public int HealthPoints { get; set; }
            public List<Statictics> Statictics { get; set; }
        }

        internal class Statictics {
            public String Name { get; set; }
            public int Points { get; set; }
        }

        internal class DBObject
        {
            public String value { get; set; }
            public String @decimal { get; set; }
            public String date { get; set; }
            public Indicator indicator { get; set; }
            public Indicator country { get; set; }
        }

        internal class Indicator
        {
            public String value { get; set; }
            public String id { get; set; }
        }
    }
}