using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharp_Lab2.Zad2
{
    internal class Person
    {
        string name, surname, pesel;

        public virtual void setFirstName(string name) => this.name = name;
        public virtual void setLastName(string surname) => this.surname = surname;
        public virtual void setPesel(string pesel) => this.pesel = pesel;

        public virtual string getEducationInfo() => "";
        public virtual bool CanGoAloneToHome(DateTime dateToCheck) => Convert.ToInt32(this.getAge().Subtract(dateToCheck)) > 12;
        public virtual string getFullName() => this.name + " " + this.surname;

        public virtual DateTime getAge()
        {
            int day = ((Convert.ToInt32(this.pesel[4]) - 48) * 10) + Convert.ToInt32(this.pesel[5]) - 48;
            int month = ((Convert.ToInt32(this.pesel[2]) - 48) * 10) + Convert.ToInt32(this.pesel[3]) - 48;
            int year = ((Convert.ToInt32(this.pesel[0]) - 48) * 10) + Convert.ToInt32(this.pesel[1]) - 48;

            

            if (month < 20)
            {
                year = Convert.ToInt32("19" + year.ToString());
            }
            if (month < 40) 
            {
                year = Convert.ToInt32("20" + year.ToString());
                month -= 20;
            }
            if (month < 60)
            {
                year = Convert.ToInt32("21" + year.ToString());
                month -= 40;
            }
            if (month < 80) {
                year = Convert.ToInt32("22" + year.ToString());
                month -= 60;
            }
            else
            {
                year = Convert.ToInt32("18" + year.ToString());
                month -= 80;
            }

            Console.WriteLine(day.ToString() + "/" + month.ToString() + "/" + year.ToString());
            return DateTime.Parse(day.ToString() + "/" + month.ToString() + "/" + year.ToString());
        }

        public virtual string getGender()
        {
            if (Convert.ToInt32(this.pesel[9]) % 2 == 0) return "Woman";
            return "Man";
        }
    }

    internal class Student : Person
    {
        string school;
        public bool canGoHomeAlone = false;

        public Student()
        {

        }

        public void setSchool(string school)
        {
            this.school = school;
        }

        public void changeSchool(string school)
        {
            this.school = school;
        }

        public void setCanGoHomeAlone(bool canGoHomeAlone)
        {
            this.canGoHomeAlone = canGoHomeAlone;
        }

        public override string getEducationInfo()
        {
            return "Uczen";
        }
    }

    class Teacher : Person
    {
        string academicDegree;
        List<Student> students = new List<Student>();

        public Teacher()
        {

        }

        public void addStudent(Student student)
        {
            this.students.Add(student);
        }

        public void WhichStudentCanGoHomeAlone(DateTime dateToCheck)
        {
            for (int i = 0; i < students.Count; i++)
            {
                if (students.ElementAt(i).canGoHomeAlone)
                {
                    Console.WriteLine(students.ElementAt(i).getFullName());
                }
                else if (students.ElementAt(i).CanGoAloneToHome(dateToCheck))
                {
                    Console.WriteLine(students.ElementAt(i).getFullName());

                }
            }
        }

        public override string getEducationInfo()
        {
            return this.academicDegree;
        }
    }
}
