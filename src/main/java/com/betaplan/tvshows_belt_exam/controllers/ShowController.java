package com.betaplan.tvshows_belt_exam.controllers;

import com.betaplan.tvshows_belt_exam.models.Rating;
import com.betaplan.tvshows_belt_exam.models.Show;
import com.betaplan.tvshows_belt_exam.models.User;
import com.betaplan.tvshows_belt_exam.services.RatingService;
import com.betaplan.tvshows_belt_exam.services.ShowService;
import com.betaplan.tvshows_belt_exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ShowController {
    @Autowired
    private ShowService showService;
    @Autowired
    private UserService userService;
    @Autowired
    private RatingService ratingService;

    @GetMapping("/shows")
    public String showShow(@ModelAttribute("rating")Rating rating, HttpSession session, Model model) {
        Long userId = ((Long) session.getAttribute("userId"));
        if (userId == null) {
            return "redirect:/";
        } else {
            User authenticatedUser = userService.findUserById(userId);
            model.addAttribute("user", authenticatedUser);
            model.addAttribute("shows", showService.findAllShows());
            return "show/index";
        }
    }


    @GetMapping("shows/new")
        public String createShow(@ModelAttribute("show") Show show,HttpSession session, Model model){
            Long userId = ((Long) session.getAttribute("userId"));
            if(userId==null){
                return "redirect:/";
            }else{
                User authenticatedUser = userService.findUserById(userId);
                model.addAttribute("user", authenticatedUser);
                return "show/new";
            }
        }
    @PostMapping("/shows/create")
    public String createShow(@Valid @ModelAttribute("show")Show show, BindingResult result, HttpSession session){
        Long userId = ((Long) session.getAttribute("userId"));
        if (userId == null) {
            return "redirect:/";
        } else {
            if (result.hasErrors()) {
                return "show/new";
            } else {
                User authenticatedUser = userService.findUserById(userId);
                show.setCreator(authenticatedUser);
                showService.updateOrCreate(show);
                return "redirect:/shows";
            }
        }
    }

    @GetMapping("/shows/{id}")
    public String viewShow(Model model, @PathVariable("id")Long id, HttpSession session){
        Long userId = ((Long) session.getAttribute("userId"));
        if(userId==null){
            return "redirect:/";
        }else{
            model.addAttribute("show",showService.findShow(id));
            model.addAttribute("userId",userId);
            return "show/details";
        }
    }

    @GetMapping("/shows/{id}/edit")
    public String viewEditIdea(Model model,@PathVariable("id")Long showId,HttpSession session){
        Long userId = ((Long) session.getAttribute("userId"));
        Show show=showService.findShow(showId);
        if(userId==null){
            return "redirect:/";
        }else{
            if(userId != show.getCreator().getId()){
                return "redirect:/shows";
            }
            model.addAttribute("show",show);

            session.setAttribute("showRaties", show.getRaties());
            session.setAttribute("averageRating",show.getAverageRating());
            return "show/edit";
        }
    }
    @PutMapping("/shows/{id}/edit")
    public  String editShow(@Valid @ModelAttribute("show")Show show,BindingResult result,HttpSession session,@PathVariable("id")Long showId) {
        Long userId = ((Long) session.getAttribute("userId"));
        Show testShow=showService.findShow(showId);
        if (userId == null) {
            return "redirect:/";
        } else {
            if(userId != testShow.getCreator().getId()){
                return "redirect:/shows";
            }
            if (result.hasErrors()) {
                return "show/edit";
            } else {

                User authenticatedUser = userService.findUserById(userId);
                show.setCreator(authenticatedUser);

                show.setRaties((List<User>) session.getAttribute("showRaties"));
                show.setAverageRating((Float) session.getAttribute("averageRating"));

                showService.updateOrCreate(show);
                return "redirect:/shows";
            }
        }
    }
    @DeleteMapping("/shows/{id}/delete")
    public String deleteShow(@PathVariable("id")Long showId,HttpSession session) {
        Long userId = ((Long) session.getAttribute("userId"));
        Show show = showService.findShow(showId);
        if (userId == null) {
            return "redirect:/";
        } else {
            if(userId != show.getCreator().getId()){
                return "redirect:/shows";
            }
            showService.deleteShow(showId);
            return "redirect:/shows";
        }
    }

    @PostMapping("/ideas/{id}/rating")
    public String likePost(@ModelAttribute("rating")Rating rating, @PathVariable("id")Long showId, HttpSession session){
        Long userId = ((Long) session.getAttribute("userId"));
        if (userId == null) {
            return "redirect:/";
        } else {
            ratingService.createRating(showId,userId);

            Show show =showService.findShow(showId);
            show.setAverageRating((float) show.getRaties().size());
            showService.updateOrCreate(show);

            return "redirect:/shows";
        }
    }
}




