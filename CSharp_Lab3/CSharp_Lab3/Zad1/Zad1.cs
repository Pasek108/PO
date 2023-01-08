using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharp_Lab3.Zad1
{
    public class Zad1
    {
        public static void zad1()
        {
            List<IOsoba> osoby = new List<IOsoba>();

            osoby.Add(new Osoba("Artur", "Pas"));
            osoby.Add(new Osoba("AAAAA", "BBB"));
            osoby.Add(new Osoba("Marian", "Marianski"));

            osoby.First().wypiszOsoby(osoby);
            osoby.First().posortujOsobyPoNazwisku(osoby);
            osoby.First().wypiszOsoby(osoby);
        } 
    }

    public interface IOsoba
    {
        public string imie { get; set; }
        public string nazwisko { get; set; }

        public string zwrocPelnaNazwe();
        public void wypiszOsoby(List<IOsoba> osoby);
        public void posortujOsobyPoNazwisku(List<IOsoba> osoby);
    }

    class Osoba : IOsoba {
        public string imie { get; set; }
        public string nazwisko { get; set; }

        public Osoba(string imie, string nazwisko)
        {
            this.imie = imie;
            this.nazwisko = nazwisko;
        }

        public string zwrocPelnaNazwe()
        {
            return this.imie + " " + this.nazwisko;
        }

        public void wypiszOsoby(List<IOsoba> osoby)
        {
            foreach (IOsoba osoba in osoby) Console.WriteLine(osoba.zwrocPelnaNazwe());
            Console.WriteLine();
        }

        public void posortujOsobyPoNazwisku(List<IOsoba> osoby)
        {
            osoby.Sort((x, y) => x.nazwisko.CompareTo(y.nazwisko));
        }
    }

}
