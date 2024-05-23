package com.example.MusicBlog.CONTROLLERS;

//@Controller
public class UserController {

//    UserService userService;
//
//    public UserController (UserService userService){
//        this.userService=userService;
//    }
//
//    //CREATE A FORMS OF CRUD OPERATIONS.
//
//    @GetMapping("/Users/search")
//    public String searchUser(@RequestParam(value = "query") String query, Model model){
//        List<UsersDTO> usersDTOS = userService.searchUser(query);
//        model.addAttribute("user", usersDTOS);
//        return "Users-list";
//    }
//
//    @GetMapping("/Users/{UserId}")
//    public String UsersDetail(@PathVariable("UserId") Long UserId , Model model){
//        UsersDTO usersDTO = userService.findByUserId(UserId);
//        model.addAttribute("user", usersDTO);
//        return "Users-detail";
//
//    }
//
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new Users());
//        return "User-create";
//    }
//
//    @GetMapping("/Users/{UserId}/delete")
//    public String deleteClub(@PathVariable ("UserId") Long UserId){
//        userService.delete(UserId);
//        return "redirect:/Blog";
//
//    }
//
//
//    @PostMapping("/Users/Registration")
//    public String registerUser(@ModelAttribute("Users") Users user){
//        try {
//            userService.save(user);
//        }catch (Exception e){
//            throw new RuntimeException();
//        }
//
//        return "redirect:/Blog";
//    }
//
//    @GetMapping("/Users/{UserId}/edit")
//    public String editUserForm(@PathVariable("UserId") Long userId, Model model){
//        UsersDTO usersDTO = userService.findByUserId(userId);
//        model.addAttribute("Users",usersDTO);
//        return "Users-edit";
//    }
//
//    @PostMapping("/Users/{UserId}/edit")
//    public String updateUser(@PathVariable("UserId") Long userId ,
//                             @Valid @ModelAttribute("Users")UsersDTO users,
//                             BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            return "User-edit";
//        }
//        users.setId(userId);
//        userService.UpdateUser(users);
//        return "redirect:/Blog";
//    }


}
