package com.example.basak.springrenew.controller;

import com.example.basak.springrenew.model.dto.TaskInfoDto;
import com.example.basak.springrenew.service.FlatService;
import com.example.basak.springrenew.service.ResourceService;
import com.example.basak.springrenew.service.TaskInfoService;
import com.example.basak.springrenew.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/flat")
public class FlatController {

    private final FlatService flatService;
    private final UserService userService;
    private final TaskInfoService taskInfoService;
    private final ResourceService resourceService;

    public FlatController(FlatService flatService,
                          UserService userService,
                          TaskInfoService taskInfoService,
                          ResourceService resourceService) {
        this.flatService = flatService;
        this.userService = userService;
        this.taskInfoService = taskInfoService;
        this.resourceService = resourceService;
    }

    @PostMapping
    public String registerTask(@Valid TaskInfoDto taskInfo, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            taskInfoService.saveTaskInfo(taskInfo);
        }
        return "";
    }

    @GetMapping()
    public String mainPage(Model model) {
        model.addAttribute("currentUserEmail", userService.getCurrentUser().getEmail());
        model.addAttribute("currentUserName", userService.getCurrentUser().getName());
        return "main";
    }
//    @GetMapping("/register-task")
//    public String getRegisterTaskPage(Model model) {
//        model.addAttribute("currentUserEmail", userService.getCurrentUser().getEmail());
//        model.addAttribute("currentUserName", userService.getCurrentUser().getName());
//        return "register-task";

//    }

    @GetMapping("/tasks")
    public String getRegisterTasks(Model model) {
        Collection<TaskInfoDto> tasks = taskInfoService.getAllTaskForCurrentUser();
        model.addAttribute("tasks", tasks);
        model.addAttribute("taskToResource", taskInfoService.getTaskIdToResourceNameMap(tasks));
        return "task-list";
    }
}
