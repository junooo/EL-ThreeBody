package util;

import io.NetClient;

import java.rmi.RemoteException;
import java.util.Scanner;

import server.AccountCenter;
import server.interfaces.RMIAccountCenter;

public class ServerCommand {
	
	static RMIAccountCenter accountCenter = NetClient.getInstance().getAccountCenter();
	
	public static void main(String[] args) throws RemoteException {
		Scanner scanner = new Scanner(System.in);
		boolean finish = false;
		while(!finish){
			String command = scanner.nextLine();
			String[] parts = command.split(" ");
			String result;
			switch(parts[0]){
			case "close":
				finish = true;
				break;
			default:
				result = accountCenter.command(command);
				System.out.println(result);
				break;
			}
		}
		scanner.close();
	}
	
}
