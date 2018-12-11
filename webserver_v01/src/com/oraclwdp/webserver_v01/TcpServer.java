package com.oraclwdp.webserver_v01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args){
		ServerSocket serverSocket = null;
		//开饭店
		try {
			serverSocket = new ServerSocket(80);
			//等人来，来了让服务员交流
			while(true) {
				Socket baoxiao = serverSocket.accept();
				new ServerThread(baoxiao).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
		}
		
		
		
	}

}
