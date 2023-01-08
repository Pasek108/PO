using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharp_Lab2.Zad2
{
   class Zad
    {
        public Zad() {
            Teacher nauczyciel = new Teacher();

            string[] pesels = {
                "80010348783",
                "72071449279",
                "68100837654",
                "98062212277",
                "01211092651",
                "84111229538",
                "05310463769",
                "98012995735",
                "93021175785",
                "05250211486",
            };

            for (int i = 0; i < pesels.Length; i++)
            {
                Student student = new Student();
                student.setFirstName("A" + i.ToString());
                student.setLastName("B" + i.ToString());
                student.setPesel(pesels[i]);

                nauczyciel.addStudent(student);
            }

            nauczyciel.WhichStudentCanGoHomeAlone(DateTime.Now);
        }
    }
}
