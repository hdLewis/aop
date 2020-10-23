package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@Controller
@RequestMapping("/rest")
public class TestRestController {
   @RequestMapping(value = "jsp",method = RequestMethod.GET)
   public String toJsp() throws IOException{
       return "rest";
   }

   @RequestMapping(method = RequestMethod.GET)
    public void get(HttpServletResponse resp, @RequestParam Map map) throws IOException{
       PrintWriter out=resp.getWriter();
       out.print("GET"+map);
   }

   @RequestMapping(method = RequestMethod.DELETE)
   public void delete(HttpServletResponse resp, @RequestParam Map map) throws IOException{
       PrintWriter out=resp.getWriter();
       out.print("DELETE,@Map"+map);
   }

   @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(HttpServletResponse resp, @RequestParam Map map, @PathVariable int id) throws IOException{
      PrintWriter out=resp.getWriter();
      out.print("DELETE/{id},@Map:" + map +",@PathVariable:"+id);
   }

   @RequestMapping(method = RequestMethod.PUT)
    public void put(HttpServletResponse resp,@RequestParam Map map)throws IOException{
       PrintWriter out=resp.getWriter();
       out.print("PUT"+map);
   }

   @RequestMapping(method = RequestMethod.POST)
    public void post(HttpServletResponse resp,@RequestParam Map map)throws IOException{
       PrintWriter out=resp.getWriter();
       out.print("POST"+map);
   }


}




















