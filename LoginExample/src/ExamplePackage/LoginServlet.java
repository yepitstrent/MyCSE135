package ExamplePackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static UserBean user = new UserBean();
    public static HttpSession session;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException 
    { 
      int test;        
      if(request.getParameter("st").equals("default") )
      {
    	  test = -1;
      }
      else
      {
        test = Integer.parseInt( request.getParameter("st") );
      }
      switch( test )
      {
        case 0://Log in servlet
        {    
          System.out.println("Login Servlet");
          try 
          { 
            System.out.println("get un: " + request.getParameter("un") + " B4 dao.login");
            user.setUserName(request.getParameter("un")); 
            user = UserDAO.login(user); 
        
            if (user.isValid()) 
            { 
              session = request.getSession(true); 
              session.setAttribute("currentSessionUser",user);
              System.out.println("B4 userlogged.jsp");
              response.sendRedirect("userLogged.jsp"); 
              //logged-in page 
            } 
            else
            { 
              response.sendRedirect("invalidLogin.jsp"); 
            }
            //error page 
          } 
          catch (Throwable theException) 
          { 
            System.out.println(theException); 
          }
          break;
        }//end case 0
        case 1: //Sign up servlet
        {
            System.out.println("Signup Servlet");	
            try 
            { 
               
              user.setUserName(request.getParameter("newUN")); 
              user.setRole(request.getParameter("Role")); 
              user.setAge( Integer.parseInt( request.getParameter("Age") ) );
              user.setState(request.getParameter("state"));
              user = UserDAO.signup(user); 
          
              if (user.isValid()) 
              { 
                session = request.getSession(true); 
                session.setAttribute("currentSessionUser",user); 
                response.sendRedirect("userLogged.jsp"); 
                //logged-in page 
              } 
              else
              { 
            	System.out.println("LoginServlet: 1");
                response.sendRedirect("invalidSignup.jsp"); 
              }
              //error page 
            } 
            catch (Throwable theException) 
            { 
              System.out.println(theException); 
            }
            break;
        }//end case 1
        case 2:
        {
        	System.out.println("ProductOwner Servlet");
        		
            try 
            { 
              if (user.isValid()) 
              { 
            	  user = UserDAO.setIDSignup(user);
            	  System.out.println("AM I VALID");
                  /*user.setCatID(request.getParameter("catname")); 
                  user.setProdName(request.getParameter("prodname")); 
                  user.setProdSKU( request.getParameter("prodsku") );
                  user.setProdPrice(request.getParameter("prodprice"));
                  user.setProdDesc( request.getParameter("proddesc") );
                  user = UserDAO.productOwner(user);*/
            	  user = UserDAO.getAllCategories(user);
                  session = request.getSession(true);  
                  response.sendRedirect("productOwner.jsp"); 
                   
              } 
              else
              { 
            	  //not loggedin, must not procede
            	System.out.println("LoginServlet: 2");
                response.sendRedirect("invalidLogin.jsp"); 
              }
              //error page 
            } 
            catch (Throwable theException) 
            { 
              System.out.println(theException); 
            }
            break;
        }
        case 3:
        {
        	System.out.println("Add Product");
        	try 
            { 
              if (user.isValid()) 
              { 
            	System.out.println("AM I VALID");
            	user.setCatID(request.getParameter("catList")); 
                user.setProdName(request.getParameter("prodname")); 
                user.setProdSKU( request.getParameter("prodsku") );
                user.setProdPrice(request.getParameter("prodprice"));
                user.setProdDesc( request.getParameter("proddesc") );
                user = UserDAO.productOwner(user); 
                session = request.getSession(true);  
                response.sendRedirect("userLogged.jsp"); 
                //logged-in page 
              } 
              else
              { 
            	System.out.println("LoginServlet: 3");
                response.sendRedirect("invalidLogin.jsp"); 
              }
              //error page 
            } 
            catch (Throwable theException) 
            { 
            	
              System.out.println(theException); 
            }
        	break;
        }
        case 4:
        {
        	System.out.println("CategoryOwner Servlet");
    		
            try 
            { 
              if (user.isValid()) 
              { 
            	  System.out.println("AM I VALID");
            	  user = UserDAO.getAllCategories(user);
                session = request.getSession(true);  
                response.sendRedirect("categoryOwner.jsp"); 
                 
              } 
              else
              { 
            	  //not loggedin, must not procede
            	System.out.println("LoginServlet: 4");
                response.sendRedirect("invalidLogin.jsp"); 
              }
              //error page 
            } 
            catch (Throwable theException) 
            { 
              System.out.println(theException); 
            }
            break;
        }
        case 5:
        {
        	System.out.println("Add Category");
        	try 
            { 
              if (user.isValid()) 
              { 
            	System.out.println("AM I VALID");
            	user.setCatName(request.getParameter("catname")); 
                user.setCatDesc( request.getParameter("catdesc") );
                //user = UserDAO.getAllCategories(user);
                user = UserDAO.categoryOwner(user); 
                session = request.getSession(true);  
                response.sendRedirect("userLogged.jsp"); 
                //logged-in page 
              } 
              else
              { 
            	System.out.println("LoginServlet: 5");
                response.sendRedirect("invalidLogin.jsp"); 
              }
              //error page 
            } 
            catch (Throwable theException) 
            { 
              System.out.println(theException); 
            }
        	break;
        }

        case 6:
        {
          System.out.println("Delete Category");
          try 
            { 
              if (user.isValid()) 
              { 
              System.out.println("AM I VALID");
              user.setCatName(request.getParameter("catList")); 
                user = UserDAO.categoryOwner(user); 
                session = request.getSession(true);  
                response.sendRedirect("userLogged.jsp"); 
                //logged-in page 
              } 
              else
              { 
              System.out.println("LoginServlet: 5");
                response.sendRedirect("invalidLogin.jsp"); 
              }
              //error page 
            } 
            catch (Throwable theException) 
            { 
              System.out.println(theException); 
            }
          break;
        }
        case 7:
        {
        	System.out.println("products browsing by partial string ");
        	//get all products by partial string
        	
        	try 
            { 
              if (user.isValid()) 
              { 
            	System.out.println("AM I VALID");

                user.setProdSearchStr(request.getParameter("prodname"));
                System.out.println("IN CASE7 "+ request.getParameter("prodname"));
                user = UserDAO.getProdFromString(user); 
                session = request.getSession(true);  
                response.sendRedirect("productsDisplay.jsp"); 
                //logged-in page 
              } 
              else
              { 
            	System.out.println("LoginServlet: 7");
                response.sendRedirect("invalidLogin.jsp"); 
              }
              //error page 
            } 
            catch (Throwable theException) 
            { 
              System.out.println(theException); 
            }
        	break;
        }
        default:
        {
        	System.out.println("DEFAULT");
        	user.setValid(false);
        	response.sendRedirect("LoginPage.jsp");
        }//end default
      }//end switch 
    } 
      


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
