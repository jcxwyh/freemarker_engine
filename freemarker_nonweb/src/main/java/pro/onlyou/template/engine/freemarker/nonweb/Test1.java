package pro.onlyou.template.engine.freemarker.nonweb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import pro.onlyou.template.engine.freemarker.nonweb.directive.MyDirective;
import pro.onlyou.template.engine.freemarker.nonweb.directive.RepeatDirective;
import pro.onlyou.template.engine.freemarker.nonweb.method.MyMethodModel;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) throws IOException, TemplateException {
        //根据版本创建配置,2.3.0之后
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setDirectoryForTemplateLoading(new File("freemarker_nonweb/templates"));

        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setWrapUncheckedExceptions(true);

        Map<String,Object> root = new HashMap<>();
        root.put("user","jcx");
        root.put("date",new Date());
        // 使用自定义的方法
        root.put("indexOf",new MyMethodModel());
        // 使用自定义的Directive
        root.put("upper",new MyDirective());
        root.put("repeat",new RepeatDirective());

        Template template = configuration.getTemplate("test.ftl");

        Writer writer = new OutputStreamWriter(System.out);

        template.process(root,writer);

    }
}
