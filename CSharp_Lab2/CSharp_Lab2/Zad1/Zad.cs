using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharp_Lab2.Zad1
{
    class Zad
    {
        public Zad()
        {
            List<Shape> list = new List<Shape>();
            list.Add(new Rectangle());
            list.Add(new Triangle());
            list.Add(new Circle());

            for (int i = 0; i < list.Count; i++)
            {
                list.ElementAt(i).draw();
            }
        }
    }

}
