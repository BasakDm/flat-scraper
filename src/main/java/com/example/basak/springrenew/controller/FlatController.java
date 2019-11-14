package com.example.basak.springrenew.controller;

import com.example.basak.springrenew.model.TaskInfo;
import com.example.basak.springrenew.service.FlatService;
import com.example.basak.springrenew.service.TaskInfoService;
import com.example.basak.springrenew.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flat")
public class FlatController {

    private final FlatService flatService;
    private final UserService userService;
    private final TaskInfoService taskInfoService;

    public FlatController(FlatService flatService,
                          UserService userService,
                          TaskInfoService taskInfoService) {
        this.flatService = flatService;
        this.userService = userService;
        this.taskInfoService = taskInfoService;
    }

    @PostMapping(path = "/register-task")
    public String registerTask(@ModelAttribute TaskInfo taskInfoParams) {
        taskInfoParams.setUserDetails(userService.getCurrentUser());
        taskInfoService.saveTaskInfo(taskInfoParams);
        return "redirect:";
    }

    @GetMapping("/register-task")
    public String getRegisterTaskPage(Model model) {
        model.addAttribute("currentUserEmail", userService.getCurrentUser().getEmail());
        model.addAttribute("currentUserName", userService.getCurrentUser().getName());
        return "register-task";
    }

    @GetMapping("/tasks")
    public String getRegisterTasks(Model model) {
        model.addAttribute("tasks", flatService.getAllTaskParams());
        return "task-list";
    }

    @GetMapping()
    public String mainPage() {
        return "main";
    }
}
