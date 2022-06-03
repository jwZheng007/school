package com.example.demo.mapper;

import com.example.demo.pojo.Os;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
//    选择课题
    public void chooseOs(@RequestParam("os_id") int os_id, @RequestParam("stu_id") int stu_id);
//    查看课题
    public String checkOs(@RequestParam("stu_id") int stu_id);
//    提交开题报告
    public void submitOs(@RequestParam("stu_os") String stu_os, @RequestParam("stu_id") int stu_id);
//    提交毕业论文
    public void submitTheis(@RequestParam("theis") String theis, @RequestParam("stu_id") int stu_id);
//    获取所有选题
    public List<Os> viewOs_id();
}
