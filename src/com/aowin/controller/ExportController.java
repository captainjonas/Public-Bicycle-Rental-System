package com.aowin.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aowin.model.Station;
import com.aowin.service.OrderService;
import com.aowin.service.StationService;
import com.aowin.util.ExcelUtil;

@Controller
@RequestMapping("/put/*")
public class ExportController {
@Resource
private OrderService orderService;
@Resource
private StationService stationService;
	
@RequestMapping(value="export.do",method=RequestMethod.POST)
@ResponseBody
public int exportData(HttpServletRequest request,HttpServletResponse response) throws IOException{
	String time=request.getParameter("time");
	Map<String,Object> map=new HashMap<String,Object>();
	map.put("time", time);
	int bikeNum=orderService.getBikeNum(map);
	List<Station> stationList=new ArrayList<Station>();
	stationList=stationService.summary(map);
	Date date=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	String fileName="统计"+sdf.format(date);
	String filePath="C://Users//Eric//workspace//bike//summary//"+fileName+".xls";
	String year=time.replaceAll("-", "年");
	String[] deadtime={"截止到"+year+"月:"};
	String[] num={"车辆总数：",bikeNum+"辆"};
	String[] piles={"站点车桩如下所示："};	
	String[] titles={"站点ID","编号","名称","经度","纬度","车桩数量","地址","新建日期","运行日期",
			"车桩ID","车桩编号","安装日期"};
	Map<Integer,String[]> content=new HashMap<Integer,String[]>();
	content.put(0, deadtime);
	content.put(1, num);
	content.put(2, piles);
	content.put(3, titles);
	ExcelUtil.writeExcel(filePath,content, stationList);
	return 1;
}

}
