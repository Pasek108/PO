using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharp_Lab2.Zad1
{
    internal class Shape
    {
        double x, y, height, width;

        public virtual void draw()
        {
            Console.WriteLine("Rysuje ksztalt");
        }
    }

    internal class Rectangle : Shape
    {
        public override void draw()
        {
            base.draw();
            Console.WriteLine("Prostokąt");
        }
    }

    internal class Triangle : Shape
    {
        public override void draw()
        {
            base.draw();
            Console.WriteLine("Trojkat");
        }
    }

    internal class Circle : Shape
    {
        public override void draw()
        {
            base.draw();
            Console.WriteLine("Kolo");
        }
    }
}