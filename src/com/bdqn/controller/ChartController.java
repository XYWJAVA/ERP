package com.bdqn.controller;

import java.awt.Font;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ��������ͳ��ͼ��
 */
@Controller
@RequestMapping("/") //ָ������������ռ��ǰ׺
public class ChartController{

    @RequestMapping(value = "/getChart.do")
    public ModelAndView getMajorChart(HttpServletRequest request,
            HttpServletResponse response, ModelMap modelMap) throws Exception{

/*        JFreeChart chart = ChartFactory.createBarChart3D("ˮ������ͼ", // ͼ�����
                "ˮ��", // Ŀ¼�����ʾ��ǩ
                "����", // ��ֵ�����ʾ��ǩ
                getDataSet1(), // ���ݼ�
                PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
                true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
                false, // �Ƿ����ɹ���
                false // �Ƿ�����URL����
                );
        
        //������״ͼ������
        getChartByFont(chart);*/
        
      //�����Ǳ�״ͼ
        JFreeChart chart = ChartFactory.createPieChart3D(
				 "ͼ��ͳ��ͼ", // ͼ�����
				 getDataSet3(), // ����
				 true, // �Ƿ���ʾͼ��
				 false, // �Ƿ���ʾ������ʾ
				 false // �Ƿ����� URL
				 );
		 
        
        String fileName = ServletUtilities.saveChartAsJPEG(chart, 400, 300, null, request.getSession());
        String chartURL=request.getContextPath() + "/chart?filename="+fileName;
        modelMap.put("chartURL", chartURL);
        return new ModelAndView("chart",modelMap);
    }
    //������״ͼ������
    private static void getChartByFont(JFreeChart chart) {
        TextTitle textTitle = chart.getTitle();   
            textTitle.setFont(new Font("����",Font.BOLD,20));
            LegendTitle legend = chart.getLegend();   
            if (legend!=null) {   
            legend.setItemFont(new Font("����", Font.BOLD, 20));   
            } 
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            CategoryAxis axis = plot.getDomainAxis();
                //����X�������ϱ��������
                axis.setLabelFont(new Font("����",Font.BOLD,22));
                //����X�������ϵ����֣�
                axis.setTickLabelFont(new Font("����",Font.BOLD,12));
           
                ValueAxis valueAxis = plot.getRangeAxis();
                //����Y�������ϱ��������
                valueAxis.setLabelFont(new Font("����",Font.BOLD,12));
                //����Y�������ϵ�����
                valueAxis.setTickLabelFont(new Font("sans-serif",Font.BOLD,12));
    }

    /**
     * ��ȡһ����ʾ�õļ����ݼ�����
     * 
     * @return
     */
    private static CategoryDataset getDataSet1() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "", "ƻ��");
        dataset.addValue(200, "", "����");
        dataset.addValue(300, "", "����");
        dataset.addValue(400, "", "�㽶");
        dataset.addValue(500, "", "��֦");
        return dataset;
    }

    /**
     * ��ȡһ����ʾ�õ�������ݼ�����
     * 
     * @return
     */
    private static CategoryDataset getDataSet2() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, "����", "ƻ��");
        dataset.addValue(100, "�Ϻ�", "ƻ��");
        dataset.addValue(100, "����", "ƻ��");
        dataset.addValue(200, "����", "����");
        dataset.addValue(200, "�Ϻ�", "����");
        dataset.addValue(200, "����", "����");
        dataset.addValue(300, "����", "����");
        dataset.addValue(300, "�Ϻ�", "����");
        dataset.addValue(300, "����", "����");
        dataset.addValue(400, "����", "�㽶");
        dataset.addValue(400, "�Ϻ�", "�㽶");
        dataset.addValue(400, "����", "�㽶");
        dataset.addValue(500, "����", "��֦");
        dataset.addValue(500, "�Ϻ�", "��֦");
        dataset.addValue(500, "����", "��֦");
        return dataset;
    }
    
    //�õ���״ͼ�����ݼ�
    private DefaultPieDataset getDataSet3() {
    	
    	DefaultPieDataset dataset = new DefaultPieDataset();
    	
    	dataset.setValue("��� Java ����", 47000);
		dataset.setValue("������ Java EE ��ҵʵս", 38000);
		dataset.setValue("��� Ajax ����", 31000);
		dataset.setValue("Struts 2 Ȩ��ָ��", 29000);
		dataset.setValue("��� XML ����", 25000);
		return dataset;
    	
    }
}