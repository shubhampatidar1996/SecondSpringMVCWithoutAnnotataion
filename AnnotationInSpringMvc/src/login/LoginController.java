package login;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import beans.EmployeeBean;
import dao.MyDao;

@Controller
public class LoginController {
	@RequestMapping("/")
	  public ModelAndView welcome()
	  {
		ModelAndView mv=new ModelAndView("Login");
		mv.addObject("msg", "Welcome To Spring MVC App");
		return mv;
	 }
	
	 @RequestMapping("/check")
	  public ModelAndView loginCheck(HttpServletRequest request)
	  {
		String u=request.getParameter("uid");
		String p=request.getParameter("pwd");
		ModelAndView mv=null;
		
		MyDao m=new MyDao();
		   int x=m.loginCheck(u, p);
		   
		   if(x==1)
			{
			  mv=new ModelAndView("WelcomeAdmin","msg","Login Success"); 
			}
			else {
				mv=new ModelAndView("Login","msg","Login Failed");
			}
		return mv;
	  }
	 @RequestMapping("/add")
	  public ModelAndView employeedetails()
	  {
		ModelAndView mv=new ModelAndView("AddEmployee");
		mv.addObject("msg", " Please Insert Employee Details");
		return mv;
	 }
	 @RequestMapping("/employee")
	  public ModelAndView insertEmployee(HttpServletRequest request)
	  {
		 
		 String n=request.getParameter("name");
		 String a=request.getParameter("address");
		 Integer s=Integer.parseInt(request.getParameter("salary"));
		 
		 
		EmployeeBean e=new EmployeeBean();
		e.setName(n);
		e.setAddress(a);
		e.setSalary(s);
		ModelAndView mv=null;
		
		MyDao m=new MyDao();
		   int x=m.insert(e);
		   
		   if(x!=0)
			{
			  mv=new ModelAndView("AddEmployee","msg","Data Inserted Successfully"); 
			}
			else {
				mv=new ModelAndView("AddEmployee","msg","Data Not Inserted");
			}
		return mv;
	  }
}
