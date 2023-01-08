using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharp_Lab1
{
    internal class zad2
    {
        static void Main()
        {
            Licz licz = new Licz();
            licz.add(5);
            licz.add(10.4);
            Console.WriteLine(licz.getValue());

            double[] liczby = { 1, 4.75, 6, 5 };
            Sumator sumator = new Sumator(liczby);
            Console.WriteLine(sumator.suma());
            Console.WriteLine(sumator.sumaPodziel2());
            Console.WriteLine(sumator.ileElementow());
            sumator.wypisz();
            sumator.wypiszPomiedzy(-1, 1);

            Liczba liczba = new Liczba("123");
            liczba.print();
            Console.WriteLine();
            Console.WriteLine(liczba.factorial(5));
            liczba.multiply(3);
            liczba.print();
        }
    }

    class Licz
    {
        private double value;

        public Licz() { }
        public Licz(double value)
        {
            this.value = value;
        }

        public void add(double number)
        {
            value += number;
        }

        public void sub(double number)
        {
            value -= number;
        }

        public double getValue()
        {
            return this.value;
        }
    }

    class Sumator
    {
        private double[] liczby;

        public Sumator() { }
        public Sumator(double[] liczby)
        {
            this.liczby = liczby;
        }

        public double suma()
        {
            double suma = 0;

            for (int i = 0; i < this.liczby.Length; i++) suma += this.liczby[i];

            return suma;
        }

        public double sumaPodziel2()
        {
            double suma = 0;

            for (int i = 0; i < this.liczby.Length; i++)
            {
                if (Convert.ToInt64(this.liczby[i]) % 2 == 0) suma += this.liczby[i];
            }

            return suma;
        }

        public void wypiszPomiedzy(int low_index, int hightIndex)
        {
            for (int i = low_index; i <= hightIndex; i++)
            {
                if (i < 0) i = 0;
                if (i >= this.liczby.Length) break;

                Console.Write("{0}, ", this.liczby[i]);
            }

            Console.WriteLine();
        }

        public void wypisz()
        {
            for (int i = 0; i < this.liczby.Length; i++) Console.Write("{0}, ", this.liczby[i]);
            Console.WriteLine();
        }

        public int ileElementow()
        {
            return this.liczby.Length;
        }
    }

    class Liczba
    {
        private int[] number;

        public Liczba(String new_number)
        {
            this.number = new int[new_number.Length];

            for (int i = new_number.Length - 1; i >= 0; i--)
            {
                this.number[i] = Convert.ToInt32(new_number[Math.Abs(i - new_number.Length + 1)]) - 48;
            }
        }

        public void print()
        {
            for (int i = this.number.Length - 1; i >= 0; i--)
            {
                Console.Write(this.number[i]);
            }
        }

        public void multiply(int value)
        {
            for (int i = 0; i < this.number.Length; i++)
            {
                this.number[i] *= value;
                if (i + 1 >= this.number.Length) break;
                this.number[i + 1] += this.number[i] - this.number[i] % Convert.ToInt32(Math.Pow(10, (i + 1)));
                this.number[i] = this.number[i] % Convert.ToInt32(Math.Pow(10, (i + 1)));
            }

            if (this.number[this.number.Length - 1] > 9)
            {
                int counter = 0;

                for (int i = 0; true; i++)
                {
                    if (this.number[this.number.Length - 1] / Math.Pow(10, (i + 1)) <= 0)
                    {
                        counter = i;
                        break;
                    }
                }

                int[] new_number = new int[this.number.Length + counter];

                for (int i = 0; i < this.number.Length - 1; i++)
                {
                    this.number[i] *= value;
                }

                for (int i = 0; i < this.number.Length - 1; i++)
                {
                }
            }
        }

        public int factorial(int value)
        {
            int factorial = 1;

            for (int i = 1; i <= value; i++) factorial *= i;

            return factorial;
        }
    }
}
