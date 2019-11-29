# practice
# practice

```java
import java.util.Scanner;

 

class Player{

   private String name;

   public Player(String name) {

      // TODO Auto-generated constructor stub

      this.name=name;

   }

   public String getName() {

      return name;

   }

   public String getWordFromUser(Scanner sc) {

      String word;

      System.out.print(name+">>");

      word=sc.nextLine();

      return word;

   }

   public boolean checkSuccess(char firstChar,char lastChar) {

      if(firstChar!=lastChar)

         return true;

      else

      return false;

   }

}

public class WordGameApp {

 

   public static void main(String[] args) {

      // TODO Auto-generated method stub

      Scanner sc=new Scanner(System.in);

      System.out.println("끝말잇기 게임을 시작합니다...");

      Player[] player;

      player=run(sc);

      

      

      System.out.println("시작하는 단어는 아버지입니다.");

      String word="아버지";

      int i=0;

      while(true) {

         int lastIndex=word.length()-1;

         char lastChar=word.charAt(lastIndex);

         word=player[i].getWordFromUser(sc);

         char firstChar=word.charAt(0);

         

         if(player[i].checkSuccess(firstChar, lastChar)) {

            System.out.println(player[i].getName()+"이 졌습니다.");

            break;

         }

         i++;

         if(i==player.length)

            i=0;

      }

      

      sc.close();

   }

 

   private static Player[] run(Scanner sc) {

      // TODO Auto-generated method stub

      System.out.println("게임에 참가하는 인원은 몇명입니까>>");

      int userNum=sc.nextInt();

      sc.nextLine();

      Player[] player=new Player[userNum];

      int i;

      for(i=0;i<player.length;i++) {

         System.out.print("참가자의 이름을 입력하세요>>");

         String name=sc.nextLine();

         player[i]=new Player(name);

      }

      

      return player;

   } 

}
```


```java

package Exercise;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class P480 {

   public static void main(String[] args) {

      Vector<String> wordVector = new Vector<String>();
      try {
         Scanner sc = new Scanner(new FileReader("c:\\words.txt"));
         while (sc.hasNext()) {
            String word = sc.nextLine();
            wordVector.add(word);
         }
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      Scanner scanner = new Scanner(System.in);
      System.out.println("난이도 선택 --- 감출 갯수");
      int hide = scanner.nextInt();

      while (true) {
         int selectRandom = new Random().nextInt(wordVector.size());
         String s = wordVector.get(selectRandom);
         StringBuffer showS = new StringBuffer(s);
         System.out.println(s);
         // 단어 감출 부분
         int x[] = new int[hide];
         char a[] = new char[hide];
         // 중복 체크
         if (s.length() > hide) {
            for (int i = 0; i < hide; i++) {
               x[i] = new Random().nextInt(s.length());
               for (int j = 0; j < i; j++) {
                  if (x[i] == x[j]) {
                     i--;
                  }
               }
            }
            for (int i = 0; i < hide; i++) {
               a[i] = s.charAt(x[i]);
               showS.setCharAt(x[i], '-');
            }
         } else {
            for (int i = 0; i < s.length(); i++) {
               x[i] = new Random().nextInt(s.length());
               for (int j = 0; j < i; j++) {
                  if (x[i] == x[j]) {
                     i--;
                  }
               }
            }
            for (int i = 0; i < hide; i++) {
               a[i] = s.charAt(x[i]);
               showS.setCharAt(x[i], '-');
            }
         }
         int count = 5;
         while (true) {   
            boolean check = true;
            System.out.println(showS);
            if (s.equals(showS.toString())) {
               System.out.println("당신이 이겼습니다.");
               break;
            }
            char me = scanner.next().charAt(0);
            for (int i = 0; i < hide; i++) {
               if (a[i] == me) {
                  showS.setCharAt(x[i], a[i]);
                  check = false;
               }
            }
            if (count == 0) {
               System.out.println("당신은 졌습니다.");
               break;
            }
            if (check) {
               count--;
               System.out.println(count + "번 기회가 남았습니다.");
            }
         }
         System.out.print("Next(y/n)");
         char end = scanner.next().charAt(0);
         if (end == 'n')
            break;
      }
   }
}
```
