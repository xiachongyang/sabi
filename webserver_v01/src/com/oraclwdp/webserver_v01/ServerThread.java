package com.oraclwdp.webserver_v01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	private Socket baoxiao;

	public ServerThread(Socket baoxiao) {
		this.baoxiao = baoxiao;
	}

	@Override
	public void run() {
		PrintWriter out = null;
		BufferedReader br = null;
		try {
			out = new PrintWriter(baoxiao.getOutputStream());
//			out.println("欢迎光临----逗逼");
			//1响应行
			out.println("HTTP/1.1 200 OK");
			//2若干行
			out.println("Content-Type: text/html;charset=utf-8");
			//3空白行
			out.println();
			out.println("<title>我的第一个页面</title>");
			//4正文
			out.print("<b style='color:blue'>欢迎光临----逗逼</b>");
			out.flush();
			// 收消息
//			br = new BufferedReader(new InputStreamReader(baoxiao.getInputStream()));
//			 String msg = br.readLine();
//			 System.out.println(msg);
			

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				out.close();
			}
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
		}

	}

}
