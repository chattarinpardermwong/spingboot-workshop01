package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public PagingResponse getAllUser(@RequestParam(defaultValue ="1") int page,
                                          @RequestParam(name = "item_per_page",defaultValue = "10") int itemPerPage){
        PagingResponse pagingResponse = new PagingResponse(page, itemPerPage);
        List<UsersResponse> usersResponseList = new ArrayList<>();
        usersResponseList.add(new UsersResponse(1,"user1"));
        usersResponseList.add(new UsersResponse(2,"user2"));
        usersResponseList.add(new UsersResponse(3,"user3"));
        pagingResponse.setUsersResponseList(usersResponseList);
        return pagingResponse;
//        return usersResponseList;
    }

//    @GetMapping("/queryparam")
//    public String getQueryParam(@RequestParam(required = false, defaultValue ="1") int page,
//                                @RequestParam(required = false, defaultValue = "10") int item_per_page){
//        return "page: " + page + " item: " + item_per_page;
//    }


//    public UsersResponse[] getAllUser(){
//        UsersResponse[] usersResponses = new UsersResponse[2];
//        usersResponses[0] = new UsersResponse(1, "User 1");
//        usersResponses[1] = new UsersResponse(2, "User 2");
//        return usersResponses;
//    }

    @GetMapping("/users/{id}")
    public UsersResponse getUserById(@PathVariable int id){
        return new UsersResponse(id, "User " + id);
    }

    @PostMapping("/users")
    public UsersResponse createNewUser(@RequestBody NewUserRequest request){
        return new UsersResponse(0, request.getName() + request.getAge());
    }
}
