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
