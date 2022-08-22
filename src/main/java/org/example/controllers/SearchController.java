package org.example.controllers;


import org.example.dao.StudentsDAO;
import org.example.entities.Student;
import org.springframework.stereotype.Controller;
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
    public ModelAndView saveSearchPersonId(@RequestParam String id) {
        try {
            int parseId = Integer.parseInt(id);
            if (parseId > 0) {
                List<Student> temp = studentsDAO.getAllStudents();
                searchList.clear();
                for (Student student : temp) {
                    if (student.getId() == parseId) {
                        searchList.add(student);
                    }
                }
            }
        } catch (NumberFormatException ex) {
            return new ModelAndView("redirect:/error/errorPage");
        }
        return new ModelAndView("redirect:/search/searchPerson");
    }

    @RequestMapping(value = "/saveSearchPersonName", method = RequestMethod.POST)
    public ModelAndView saveSearchPerson(@RequestParam String username) {
        if (username.isEmpty()) {
            return new ModelAndView("redirect:/error/errorPage");
        }
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
    public ModelAndView saveSearchPersonAge(@RequestParam String age) {
        try {
            int parseAge = Integer.parseInt(age);
            if (parseAge > 0) {
                List<Student> temp = studentsDAO.getAllStudents();
                searchList.clear();
                for (Student student : temp) {
                    if (student.getAge() == parseAge) {
                        searchList.add(student);
                    }
                }
            }
        } catch (NumberFormatException e) {
            return new ModelAndView("redirect:/error/errorPage");
        }
        return new ModelAndView("redirect:/search/searchPerson");
    }

    @RequestMapping(value = "/saveSearchPersonGroup", method = RequestMethod.POST)
    public ModelAndView saveSearchPersonGroup(@RequestParam String group) {
        if (group.isEmpty()) {
            return new ModelAndView("redirect:/error/errorPage");
        }
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
