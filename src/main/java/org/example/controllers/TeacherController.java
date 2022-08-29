package org.example.controllers;


import org.example.dao.TeacherDAO;
import org.example.entities.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/teachers")
public class TeacherController {

    private final TeacherDAO teacherDAO;
    private List<Teacher> teacherList;

    public TeacherController(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }


//    @RequestMapping(value = "/addTeacher", method = RequestMethod.GET)
//    public ModelAndView addTeacher() {
//        return new ModelAndView("addTeacher", "command", new Teacher());
//    }

    @GetMapping("/addTeacher")
    public String addTeacher () {
        return "addTeacher";
    }
    @RequestMapping(value = "/saveTeacher", method = RequestMethod.POST)
    public ModelAndView saveTeacher(@ModelAttribute Teacher teacher, BindingResult bindingResult) {
        if (bindingResult.hasErrors() | teacher.getSubject().isEmpty() | teacher.getGrade().isEmpty()
                | teacher.getName().isEmpty()) {
            return new ModelAndView("redirect:/error/errorPage");
        }
        teacherDAO.insertTeacher(teacher);
        teacherList = teacherDAO.getAllTeachers();
        return new ModelAndView("redirect:/teachers/viewAllTeachers");
    }

    @RequestMapping(value = "/viewAllTeachers", method = RequestMethod.GET)
    public ModelAndView viewAllTeachers() {
        teacherList = (teacherList != null) ? teacherList : getAllTeacher();
        return new ModelAndView("viewAllTeachers", "listOfTeachers", teacherList);
    }

    @RequestMapping(value = "/editTeacher/{id}", method = RequestMethod.GET)
    public ModelAndView editTeacher(@ModelAttribute Teacher teacher, @PathVariable("id") int id) {
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getId() == id) {
                teacher = teacherList.get(i);
            }
        }
        return new ModelAndView("editTeacher", "command", new Teacher(teacher.getId(), teacher.getName(), teacher.getSubject(), teacher.getGrade()));
    }

    @RequestMapping(value = "/saveEditTeacher", method = RequestMethod.POST)
    public ModelAndView saveEditTeacher(@ModelAttribute Teacher teacher, BindingResult bindingResult) {
        if (bindingResult.hasErrors() | teacher.getSubject().isEmpty() | teacher.getGrade().isEmpty()
                | teacher.getName().isEmpty()) {
            return new ModelAndView("redirect:/error/errorPage");
        }
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getId() == teacher.getId()) {
                teacherList.get(i).setName(teacher.getName());
                teacherList.get(i).setSubject(teacher.getSubject());
                teacherList.get(i).setGrade(teacher.getGrade());
                teacherDAO.updateTeacherByAll(teacher.getId(), teacher.getName(), teacher.getSubject(), teacher.getGrade());
            }
        }
        return new ModelAndView("redirect:/teachers/viewAllTeachers");
    }


    @RequestMapping(value = "/removeTeacher/{id}", method = RequestMethod.GET)
    public ModelAndView removeTeacher(@PathVariable int id) {
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getId() == id) {
                teacherDAO.removeTeacher(teacherList.get(i).getId());
                teacherList.remove(teacherList.get(i));
            }
        }
        return new ModelAndView("redirect:/teachers/viewAllTeachers");
    }

    private List<Teacher> getAllTeacher() {
        return teacherDAO.getAllTeachers();
    }
}
