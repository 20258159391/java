package com.controller;

import com.pojo.Goods;
import com.pojo.Image;
import com.service.GoodsService;
import com.sun.deploy.net.HttpResponse;
import com.utils.Imageutil;
import lombok.extern.java.Log;
import org.apache.commons.io.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;



    @RequestMapping("/getallgoods")
    public String getAllGoods(Model model){
        List<Goods> goodsList=goodsService.getAllgoods();
        model.addAttribute("goods",goodsList);
//        for (Goods s:goodsList
//             ) {
//            System.out.println(s.toString());
//        }
        return "showgoods";
    }


    @RequestMapping("/getAllNosuidOrders")
    public String getAllNosuidOrders(Model model){
        List<Goods> goodsList=goodsService.getAllNosuidOrders();
        model.addAttribute("goods",goodsList);
        System.out.println(goodsList);
        return "showgoods";
    }


    @RequestMapping("/getAllsuidOrders")
    public String getAllsuidOrders(Model model){
        List<Goods> goodsList=goodsService.getAllsuidOrders();
        model.addAttribute("goods",goodsList);
        return "showgoods";
    }
    @RequestMapping("/upsuid")
    public String goods_upsuid(String id,Model model){
        System.out.println(id);
        int i = goodsService.updateGoods_suid(id);

        List<Goods> goodsList=goodsService.getAllgoods();
        model.addAttribute("goods",goodsList);
        return "showgoods";
    }

    @RequestMapping("/delsuid")
    public String goods_delsuid(String id,Model model){
        System.out.println(id);
        int i = goodsService.deleteGoods(id);

        List<Goods> goodsList=goodsService.getAllgoods();
        model.addAttribute("goods",goodsList);
        return "showgoods";
    }



    //用户


    @RequestMapping("/addGoods")
    @ResponseBody
    public String addGoods(Goods goods){
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = tempDate.format(new java.util.Date());
        goods.setList_date(datetime);
        int i = goodsService.addGoods(goods);
        if (i>0)
            return "添加成功";
        else
            return "添加失败";
    }
    @RequestMapping("/upload")
    public String goo(){

        return "goods_upload";
    }
    @RequestMapping(value = "/addgood",method = RequestMethod.POST)
    @ResponseBody
    public String addGood(@RequestParam String goods_name,@RequestParam String goods_info,
                          @RequestParam(required = false) MultipartFile image,
                          @RequestParam String goods_price
                          ){
        System.out.println(image);
        String imageSuffix = Imageutil.getImageSuffix(image);
        String newFileName = Imageutil.getNewFileName(imageSuffix);
        String newImagePath = Imageutil.getNewImagePath(newFileName);
        File file = new File(newImagePath);
        boolean b = Imageutil.saveImage(image, file);
        return "上传成功";
    }


    @PostMapping("/addfiles")
    public String addfiles(MultipartFile myfile) throws IOException {

        String imageSuffix = Imageutil.getImageSuffix(myfile);
        String newFileName = Imageutil.getNewFileName(imageSuffix);
        String newImagePath = Imageutil.getNewImagePath(newFileName);
        File file = new File(newImagePath);
        boolean b = Imageutil.saveImage(myfile, file);
        if (b){
            System.out.println("上传成功");
        }else {
            System.out.println("上传失败");
        }


        //指定路径时必须指定文件的名称，否则无法访问
//        String image_path="D:\\Program Files (x86)\\shtp_photoes\\1.txt";

        //淘汰了
//        //1.获取照片的输入流
//        InputStream inputStream = myfile.getInputStream();
//        //2.获取照片的输出流
//        OutputStream outputStream=new FileOutputStream(image_path);
//        //3.将照片拷贝到指定目录下
//        CopyUtils.copy(inputStream,outputStream);
//        System.out.println(myfile);

        return "";
    }


}
