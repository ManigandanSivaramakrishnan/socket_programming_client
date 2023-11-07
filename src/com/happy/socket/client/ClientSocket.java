package com.happy.socket.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSocket {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = null;
		InputStreamReader inputStreamReader = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		
		socket = new Socket("localhost", 1234);
		inputStreamReader = new InputStreamReader(socket.getInputStream());
		outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
		
		bufferedReader = new BufferedReader(inputStreamReader);
		bufferedWriter = new BufferedWriter(outputStreamWriter);
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			String messageToBeSent = scanner.nextLine();
			
			bufferedWriter.write(messageToBeSent);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			
			System.out.println("Server " + bufferedReader.readLine());
			
			if(messageToBeSent.equalsIgnoreCase("BYE"))
				break;
		}
		
	}

}
