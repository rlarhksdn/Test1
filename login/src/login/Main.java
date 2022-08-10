package login;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("로그인을 시작하 겠 습니다.");
		String id,pw,tel;		
		Check check = new Check();
		Check del = new Check();
		Check find = new Check();
		Check find1 = new Check();	
		
		for(;;) {
		System.out.println("로그인을 할려면 1, 회원가입을 할려면 2, 회원삭제는 3, 아이디 찾기는 4, 비밀번호 찾기는 5를 입력해주세요");
		int menu=sc.nextInt();
		sc.nextLine();//숫자 입력후 엔터값 없애기
		if (menu==1) {
			System.out.println("아이디를 입력해주세요:");
			id=sc.nextLine();
			System.out.println("패스워드를 입력해주세요:");
			pw=sc.nextLine();
			//객체(check)의 메소드(login(string id, string pw):int (1:아이디가 틀리다를
			//2.패스워드 틀리다. 3:로그인 성공을 통해서 로그인 여부 확인
        
           int flag = check.login(id,pw);
          
           
		}
		else if(menu==2){
		
		System.out.println("회원가입을 시작합니다");
		System.out.println("아이디를 입력해주세요:");
		id=sc.nextLine();
		System.out.println("비밀번호를 입력해주세요:");
		pw=sc.nextLine();
		check.signUp(id,pw);
		System.out.println("회원가입 완료");
							     
	}
		if(menu==3) {
			System.out.println("삭제할 아이디를 입력해주세요:");
			id=sc.nextLine();
			System.out.println("삭제할 비밀번호를 입력해주세요:");
			pw=sc.nextLine();
			check.del(id,pw);
			System.out.println("회원삭제 완료");
		}
		if(menu==4) {
			System.out.println("찾으시려는 ID의 비밀번호를 입력해주세요");
			pw=sc.nextLine();	
			System.out.println("ID 찾기를 위하여 전화번호를 입력해주세요");
			tel=sc.nextLine();
			check.find1(pw);
		}				
		if(menu==5) {
			System.out.println("비밀번호 찾으시려는 ID를 입력하세요");
			id=sc.nextLine();	
			System.out.println("비밀번호 찾기를 위하여 전화번호를 입력해주세요");
			tel=sc.nextLine();
			check.find(id);															
				}
		             	 									
			                }					
	}
	}
