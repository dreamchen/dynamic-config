package com.by.dynamic.config.web.controller.demo;

import com.by.dynamic.config.domain.DemoDomain;
import com.by.dynamic.config.service.DemoService;
import com.by.dynamic.config.service.impl.DynamicBeanImpl;
import com.by.dynamic.config.web.controller.BaseController;
import com.by.dynamic.config.web.controller.JsonData;
import com.by.dynamic.config.web.util.DisconfDataGetter;
import com.by.dynamic.config.web.util.PropertiesUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * Created by Erlei Chen on 2016/12/28.
 */
@RequestMapping("/demo")
@Controller
public class DemoController extends BaseController {

    private static PropertiesUtils propertiesUtils = new PropertiesUtils("/prop/common.properties");

    @Resource
    private DemoService demoService;
    @Resource
    private DynamicBeanImpl dynamicBean;


    @RequestMapping("testFile")
    @ResponseBody
    public JsonData testFile(String filePath) {
        JsonData jsonData = new JsonData(JsonData.FAILED);
        jsonData.setMethod("testFile");
        try {
            File f = new File(filePath);
            jsonData.setData(f);
            jsonData.setStatus(JsonData.SUCCESS);
        } catch (Exception e) {
            jsonData.setErrorCode("10000");
            jsonData.setErrorMessage(e.toString());
//            e.printStackTrace();
        }
        return jsonData;
    }


    @RequestMapping("testDynamicBean")
    @ResponseBody
    public JsonData testDynamicBean() {
        JsonData jsonData = new JsonData(JsonData.FAILED);
        jsonData.setMethod("testDynamicBean");
        try {
            dynamicBean.sayHello();
            jsonData.setData("success");
            jsonData.setStatus(JsonData.SUCCESS);
        } catch (Exception e) {
            jsonData.setErrorCode("10000");
            jsonData.setErrorMessage(e.toString());
//            e.printStackTrace();
        }
        return jsonData;
    }

    @RequestMapping("getDemoList")
    @ResponseBody
    public JsonData getDemoList() {
        JsonData jsonData = new JsonData(JsonData.FAILED);
        jsonData.setMethod("getDemoList");
        try {
            List<DemoDomain> list = this.demoService.getDemoList();
            jsonData.setData(list);
            jsonData.setStatus(JsonData.SUCCESS);
        } catch (Exception e) {
            jsonData.setErrorCode("10000");
            jsonData.setErrorMessage(e.toString());
//            e.printStackTrace();
        }
        return jsonData;
    }

    @RequestMapping("getProperties")
    @ResponseBody
    public JsonData getProperties(String key) {
        JsonData jsonData = new JsonData(JsonData.FAILED);
        jsonData.setMethod("getProperties");
        try {
            String value = this.propertiesUtils.getProperty(key);
            jsonData.setData(value);
            jsonData.setStatus(JsonData.SUCCESS);
        } catch (Exception e) {
            jsonData.setErrorCode("10000");
            jsonData.setErrorMessage(e.toString());
//            e.printStackTrace();
        }
        return jsonData;
    }

    @RequestMapping("getDisProperties")
    @ResponseBody
    public JsonData getDisProperties(String path, String key) {
        JsonData jsonData = new JsonData(JsonData.FAILED);
        jsonData.setMethod("getDisProperties");
        try {
            String value = DisconfDataGetter.getByFileItem(path, key).toString();
            jsonData.setData(value);
            jsonData.setStatus(JsonData.SUCCESS);
        } catch (Exception e) {
            jsonData.setErrorCode("10000");
            jsonData.setErrorMessage(e.toString());
//            e.printStackTrace();
        }
        return jsonData;
    }

    @RequestMapping("doDynamicBean")
    @ResponseBody
    public JsonData doDynamicBean() {
        JsonData jsonData = new JsonData(JsonData.FAILED);
        jsonData.setMethod("doDynamicBean");
        try {
            this.dynamicBean.sayHello();
            jsonData.setData("do dyanmicBean say success!");
            jsonData.setStatus(JsonData.SUCCESS);
        } catch (Exception e) {
            jsonData.setErrorCode("10000");
            jsonData.setErrorMessage(e.toString());
//            e.printStackTrace();
        }
        return jsonData;
    }

    @RequestMapping(value = "regbean.do")
    public void regBean() {
//        ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
//        ConfigurableApplicationContext context = (ConfigurableApplicationContext) ac;
//        //Bean的实例工厂
//        DefaultListableBeanFactory dbf = (DefaultListableBeanFactory) context.getBeanFactory();
//        //Bean构建  BeanService.class 要创建的Bean的Class对象
//        BeanDefinitionBuilder dataSourceBuider = BeanDefinitionBuilder.genericBeanDefinition(DynamicBeanImpl.class);
//        //向里面的属性注入值，提供get set方法
//        dataSourceBuider.addPropertyValue("msg", "hello ");
//        //dataSourceBuider.setParentName("");  同配置 parent
//        //dataSourceBuider.setScope("");   同配置 scope
//        //将实例注册spring容器中   bs 等同于  id配置
//        dbf.registerBeanDefinition("bs", dataSourceBuider.getBeanDefinition());
//
//        //注要使用刚注册的 必须通过   getBean("xx")的方式
//        //这种方式还多用于在过滤器中获取容器对象，因为spring不能为过滤器注入任何属性
    }

    @RequestMapping(value = "regbean2.do")
    public void regBean(HttpServletRequest request) {
//        ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
//        ConfigurableApplicationContext context = (ConfigurableApplicationContext) ac;
//        //Bean的实例工厂
//        DefaultListableBeanFactory dbf = (DefaultListableBeanFactory) context.getBeanFactory();
//        //Bean构建  BeanService.class 要创建的Bean的Class对象
//        BeanDefinitionBuilder dataSourceBuider = BeanDefinitionBuilder.genericBeanDefinition(BeanService.class);
//        //向里面的属性注入值，提供get set方法
//        dataSourceBuider.addPropertyValue("msg", "hello ");
//        //dataSourceBuider.setParentName("");  同配置 parent
//        //dataSourceBuider.setScope("");   同配置 scope
//        //将实例注册spring容器中   bs 等同于  id配置
//        dbf.registerBeanDefinition("bs", dataSourceBuider.getBeanDefinition());
//
//        //注要使用刚注册的 必须通过   getBean("xx")的方式
//        //这种方式还多用于在过滤器中获取容器对象，因为spring不能为过滤器注入任何属性
    }

    public void regBean3() {
//        ApplicationContext ctx = (ApplicationContext) ActionContext.getContext().getApplication().get(
//                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//        DefaultListableBeanFactory acf = (DefaultListableBeanFactory) ctx
//                .getAutowireCapableBeanFactory();
//
//        ApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletContext sc);
//
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
//        ServletContext servletContext = webApplicationContext.getServletContext();
//
//        ServletContext application = ServletActionContext.getServletContext();
//        ApplicationContext act = ContextLoader.getCurrentWebApplicationContext();
//        UserService userService = (UserService) act.getBean("userService");

//        动态装配
//        上面的装配都是我们在配置文件中进行配置,框架会加载配置文件,然后向它的工厂中加入对应的对象,我们通过getBean来获得对象,但这些对象都是事先定义好的,我们有时候要在程序中动态的加入对象.因为如果采用配置文件,我们要加入对象的话,还要重启服务,如果我们想要避免这一情况就得采用动态处理bean,包括:动态注入,动态删除;
//        动态注入
//        ApplicationContext ctx = (ApplicationContext) ActionContext.getContext().getApplication().get(
//                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//        DefaultListableBeanFactory acf = (DefaultListableBeanFactory) ctx
//                .getAutowireCapableBeanFactory();
//        先得到工厂.
//                XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource(
//                newFile));
//        再得到要加入的新bean所在的工厂.因为新的bean可能是在一个文件中描述的.所以可以通过这种方法来得到,当然如果有其他方式也可以,这里得到这个factory是为了方便下面得到它的定义:definition.
//                acf.registerBeanDefinition(beanId, factory.getMergedBeanDefinition(beanId));
//        再注入新的bean.这里要传入一个beanId就是我们以后要通过getBean(beanId)来得到对象中的beanId.另外还要一个该bean的definition.通过前面的factory中获得.
//                这样就动态注入了.
//                动态删除
//        ApplicationContext ctx = (ApplicationContext) ActionContext.getContext()             .getApplication().get(                 WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//        DefaultListableBeanFactory acf = (DefaultListableBeanFactory) ctx.getAutowireCapableBeanFactory();
//        if(acf.containsBean(beanId)) {
//            acf.removeBeanDefinition(beanId);
//        }

    }
}
