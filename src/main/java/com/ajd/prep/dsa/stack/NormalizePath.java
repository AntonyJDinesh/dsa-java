package com.ajd.prep.dsa.stack;

import java.util.Stack;

public class NormalizePath {
    public String simplifyPath(String path) {

        Stack<String> dirs = new Stack<>();

        for(String dir : path.split("/")) {
            switch(dir) {
                case ".":
                    break;
                case "":
                    break;
                case "..":
                    if(!dirs.isEmpty()) {
                        dirs.pop();
                    }
                    break;
                default:
                    dirs.push(dir);
            }
        }

        StringBuilder sb = new StringBuilder(path.length());
//        while(!dirs.isEmpty()) {
//            // res = "/" + dirs.pop() + res;
//            dirs.subList(0, dirs.size());
//            sb.append(dirs.pop() + "/" );
//        }

        for(String dir : dirs.subList(0, dirs.size())) {
            sb.append("/" + dir);
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }
}
