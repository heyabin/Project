package com.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.action.IStudentAction;
import com.bean.PageBean;
import com.po.Student;
import com.service.biz.BizService;

@Namespace("/")
@Controller
@ParentPackage("struts-default")
public class StudentAction  implements IStudentAction{
	@Resource(name ="BizService")
	private BizService bizService;
	
	private String path;
	private Student student;
	private Integer stuId;
	private int page;
	private int rows;
	
	
	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}

	
	public String getPath() {
		return path;
	}

	
	public void setPath(String path) {
		this.path = path;
	}

	
	public Student getStudent() {
		return student;
	}

	
	public void setStudent(Student student) {
		this.student = student;
	}

	
	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	@Action(value="save_Student",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String save() {
		boolean flag=bizService.getStudentBiz().save(student);
		if(flag){
			
			path="findAll_Student";
			return "ok";
		}
		return null;
	}
	@Action(value="update_Student",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String update() {
		boolean flag=bizService.getStudentBiz().update(student);
		if(flag){
			path="findAll_Student";
			return "ok";
		}
		return null;
	}
	@Action(value="delById_Student",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String delById() {
		System.out.println("aaaa");
		boolean flag=bizService.getStudentBiz().delById(stuId);
		if(flag){
			path="findAll_Student";
			return "ok";
		}
		return null;
	}
	@Action(value="findById_Student",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String findById() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		Student oldStudent = bizService.getStudentBiz().findById(stuId);
		session.setAttribute("oldStudent",oldStudent);
		path="background/updateStudent.jsp";
		return "ok";
	}
	@Action(value="findAll_Student",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String findAll() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		PageBean pb=(PageBean) session.getAttribute("pb");
		pb=pb==null?new PageBean():pb;
		System.out.println(pb+"------------");
		page=page==0?pb.getPage():page;
		rows=rows==0?pb.getRows():rows;
		
		
		//获取最大页数
		int maxpage=bizService.getStudentBiz().getpageCount(rows);
		if(page>maxpage) page=maxpage;
		
		//获取当前页的记录集合/rows每页记录数，page当前页数
		List<Student> students=bizService.getStudentBiz().getnowPageData(rows, page);
		//获取当前页的实际记录数
		int num=students.size();
		pb.setMaxpage(maxpage);
		pb.setPage(page);
		pb.setRows(rows);
		pb.setPagelist(students);
		
		session.setAttribute("pb",pb);
		session.setAttribute("num",num);
		path="background/studentList.jsp";
		return "ok";

	}

}
