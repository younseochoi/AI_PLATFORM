package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) {
		try {
		//현재내컴퓨터= 로컬호스트의 ip 정보 객체 
		InetAddress ip = InetAddress.getLocalHost();
		System.out.println("내컴퓨터의ip="+ip.getHostAddress());//ip 주소값
		
		// www.google.com ip 정보
		InetAddress[] ip2 = InetAddress.getAllByName("www.multicampus.co.kr");
		for(InetAddress inet : ip2) {
			System.out.println("다음 ip="+inet.getHostAddress());
		}
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
