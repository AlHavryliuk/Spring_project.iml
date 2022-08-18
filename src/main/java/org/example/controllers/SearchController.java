package org.example.controllers;


import org.example.dao.StudentsDAO;
import org.example.entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/search")
public class SearchController {


    private List searchList;

    private StudentsDAO studentsDAO;


    public SearchController(List searchList, StudentsDAO studentsDAO) {
        this.searchList = searchList;
        this.studentsDAO = studentsDAO;
    }


    @RequestMapping(value = "/searchPerson", method = RequestMethod.GET)
    public ModelAndView viewPerson() {
        searchList = (searchList != null) ? searchList : getSearchList();
        return new ModelAndView("searchPerson", "searchList", searchList);
    }

    @RequestMapping(value = "/saveSearchPersonId", method = RequestMethod.POST)
    public ModelAndView saveSearchPersonId(@RequestParam int id) {
        List<Student> temp = studentsDAO.getAllStudents();
        searchList.clear();
        for (Student student : temp) {
            if (student.getId() == id) {
                searchList.add(student);
            }
        }
        return new ModelAndView("redirect:/search/searchPerson");
    }

    @RequestMapping(value = "/saveSearchPersonName", method = RequestMethod.POST)
    public ModelAndView saveSearchPerson(@RequestParam String username) {
        List<Student> temp = studentsDAO.getAllStudents();
        searchList.clear();
        for (Student student : temp) {
            if (student.getName().equals(username)) {
                searchList.add(student);
            }
        }
        return new ModelAndView("redirect:/search/searchPerson");
    }

    @RequestMapping(value = "/saveSearchPersonAge", method = RequestMethod.POST)
    public ModelAndView saveSearchPersonAge(@RequestParam int age) {
        List<Student> temp = studentsDAO.getAllStudents();
        searchList.clear();
        for (Student student : temp) {
            if (student.getAge() == age) {
                searchList.add(student);
            }
        }

        return new ModelAndView("redirect:/search/searchPerson");
    }

    @RequestMapping(value = "/saveSearchPersonGroup", method = RequestMethod.POST)
    public ModelAndView saveSearchPersonGroup(@RequestParam String group) {
        List<Student> temp = studentsDAO.getAllStudents();
        searchList.clear();
        for (Student student : temp) {
            if (student.getGroup().equals(group)) {
                searchList.add(student);
            }
        }
        return new ModelAndView("redirect:/search/searchPerson");
    }

    private List getSearchList() {
        searchList = new ArrayList<>();
        return searchList;
    }
}
