import java.util.Scanner;

//o|o|o
//x|x|x
//o|x|o

//	配列の作成、表示
//	丸ばつの表示
//	勝ち負け判定
//[下へ↓（縦移動）][右へ→（横移動）]

public class OXgame {
	public static void  main(String[] args) {
//		OX 枠の確保！
		String[][] field = new String [3][3];
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 3; x++) {
				field[y][x] = " ";
			}
		}

		System.out.println("あなたからスタートです。　０〜２までの数字を入力してください");

		while(true) {
			input(field);
			output(field);
			if(judge(field, "o") == "finish" || judge(field, "o") ==  "draw") {
				break;
			}
			eneInput(field);
			output(field);
			if(judge(field, "x") == "finish" ||  judge(field, "x") ==  "draw") {
				break;
			}
		}
	}
	public static void input(String[][] field) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int y = sc.nextInt();
			int x = sc.nextInt();

			if(( x < 0 ||  2 < x) || (y < 0 ||  2 < y) || (field[y][x] != " ") ) {
				System.out.println("そこには入力できません。再度入力してください");
			}else {
				field[y][x] = "o";
				break;
			}
		}
//		sc.close();
	}
	public static void eneInput(String[][] field) {
		while(true) {
			int y = new java.util.Random().nextInt(3);
			int x = new java.util.Random().nextInt(3);
			if(( x < 0 ||  2 < x) || (y < 0 ||  2 < y) || (field[y][x] != " ") ) {
			}else {
				field[y][x] = "x";
				break;
			}
		}
	}

	public static void output(String[][] field) {
		System.out.println("------------------------------------");
		for(int i = 0;i < 3; i++ ) {
			for(int j = 0; j < 3; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------------------------------");
	}

	public static String judge(String[][] field, String obj) {
		String status;
		boolean answer = false;
		if( check(field, obj, answer) ||
			(field[0][0] == obj && field[1][1] == obj && field[2][2] == obj) || (field[0][2] == obj && field[1][1] == obj && field[2][0] == obj)) {
				System.out.println(obj + "の勝ちだ！");
				status = "finish";
		}else if(emptyCheck(field, answer)) {
			System.out.println("引き分けだ");
			status = "draw";
		}
		else {
			status = "continue";
		}
		return status;
	}

	public static boolean check(String[][] field, String obj, boolean answer) {
//		横確認
		if(answer == false) {
			for(int y = 0; y < 2; y++) {
				answer = field[y][0] == obj && field[y][1] == obj && field[y][2] == obj;
				if(answer == true) {break;}
			}
		}

//		縦確認
		if(answer == false) {
			for(int x = 0; x < 2; x++) {
				answer = field[0][x] == obj && field[1][x] == obj && field[2][x] == obj;
				if(answer == true) {break;}
			}
		}
		return answer;
	}

	public static boolean emptyCheck(String [][] field, boolean answer) {
		int empCount = 0;
		for(int y = 0;y < 3; y++ ) {
			for(int x = 0; x < 3; x++) {
				if(field[y][x] == " ") {empCount++;}
			}
		}
		if(empCount == 0) {
			answer = true;
		}
		return answer;
	}
}


