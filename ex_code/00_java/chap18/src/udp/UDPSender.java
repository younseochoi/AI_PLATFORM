package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPSender {

	public static void main(String[] args) {
		try {
		DatagramSocket sender = new DatagramSocket();//보내는 컴퓨터 os 랜덤 포트 지정
		System.out.println("==발신 시작==");
		
		String message = "폭염에 조심하세요";
		byte[] message_byte = message.getBytes();
		DatagramPacket pack = new DatagramPacket(message_byte, message_byte.length, 
				new InetSocketAddress("172.30.1.5" , 15000 ) );
		sender.send(pack);
		String message2 = "코로나나 다시 증가세를 보입니다";
		byte[] message_byte2 = message2.getBytes();
		DatagramPacket pack2 = new DatagramPacket(message_byte2, message_byte2.length, 
				new InetSocketAddress("172.30.1.5" , 15000 ) );
		sender.send(pack2);
		System.out.println("==발신 종료==");
		sender.close();
		
/*		DatagramSocket sender2 = new DatagramSocket();//보내는 컴퓨터 os 랜덤 포트 지정
		System.out.println("==발신 시작==");
		String message2 = "코로나나 다시 증가세를 보입니다";
		byte[] message_byte2 = message2.getBytes();
		DatagramPacket pack2 = new DatagramPacket(message_byte2, message_byte2.length, 
				new InetSocketAddress("172.30.1.5" , 15000 ) );
		sender2.send(pack2);
		
		
		System.out.println("==발신 종료==");
		sender2.close();
		*/
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
