package com.shanggushenlong.springbootweb.springboot_fileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/** springboot实现文件上传
 * @USER: shanggushenlong
 * @DATE: 2020/5/14
 * @PROJECT_NAME: springboot-web
 **/
@Controller
public class FileUploaderController {

    /**
     * 单文件上传，使用post请求
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public String fileupload(MultipartFile file){

        // 获取文件的文件名
        String oldName = file.getOriginalFilename();
        // 文件上传，保存为新的文件名
        if (!"".equals(oldName) && oldName != null){
            // 获取文件后缀
            String suffixFileName = oldName.substring(oldName.lastIndexOf("."));

            // 设置文件保存的文件夹
            SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
            String filePath = "C:/Users/wuchaoqun/Desktop/springboot" + sdf.format(new Date()) + "/" + UUID.randomUUID() + suffixFileName;
            File dest = new File(filePath);
            // 判断文件夹是否存在
            if (!dest.exists()){
                dest.mkdirs();
            }

            try {
                // 文件写入
                file.transferTo(dest);
                return filePath;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "文件上传失败";
    }


    /**
     * 多文件上传（只是比单文件上传多了一个循环）
     * @param files 文件集合
     * @return
     */
    @PostMapping("/uploads")
    @ResponseBody
    public String fileUploadMultipart(MultipartFile[] files, HttpServletRequest request){

//        HttpSession session = request.getSession();
//        System.out.println(session);
//        ServletContext servletContext = session.getServletContext();
//        System.out.println(servletContext);
//        String context = servletContext.getRealPath("context");
//        System.out.println(context);

        List<String> list = new ArrayList<String>();
        for (int i = 0; i< files.length; i++){
            String url = fileupload(files[i]);
            list.add(url);
        }

        return list.toString();
    }
}
