# git pull origin master / git add * / git commit -m " " / git push origin master .
# 내가 올린 주소 복사 / project / + 버튼 누른 후 주소 붙여넣기.
# SQL연동 문제 

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

```java

package Exercise;

import java.util.Scanner;

abstract class GameObject1 {
   protected int distance;
   protected int x, y;

   public GameObject1(int startX, int startY, int distance) {
      this.x = startX;
      this.y = startY;
      this.distance = distance;
   }

   public int getX() {
      return x;
   }

   public int getY() {
      return y;
   }

   public boolean collide(GameObject p) {
      if (this.x == p.getX() && this.y == p.getY())
         return true;
      else
         return false;
   }

   protected abstract void move();

   protected abstract char getShape();
}

class Bear1 extends GameObject1 {

   public Bear1(int startX, int startY, int distance) {
      super(startX, startY, distance);
   }

   @Override
   protected void move() {
      Scanner sc = new Scanner(System.in);
      System.out.print("왼쪽 (a), 아래(s), 오른쪽(d), 위(w) >>");
      char selectMove = sc.next().charAt(0);
      switch (selectMove) {
      case 'a':
         if (x == 0) {
            System.out.println("왼쪽에 벽이 있습니다.");
            move();
         } else {
            x--;
            distance++;
         }
         break;
      case 's':
         if (y == 9) {
            System.out.println("아래에 벽이 있습니다.");
            move();
         } else {
            y++;
            distance++;
         }
         break;
      case 'd':
         if (x == 19) {
            System.out.println("오른쪽에 벽이 있습니다.");
            move();
         } else {
            x++;
            distance++;
         }
         break;
      case 'w':
         if (y == 0) {
            System.out.println("위에 벽이 있습니다.");
            move();
         } else {
            y--;
            distance++;
         }
         break;
      default:
         System.out.println("잘못 입력하였습니다.");
         move();
      }
   }

   @Override
   protected char getShape() {
      return 'B';
   }

   public boolean collide(GameObject p) {
      if (this.x == p.getX() && this.y == p.getY())
         return true;
      else
         return false;
   }

   public int getDistance() {
      return distance;
   }

}

class Fish1 extends GameObject1 {

   public Fish1(int startX, int startY, int distance) {
      super(startX, startY, distance);
   }

   @Override
   protected void move() {
      int randomMove;
      while (true) {
         randomMove = (int) (Math.random() * 10 % 4);
         switch (randomMove) {
         case 0:
            if (x == 0) {
               System.out.println("왼쪽에 벽이 있습니다.");
               move();
            } else {
               x--;
               distance++;
            }
            break;
         case 1:
            if (y == 9) {
               System.out.println("아래에 벽이 있습니다.");
               move();
            } else {
               y++;
               distance++;
            }
            break;
         case 2:
            if (x == 19) {
               System.out.println("오른쪽에 벽이 있습니다.");
               move();
            } else {
               x++;
               distance++;
            }
            break;
         case 3:
            if (y == 0) {
               System.out.println("위에 벽이 있습니다.");
               move();
            } else {
               y--;
               distance++;
            }
            break;
         }
         break;
      }
   }

   @Override
   protected char getShape() {
      return '@';
   }

   public int getDistance() {
      return distance;
   }
}

public class P306 {

   public static void main(String[] args) {
      GameObject bear = new Bear(0, 0, 0);
      GameObject fish = new Fish((int) ((Math.random() * 100) % 19 + 1), (int) ((Math.random() * 10) % 9 + 1), 0);
      Scanner sc = new Scanner(System.in);
      char print[][] = new char[10][20];
      int cnt = 0;
      while (true) {
         for (int i = 0; i < print.length; i++) {
            for (int j = 0; j < print[i].length; j++) {
               print[i][j] = '-';
            }
         }
         print[fish.getY()][fish.getX()] = fish.getShape();
         print[bear.getY()][bear.getX()] = bear.getShape();
         for (int i = 0; i < print.length; i++) {
            for (int j = 0; j < print[i].length; j++) {
               System.out.print(print[i][j]);
            }
            System.out.println();
         }
         if (bear.collide(fish)) {
            System.out.println("bear Wins!!");
            break;
         }
         bear.move();
         if (bear.distance >= 5) {
            bear.distance = 0;
         } else if (bear.distance > 2) {
            fish.move();
         }
      }
   }
}
```
```java

package 명품자바Ex;

import java.io.File;

public class FileEx {

	public static void listDirectory(File dir) {
		System.out.println("-------" + dir.getPath() + "의 서브 리스트 입니다.");
		
		File[] subFiles = dir.listFiles();
		
		for(int i = 0; i < subFiles.length; i ++) {
			File f = subFiles[i];
			long t = f.lastModified();
			System.out.print(f.getName());
			System.out.print("\t파일 크기 : " + f.length());
			System.out.printf("\t수정한 시간 : %tb %td %ta %tT\n",t, t, t, t );
		}
		
	}
	
	public static void main(String[] args) {
		File f1 = new File("c:\\windows\\system.ini");
		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName());
		
		String res = "";
		if(f1.isFile()) {
			res = "파일";
		} else if(f1.isDirectory()) {
			res = "디렉토리";
		}
		System.out.println(f1.getPath() + "은 " + res + "입니다.");
		
	    File f2 = new File("c:\\Temp\\java_sample");
	    if(!f2.exists()) {
	    	f2.mkdir();
	    }
	    
	    listDirectory(new File("c:\\Temp"));
	    f2.renameTo(new File("c:\\Temp\\javasample"));
	    
	    listDirectory(new File("c:\\Temp"));
	}

}

```

```java

package 명품자바Ex;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextCopyEx {

	public static void main(String[] args) {
		
		final int END = -1;
		File src = new File("c:\\windows\\system.ini");
		File dest = new File("c:\\Temp\\system.txt");
		
		int read;
		try {
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(dest);
			while((read = fr.read()) != END) {
				fw.write((char)read);
			}
			fr.close();
			fw.close();
			System.out.println(src.getPath() +"를 "+ dest.getPath() +"로 복사하였습니다." );
			
 		} catch(IOException e) {
 			System.out.println("파일 복사 오류");
 			e.printStackTrace();
 		}

	}

}

```
```java

package Exercise;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Exercise10_1 extends JFrame {

	private JLabel la = new JLabel("Love you");

	public Exercise10_1() {
		// TODO Auto-generated constructor stub
		setTitle("마우스 올리기 내리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

//		Container c = getContentPane();
//		c.addMouseListener(new MyMouseListener());
//		c.setLayout(new FlowLayout());
//		c.add(la);

		add(la);
		la.setSize(100, 50);
		la.addMouseListener(new MyMouseListener());

		setSize(300, 200);
		setVisible(true);
	}

	class MyMouseListener extends MouseAdapter {
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			JLabel la = (JLabel)e.getSource();
			la.setText("사랑해");
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			la.setText("Love you");
		}

	}
	public static void main(String[] args) {
		new Exercise10_1();
	}
}

```

```java

package Exercise;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Exercise10_2 extends JFrame {

	;
	public Exercise10_2() {
		// TODO Auto-generated constructor stub
	    setTitle("드래깅 하는동안 YELLOW 유지하는 예제");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(300, 200);
	    setVisible(true);
	    
	    Container c = getContentPane();
	    c.addMouseListener(new MyMouseMotion());
	}


	class MyMouseMotion extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Container c = (Container)e.getSource();
			c.setBackground(Color.YELLOW);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Container c = (Container)e.getSource();
			c.setBackground(Color.GREEN);
		}
	}
	public static void main(String[] args) {
		new Exercise10_2();

	}

}

```

```java

package Exercise;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class P582_3 extends JFrame{

   JLabel la = new JLabel();
   
   public P582_3() {
      
      setTitle("S");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      la.setText("Love Java");
      c.add(la);
      c.addKeyListener(new KeyListener() {
         
         @Override
         public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub
         }
         
         @Override
         public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
         }
         
         @Override
         public void keyPressed(KeyEvent e) {
            String x=la.getText();
            int keyCode=e.getKeyCode();
            if(KeyEvent.VK_LEFT==keyCode) {
               StringBuffer sb=new StringBuffer(x);
               char temp = sb.charAt(0);
               sb.deleteCharAt(0);
               sb.append(temp);
               la.setText(sb.toString());
            }
            if(KeyEvent.VK_RIGHT==keyCode) {
               StringBuffer sb=new StringBuffer(x);
               char temp = sb.charAt(sb.length()-1);
               sb.deleteCharAt(sb.length()-1);
               sb.insert(0, temp);
               la.setText(sb.toString());
            }
            if(KeyEvent.VK_UP==keyCode) {
               la.setFont(la.getFont ().deriveFont (la.getFont().getSize()+10.f));
            }
            if(KeyEvent.VK_DOWN==keyCode) {
               la.setFont(la.getFont ().deriveFont (la.getFont().getSize()-10.f));
            }
         }
      });
      setSize(200,200);
      setVisible(true);
      
      c.setFocusable(true);
      c.requestFocus();
   }
   public static void main(String[] args) {
      new P582_3();
   }

}
```

```java

package exexex;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GridLayoutEx extends JFrame {

	JLabel name;
	JLabel dateOfBirth;

	JButton search;
	JButton cancel;

	JTextField nameInput;
	JTextField dateOfBirthInput;

	public GridLayoutEx() {

		setTitle("GridLayout");
		setSize(350, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(3, 2));

		name = new JLabel("이름");
		dateOfBirth = new JLabel("주민번호");

		search = new JButton("조회");
		cancel = new JButton("취소");

		nameInput = new JTextField(2);
		dateOfBirthInput = new JTextField(2);

		search.addMouseListener(new MySearchListener());
		cancel.addMouseListener(new MyCancelListener());

		jpanel.add(name);
		jpanel.add(nameInput);

		jpanel.add(dateOfBirth);
		jpanel.add(dateOfBirthInput);

		jpanel.add(search);
		jpanel.add(cancel);

		add(jpanel);
		setVisible(true);

	}

	public static void main(String[] args) {
		new GridLayoutEx();

	}

	class MySearchListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			Component standard = (Component) e.getSource();
			if (standard.equals(search)) {
				if (nameInput.getText().equals("") && dateOfBirthInput.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이름과 주민번호를 입력하세요.");
					nameInput.requestFocus();

				} else if (nameInput.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
					nameInput.requestFocus();

				} else if (dateOfBirthInput.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "주민번호를 입력하세요.");
					dateOfBirthInput.requestFocus();

				} else {
					JOptionPane.showMessageDialog(null,
							"이름 : " + nameInput.getText() + "\n" + "주민번호 : " +       dateOfBirthInput.getText());
					nameInput.requestFocus();
				}
			}
		}
	}

	class MyCancelListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			nameInput.setText("");
			dateOfBirthInput.setText("");
		}
	}
}
```

```java

package Exercise;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class Exercise11_1 extends JFrame {
	private JCheckBox[] ckb = new JCheckBox[2];
	private String[] names = { "버튼 비활성화", "버튼 감추기" };

	JButton button = new JButton("TEST BUTTON");
	
	public Exercise11_1() {
		setTitle("1번문제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());


		MyItemListener listener = new MyItemListener();
		for (int i = 0; i < ckb.length; i++) {
			ckb[i] = new JCheckBox(names[i]);
			ckb[i].setBorderPainted(true);
			c.add(ckb[i]);
			ckb[i].addItemListener(listener);
		}

		c.add(button);
		setSize(250, 200);
		setVisible(true);
	}

	class MyItemListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (e.getItem() == ckb[0]) {
					button.setEnabled(false);
				} else if (e.getItem() == ckb[1]) {
					button.setVisible(false);
				}
			} else {
				if (e.getItem() == ckb[0]) {
					button.setEnabled(true);
				}
				if (e.getItem() == ckb[1]) {
					button.setVisible(true);
				}

			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Exercise11_1();

	}

}

```

```java

package Exercise;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Exercise11_2 extends JFrame {
	private JTextField field = new JTextField(10);
	JComboBox<String> input = new JComboBox<String>();
	
	public Exercise11_2() {
		setTitle("2번 문제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		
		
		c.add(field);
		c.add(input);
		
		field.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextField saveName = (JTextField)e.getSource();
				input.addItem(saveName.getText()+"\n");
				field.setText("");
			}
		});
		
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Exercise11_2();

	}

}

```

```java

package Exercise;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

class Clock implements Runnable {

	private JLabel time;
	
	public Clock(JLabel time) {
		this.time = time;
	
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			DigitalCalendar watch = new DigitalCalendar();
			time.setText(Integer.toString(watch.hour)+ ":" +Integer.toString(watch.minute)
					+":"+Integer.toString(watch.second));
		}
		
	}
	
}

class DigitalCalendar {
	
Calendar clock = Calendar.getInstance();

int hour = clock.get(Calendar.HOUR_OF_DAY);
int minute = clock.get(Calendar.MINUTE);
int second = clock.get(Calendar.SECOND);
}

public class Exercise13_3 extends JFrame {
	
	
	public Exercise13_3() {
		
		setTitle("디지탈 시계 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel time = new JLabel();
		time.setFont(new Font("Gothic", Font.ITALIC, 30));
		c.add(time);
		
		Clock clock = new Clock(time);
		Thread th = new Thread(clock);
		
		setSize(250, 200);
		setVisible(true);
		
		th.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Exercise13_3();

	}

}

```
```java

import java.sql.*;

public class JDBC_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn;
		Statement stmt = null;
		ResultSet srs;

		try {
			Class.forName("oracle.jdbc.OracleDriver");

			String user = "scott";
			String pwd = "tiger";
			String url = "jdbc:oracle:thin:@//localhost:1521/xe";

			conn = DriverManager.getConnection(url, user, pwd);

			System.out.println("Oracle DB연결에 성공하였습니다.");

			stmt = conn.createStatement();
			srs = stmt.executeQuery("select * from student");
            printData(srs);
			stmt.executeUpdate("delete from student where student_name = '헉길동'");
			srs = stmt.executeQuery("select student_name, student_id from student where student_name = '홍길동'");
			printData(srs);stmt.executeUpdate("insert into student(student_name, student_id) values('헉길동','4')");
			
			srs = stmt.executeQuery("select * from student");
			printData(srs);
			stmt.executeUpdate("update student set student_id = '2' where student_name = '후길동'");
			srs = stmt.executeQuery("select * from student");
			printData(srs);
			srs = stmt.executeQuery("select * from student order by student_id");
			printData(srs);
			
			srs.close();
			conn.close();
			stmt.close();
//			printData(srs);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 드라이버 로딩 실패 :" + e.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 접속실패 :" + e.toString());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("uknown Error");
		}

	}

	private static void printData(ResultSet srs) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------");
		while (srs.next()) {

			System.out.print(new String(srs.getString("student_name")));
			System.out.print("\t|\t" + srs.getString("student_id"));
			System.out.println();

		}
		System.out.println("---------------------------------");
	}

}

```

```java

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class JDBC_EX2 extends JFrame {
	private static Connection con;
	private static Statement stm = null;
	private static ResultSet sr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("oracle.jdbc.OracleDriver");

			String user = "scott";
			String pwd = "tiger";
			String url = "jdbc:oracle:thin:@//localhost:1521/xe";

			con = DriverManager.getConnection(url, user, pwd);

			System.out.println("Oracle DB연결에 성공하였습니다.");

			stm = con.createStatement();
			sr = stm.executeQuery("select * from student");
			printData(sr);
			stm.executeUpdate("delete from student where student_name = '헉길동'");
			sr = stm.executeQuery("select student_name, student_id from student where student_name = '홍길동'");
			printData(sr);
			stm.executeUpdate("insert into student(student_name, student_id) values('헉길동','4')");

			sr = stm.executeQuery("select * from student");
			printData(sr);
			stm.executeUpdate("update student set student_id = '2' where student_name = '후길동'");
			sr = stm.executeQuery("select * from student");
			printData(sr);
			sr = stm.executeQuery("select * from student order by student_id");
			printData(sr);


//				printData(sr);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 드라이버 로딩 실패 :" + e.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 접속실패 :" + e.toString());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("uknown Error");
		}

		new JDBC_EX2();
		
	}

	private static void printData(ResultSet srs) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------");
		while (srs.next()) {

			System.out.print(new String(srs.getString("student_name")));
			System.out.print("\t|\t" + srs.getString("student_id"));
			System.out.println();

		}
		System.out.println("---------------------------------");

	}

	public JDBC_EX2() {

		setTitle("EX2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new GridLayout(0,2));
		JButton btn = new JButton("DB확인");
		c.add(btn);

		JTextArea la = new JTextArea();
		c.add(la);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String output = "";
				la.setText(output);
				try {
					sr=stm.executeQuery("select * from student");
					
					while(sr.next()) {
						output = sr.getInt("student_id") +" "+ sr.getString("student_name");
						la.append("\n");
						la.append(output);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("오류 여기");
				}
				
			}
		});

		setSize(300, 300);
		setVisible(true);
	}
}
```

```java

import java.sql.*;
import java.util.Scanner;
class Test2 {
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url = "jdbc:oracle:thin:@//localhost/xe";
			String user = "scott";
			String pwd = "tiger";
			
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("DB연결 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("DB드라이버 로딩 실패:" + e.toString());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 접속 실패" + e.toString());
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
}

class JDBC_InputTest {
	Statement stmt;
	ResultSet rs;
	
	public void inputedConn() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름의 일부 글자 입력 : ");
		String name = sc.nextLine();
		
		try {
			stmt = new Test2().getConnection().createStatement();
			rs = stmt.executeQuery("select * from emp where upper(ENAME) like upper('%"+name+"%')");
			
			while(rs.next()) {
				System.out.print(rs.getString("EMPNO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.println();
			}
		} catch (SQLException e) {			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class JDBC_Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JDBC_InputTest().inputedConn();
		}

}

```

```java


import java.sql.*;
import java.util.Scanner;

class MyDBConn {
	public Connection getConn() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		Class.forName("oracle.jdbc.OracleDriver");

		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String user = "scott";
		String pwd = "tiger";

		conn = DriverManager.getConnection(url, user, pwd);
		System.out.println("연결 성공!");

		return conn;

	}

}

class MyDBStmt {

	public void getStmt() throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		Statement stmt;
		ResultSet rs;

		System.out.println("1.회원보기 2.회원등록 3.회원삭제 4.회원 수정");
		int input = sc.nextInt();
		sc.nextLine();
		stmt = new MyDBConn().getConn().createStatement();
		rs = stmt.executeQuery("select * from membership");
		switch (input) {

		case 1:
			while (rs.next()) {
				System.out.println("ID       NAME      NUM      PHONE");
				System.out.print(rs.getString("MEMBER_ID") + "\t");
				System.out.print(rs.getString("MEMBER_NAME") + "\t");
				System.out.print(rs.getString("MEMBER_NUM") + "\t");
				System.out.print(rs.getString("MEMBER_PHONE") + "\t");
				System.out.println();
			}
			break;
		case 2:			
			System.out.print("아이디 : ");
			String membershipId = sc.nextLine();

			if (checkId(membershipId)) {

				System.out.print("이름 : ");
				String membershipName = sc.nextLine();
				System.out.print("주민번호 : ");
				String membershipNum = sc.nextLine();
				System.out.print("연락처 : ");
				String membershipPhone = sc.nextLine();
				stmt.executeUpdate("insert into membership(MEMBER_ID,MEMBER_NAME,MEMBER_NUM,MEMBER_PHONE) " + "values('"
						+ membershipId + "'," + " '" + membershipName + "'," + "'" + membershipNum + "'," + "'"
						+ membershipPhone + "'" + ")");
			} else {
				System.out.println("중복된 아이디 입니다.");
			}
			break;
		case 3:
			System.out.print("삭제할 아이디 입력 : ");
			String deleteId = sc.nextLine();
			stmt.executeUpdate("delete from membership where MEMBER_ID = '" + deleteId + "'");
			break;
		case 4:
			System.out.print("수정 할 회원 전화번호 입력 : ");
			String modifyPhone = sc.nextLine();
			System.out.print("수정 할 회원 아이디 입력: ");
			String modifyId = sc.nextLine();
			stmt.executeUpdate(
					"update membership set MEMBER_PHONE ='" + modifyPhone + "' where MEMBER_ID = '" + modifyId + "'");
			break;
		}
		
		

		sc.close();
	}
	
	public boolean checkId(String id) throws ClassNotFoundException, SQLException {
		boolean check = true;
		Statement stmt = new MyDBConn().getConn().createStatement();
		ResultSet rs = stmt.executeQuery("select * from membership");
		while(rs.next()) {
			if(id.equals(rs.getString("MEMBER_ID"))) {
				check = false;
			}
		}
		return check;
		
	}
}

public class MyOracleTest {

	public static void main(String[] args) {
		try {
			new MyDBStmt().getStmt();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

```
```java
//sql연동문제

import java.sql.*;
import java.util.Scanner;

class Connect {

	public Connection getCon() throws ClassNotFoundException, SQLException {

		Connection conn = null;

		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String user = "scott";
		String pwd = "tiger";

		conn = DriverManager.getConnection(url, user, pwd);
		System.out.println("연결성공~");
		return conn;
	}

}

class Search {

	@SuppressWarnings("resource")
	public void getSearch() throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.print("팀명 또는 팀장 이름을 입력하세요>>");
		String name = sc.nextLine();

		Statement stmt;
		ResultSet rs;

		stmt = new Connect().getCon().createStatement();

		rs = stmt.executeQuery("select * from team");

		while (rs.next()) {

			if (name.equals(rs.getString("tname"))) {

				getTname(name);
				

			} else if(name.equals(rs.getString("captain"))) {
				getCaptainName(name);
				
			}
		}
	}

	public void getTname(String name) throws ClassNotFoundException, SQLException {

		Statement stmt;
		ResultSet rs;

		stmt = new Connect().getCon().createStatement();
		rs = stmt.executeQuery("select * from javastudent j join team t on( j.tno = t.tno)");

		rs = stmt.executeQuery("select j.name from javastudent j join team t on(j.tno = t.tno) "
				+ "where t.tname = (select tname from team where tname = '" + name + "') order by j.name");

		while (rs.next()) {
			System.out.print(rs.getString("name"));
			System.out.println();

		}
	}

	public void getCaptainName(String name) throws SQLException, ClassNotFoundException {

		Statement stmt;
		ResultSet rs;
		stmt = new Connect().getCon().createStatement();
		rs = stmt.executeQuery("select j.name from javastudent j join team t on(j.tno = t.tno) "
				+ "where t.captain = (select captain from team where captain = '" + name + "') order by j.name");

		while (rs.next()) {
			System.out.print(rs.getString("name"));
			System.out.println();
		}
	}
}

public class JDBC_Oracle_Java {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			new Search().getSearch();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
```
