package org.example.controllers;


import org.example.dao.StudentsDAO;
import org.example.entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/students")
public class StudentController {

    public StudentsDAO studentsDAO;
    private List<Student> studentList;

    public StudentController(StudentsDAO studentsDAO) {
        this.studentsDAO = studentsDAO;
    }


    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public ModelAndView addStudent() {
        return new ModelAndView("addStudent", "command", new Student());
    }

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public ModelAndView saveStudent(@ModelAttribute Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors() | student.getName().isEmpty() | student.getGroup().isEmpty()
                | student.getAge() == 0) {
            return new ModelAndView("redirect:/error/errorPage");
        }
        studentsDAO.insertStudent(student);
        studentList = studentsDAO.getAllStudents();
        return new ModelAndView("redirect:/students/viewAllStudents");
    }


    @RequestMapping(value = "/editStudent/{id}", method = RequestMethod.GET)
    public ModelAndView editStudent(@ModelAttribute Student student, @PathVariable("id") int id) {
        for (Student value : studentList) {
            if (value.getId() == id) {
                student = value;
            }
        }
        return new ModelAndView("editStudent", "command", new Student(student.getId(), student.getName(), student.getAge(), student.getGroup()));
    }


    @RequestMapping(value = "/saveEditStudent", method = RequestMethod.POST)
    public ModelAndView saveEditStudent(@ModelAttribute Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors() | student.getName().isEmpty() | student.getGroup().isEmpty()
                | student.getAge() == 0) {
            return new ModelAndView("redirect:/error/errorPage");
        }
        for (Student value : studentList) {

            if (value.getId() == student.getId()) {
                value.setAge(student.getAge());
                value.setName(student.getName());
                value.setGroup(student.getGroup());
                studentsDAO.updateStudentByAll(student.getId(), student.getName(), student.getAge(), student.getGroup());
            }
        }
        return new ModelAndView("redirect:/students/viewAllStudents");
    }


    @RequestMapping(value = "/removeStudent/{id}", method = RequestMethod.GET)
    public ModelAndView removeStudent(@PathVariable int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentsDAO.removeStudent(studentList.get(i).getId());
                studentList.remove(studentList.get(i));
            }
        }
        return new ModelAndView("redirect:/students/viewAllStudents");
    }

    @RequestMapping(value = "/viewAllStudents", method = RequestMethod.GET)
    public ModelAndView viewAllStudents() {
        studentList = (studentList != null) ? studentList : getAllStudents();
        return new ModelAndView("viewAllStudents", "listOfStudents", studentList);
    }

    private List<Student> getAllStudents() {
        return studentsDAO.getAllStudents();
    }

    // Controller for Search

    ArrayList<Student> studentsSearch = new ArrayList<>();

    @RequestMapping(value = "/searchPerson", method = RequestMethod.GET)
    public ModelAndView viewPerson() {
        return new ModelAndView("searchPerson", "listOfStudents", studentsSearch);
//        return new ModelAndView("searchPerson");
    }

    @RequestMapping(value = "/searchPersonId", method = RequestMethod.POST)
    public ModelAndView searchPersonId(@RequestParam String id) {
        try {
            studentsSearch = (ArrayList<Student>) studentsDAO.getStudentById(Integer.parseInt(id));
        } catch (NumberFormatException ex) {
            return new ModelAndView("redirect:/error/errorPage");
        }
        return new ModelAndView("redirect:/students/searchPerson");
    }

    @RequestMapping(value = "/searchPersonName", method = RequestMethod.POST)
    public ModelAndView searchPerson(@RequestParam String username) {
        if (username.isEmpty()) {
            return new ModelAndView("redirect:/error/errorPage");
        }
        studentsSearch = (ArrayList<Student>) studentsDAO.getStudentByName(username);
        return new ModelAndView("redirect:/students/searchPerson");
    }

    @RequestMapping(value = "/searchPersonAge", method = RequestMethod.POST)
    public ModelAndView searchPersonAge(@RequestParam String age) {
        try {
            studentsSearch = (ArrayList<Student>) studentsDAO.getStudentByAge(Integer.parseInt(age));
        } catch (NumberFormatException e) {
            return new ModelAndView("redirect:/error/errorPage");
        }
        return new ModelAndView("redirect:/students/searchPerson");
    }

    @RequestMapping(value = "/searchPersonGroup", method = RequestMethod.POST)
    public ModelAndView searchPersonGroup(@RequestParam String group) {
        if (group.isEmpty()) {
            return new ModelAndView("redirect:/error/errorPage");
        }
        studentsSearch = (ArrayList<Student>) studentsDAO.getStudentByGroup((group));
        return new ModelAndView("redirect:/students/searchPerson");
    }

    public ArrayList<Student> myList = new ArrayList<>();


}
