package com.pj224.app.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj224.app.Result;
import com.pj224.app.member.LoginOkController;

/**
 * Servlet implementation class MypageFrontController
 */
//@WebServlet("/MypageFrontController")
public class MypageFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MypageFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Mypage 서블릿 실행");
		

		// request.getContextPath() URL루트경로를 의미
		System.out.println(request.getContextPath()+ "");

		// request.getRequestURI 현재 요청의 URI를 의미
		System.out.println(request.getRequestURI() + "URI");

		// 전체 URI에서 ContextPath를 제외시킨 부분만 변수에 저장(분기처리할 때 비교할 변수로 사용)
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(target);

	      Result result = null; 
	      
		switch (target) {
		case "/app/mypage/my-profile.my":
			System.out.println("profile");
			request.getRequestDispatcher("/app/mypage/my-profile.jsp").forward(request, response);
			break;
		case "/app/mypage/passcheck.my":
			System.out.println("비밀번호 확인");
//			result = new MypasscheckOkController().MemExecute(request, response);
			response.sendRedirect(request.getContextPath() + "/mypage/my-update.jsp");
			break;
		case "/app/mypage/passcheckOk.my":
			System.out.println("비밀번호 확인 성공");
			result = new MypasscheckOkController().MemExecute(request, response);
			break;
		}
		
		if (result != null) {
			if(result.isRedirect()) {
				response.sendRedirect(result.getPath());
			}else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}

	}

}
