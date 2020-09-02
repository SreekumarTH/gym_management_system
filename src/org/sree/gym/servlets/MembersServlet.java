package org.sree.gym.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sree.gym.bean.MemberBean;
import org.sree.gym.dao.MembersDao;

/**
 * Servlet implementation class MembersServlet
 */
@WebServlet("/")
public class MembersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MembersDao membersDAO;
	
	public void init() {
		membersDAO = new MembersDao();
	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertMember(request, response);
				break;
			case "/delete":
				deleteMember(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateMember(request, response);
				break;
			case "/list":
				listMember(request, response);
				break;
				
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
		
	


	private void listMember(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<MemberBean> listMember = membersDAO.selectAllMembers();
		request.setAttribute("listMember", listMember);
		RequestDispatcher dispatcher = request.getRequestDispatcher("memberslist.jsp");
		dispatcher.forward(request, response);		
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("memberform.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String username = request.getParameter("username");
		MemberBean existingUser = membersDAO.selectMember(username);
		RequestDispatcher dispatcher = request.getRequestDispatcher("memberform.jsp");
		request.setAttribute("member", existingUser);
		dispatcher.forward(request, response);		
	}

	private void insertMember(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		MemberBean newMember = new MemberBean(username, password, name, age);
		membersDAO.insertMember(newMember);
		response.sendRedirect("list");		
	}
	
	private void updateMember(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		MemberBean gym = new MemberBean(username, password, name, age);
		membersDAO.updateMember(gym);
		response.sendRedirect("list");
	}
	
	private void deleteMember(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException  {
		String username = request.getParameter("username");
		membersDAO.deleteMember(username);
		response.sendRedirect("list");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
