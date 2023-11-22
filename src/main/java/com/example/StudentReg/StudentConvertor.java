package com.example.StudentReg;

public class StudentConvertor {

    public static StudentEntity stringToStudent(String string) {

        String[] strings = string.split("; ");
        boolean error = false;
        if (strings.length !=4){
            System.out.println("Неправильный ввод. Разделитель \"; \"с пробелом, или количество параметров не равно 4");

            return null;
        }


        if (!strings[0].matches(RegularExpressions.ID.getPattern().pattern()))
        {
            System.out.println("Неправильный ID - только цифры");
            error = true;
        }





        if        (!strings[1].matches(RegularExpressions.FIRST_NAME.getPattern().pattern()))
        { error =true;
            System.out.println("Неправильный ввод имени имя может содержать только латинские буквы");
        }
         if       (!strings[2].matches(RegularExpressions.LAST_NAME.getPattern().pattern())) {
             System.out.println("Неправильный ввод фамилии, фамилия может содержать только латинские буквы");
             error =true;
         }
        if       (!strings[3].matches(RegularExpressions.AGE.getPattern().pattern())) {
            System.out.println("Неправильный ввод возраста, возраст может содержать только цифры, до 3шт.");
            error =true;
        }
            if (!error) {
                Integer id = Integer.valueOf(strings[0]);
                String firstName = strings[1];
                String lastName = strings[2];
                Integer age =Integer.valueOf(strings[3]);
                StudentEntity studentEntity = new StudentEntity(id, firstName, lastName, age);
                return studentEntity;
            }
         else {
            System.out.println("Ошибка ввода данных, передан null");
            return null;
        }



    }
}
