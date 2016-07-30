package com.palindrome.view;

/**
 *
 * @author suleimanalrosan - Jul 29, 2016
 */
public class PalindromeResponse{

    private String name;
    private Long count;

    public PalindromeResponse() {
    }

    public PalindromeResponse(String name, Long count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
