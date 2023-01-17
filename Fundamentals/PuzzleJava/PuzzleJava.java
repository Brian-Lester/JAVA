import java.util.Random;

public class PuzzleJava {
    Random random = new Random();
    public int [] array10(){
        int [] myArray;
        myArray = new int[10];
        for (int i = 0; i <10; i++){
            int var = random.nextInt(20);
            myArray[i] = var;
        }
        return myArray;
    }
    public char randomChar(){
        char [] alphabet;
        int index = 0;
        alphabet = new char[26];
        for (int i =65; i < 91; i ++){
            alphabet[index] =(char)i;
            index +=1;
        }
        int index1 = random.nextInt(0, 25);
        return alphabet[index1];
    }

    public char[] randomPassword(){
        char [] alphabet;
        char [] password;
        int index = 0;
        alphabet = new char[26];
        password = new char[8];
        for (int i =65; i < 91; i ++){
            alphabet[index] =(char)i;
            index +=1;
        }
        for (int i =0; i < 7; i ++){
            int index1 = random.nextInt(0, 25);
            password[i]= (char)alphabet[index1];
        }
        
        return password;
    }

    public char[] randomPassword(int num){
        char [] alphabet;
        char [] password;
        int index = 0;
        alphabet = new char[26];
        password = new char[num];
        for (int i =65; i < 91; i ++){
            alphabet[index] =(char)i;
            index +=1;
        }
        for (int i =0; i < num; i ++){
            int index1 = random.nextInt(0, 25);
            password[i]= (char)alphabet[index1];
        }
        System.out.println(password.length);
        return password;
    }
}



