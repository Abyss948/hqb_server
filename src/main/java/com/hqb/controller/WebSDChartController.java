package com.hqb.controller;

import com.hqb.pojo.JsonResult;
import com.hqb.service.WebSDChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hqb.predict.MyLineRegression;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class WebSDChartController {
    @Autowired
    WebSDChartService webSDChartService;

    @GetMapping("getWebSDChart")
    public JsonResult<Object> getWebSDChart()
    {

            double[] X = new double[15];
            double[] Y = new double[15];

            for(int i = 0; i < 15; i++)
            {
                X[i] = i+1;
                if(webSDChartService.getWebProvideChart(15-i)!=null)
                Y[i] = webSDChartService.getWebProvideChart(15-i);
                else
                    Y[i]=0.0;
            }
            Map<String,Double> m = new HashMap<>(new MyLineRegression().lineRegression(X, Y));
           double a = m.get("a");
           double b = m.get("b");

            double t=a*16+b;
        Map<String ,Object> map_p = new HashMap<>();
        map_p.put("1",webSDChartService.getWebProvideChart(15));
        map_p.put("2",webSDChartService.getWebProvideChart(14));
        map_p.put("3",webSDChartService.getWebProvideChart(13));
        map_p.put("4",webSDChartService.getWebProvideChart(12));
        map_p.put("5",webSDChartService.getWebProvideChart(11));
        map_p.put("6",webSDChartService.getWebProvideChart(10));
        map_p.put("7",webSDChartService.getWebProvideChart(9));
        map_p.put("8",webSDChartService.getWebProvideChart(8));
        map_p.put("9",webSDChartService.getWebProvideChart(7));
        map_p.put("10",webSDChartService.getWebProvideChart(6));
        map_p.put("11",webSDChartService.getWebProvideChart(5));
        map_p.put("12",webSDChartService.getWebProvideChart(4));
        map_p.put("13",webSDChartService.getWebProvideChart(3));
        map_p.put("14",webSDChartService.getWebProvideChart(2));
        map_p.put("15",webSDChartService.getWebProvideChart(1));
        map_p.put("predict",t);
        for(int i = 0; i < 15; i++)
        {
            X[i] = i+1;
            if(webSDChartService.getWebNeedChart(15-i)!=null)
            Y[i] = webSDChartService.getWebNeedChart(15-i);
            else Y[i]=0;
        }
     m = new HashMap(new MyLineRegression().lineRegression(X, Y));
         a = m.get("a");
       b = m.get("b");

      t=a*16+b;
        Map<String ,Object> map_n = new HashMap<>();
        map_n.put("1",webSDChartService.getWebNeedChart(15));
        map_n.put("2",webSDChartService.getWebNeedChart(14));
        map_n.put("3",webSDChartService.getWebNeedChart(13));
        map_n.put("4",webSDChartService.getWebNeedChart(12));
        map_n.put("5",webSDChartService.getWebNeedChart(11));
        map_n.put("6",webSDChartService.getWebNeedChart(10));
        map_n.put("7",webSDChartService.getWebNeedChart(9));
        map_n.put("8",webSDChartService.getWebNeedChart(8));
        map_n.put("9",webSDChartService.getWebNeedChart(7));
        map_n.put("10",webSDChartService.getWebNeedChart(6));
        map_n.put("11",webSDChartService.getWebNeedChart(5));
        map_n.put("12",webSDChartService.getWebNeedChart(4));
        map_n.put("13",webSDChartService.getWebNeedChart(3));
        map_n.put("14",webSDChartService.getWebNeedChart(2));
        map_n.put("15",webSDChartService.getWebNeedChart(1));
        map_n.put("predict",t);
        for(int i = 0; i < 15; i++)
        {
            X[i] = i+1;
            if(webSDChartService.getWebSuccessChart(15-i)!=null)
            Y[i] = webSDChartService.getWebSuccessChart(15-i);
            else Y[i]=0;
        }
        m = new HashMap(new MyLineRegression().lineRegression(X, Y));
        a = m.get("a");
        b = m.get("b");

        t=a*16+b;
        Map<String ,Object> map_s = new HashMap<>();
        map_s.put("1",webSDChartService.getWebSuccessChart(15));
        map_s.put("2",webSDChartService.getWebSuccessChart(14));
        map_s.put("3",webSDChartService.getWebSuccessChart(13));
        map_s.put("4",webSDChartService.getWebSuccessChart(12));
        map_s.put("5",webSDChartService.getWebSuccessChart(11));
        map_s.put("6",webSDChartService.getWebSuccessChart(10));
        map_s.put("7",webSDChartService.getWebSuccessChart(9));
        map_s.put("8",webSDChartService.getWebSuccessChart(8));
        map_s.put("9",webSDChartService.getWebSuccessChart(7));
        map_s.put("10",webSDChartService.getWebSuccessChart(6));
        map_s.put("11",webSDChartService.getWebSuccessChart(5));
        map_s.put("12",webSDChartService.getWebSuccessChart(4));
        map_s.put("13",webSDChartService.getWebSuccessChart(3));
        map_s.put("14",webSDChartService.getWebSuccessChart(2));
        map_s.put("15",webSDChartService.getWebSuccessChart(1));
        map_s.put("predict",t);
        Map<String ,Object> map = new HashMap<>();
        map.put("provide",map_p);
        map.put("need",map_n);
        map.put("success",map_s);
        return new JsonResult<>(map);
    }
}
